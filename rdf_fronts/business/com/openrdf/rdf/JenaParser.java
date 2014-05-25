package com.openrdf.rdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.sparql.pfunction.library.concat;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.VCARD;
import com.openrdf.beans.Concept;
import com.openrdf.utils.properties.URLPropertiesUtils;

public class JenaParser {

	private Logger logger = Logger.getLogger(JenaParser.class);

	/**
	 * http://blog.csdn.net/prstaxy/article/details/7849226
	 * 
	 * 
	 * @param concept
	 * @return
	 */
	// add concept item
	public boolean AddConcept2RDF(Concept concept) {
		// get rdf file location
		String filePath = URLPropertiesUtils
				.getPropertiesUrl(URLPropertiesUtils.RDF_FILE_LOCATION);

		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// create inputStream
		InputStream in = FileManager.get().open(filePath);
		if (in == null) {
			throw new IllegalArgumentException("File: " + filePath
					+ " not found.");
		}

		// read the RDF/XML file
		model.read(in, "", "RDF/XML");

		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.write(System.out, "RDF/XML");

		// build rdf_about
		String rdf_about = "";
		if (concept.getEnName() != null) {
			rdf_about = "http://www.166801.com/source#" + concept.getEnName();
		} else {
			rdf_about = "http://www.166801.com/source#" + concept.getCnName();
		}

		// create the resource
		Resource r = model.createResource(rdf_about);

		// add the property
		r.addLiteral(VCARD.BDAY, concept.getBday())
				.addProperty(VCARD.N, model.createResource())
				.addProperty(VCARD.NAME,
						model.createLiteral(concept.getEnName(), "en"))
				.addProperty(VCARD.NAME,
						model.createLiteral(concept.getCnName(), "zh-cn"))
				.addProperty(VCARD.SOURCE,
						model.createLiteral(concept.getSource(), true));

		// write to RDF file
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream(filePath);
			// 写入编码
			outputStream.write("<?xml version='1.0' encoding='UTF-8'?>\r\n\r\n"
					.getBytes());
			// model.write(new PrintWriter(outputStream), "RDF/XML");
			model.write(new PrintWriter(new OutputStreamWriter(outputStream,
					"UTF-8"), true), "RDF/XML");
			outputStream.flush();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				outputStream.close();
				model.close();
			} catch (IOException e) {
			}
		}
		return false;
	}

	// select concept by keyword
	public List<Concept> SearchByKeyword(String keyword) {

		// get rdf file location
		String filePath = URLPropertiesUtils
				.getPropertiesUrl(URLPropertiesUtils.RDF_FILE_LOCATION);

		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// create inputStream
		InputStream in = FileManager.get().open(filePath);
		if (in == null) {
			throw new IllegalArgumentException("File: " + filePath
					+ " not found.");
		}

		// read the RDF/XML file
		model.read(in, "", "RDF/XML");

		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Create a new query
		// String queryString =
		// "SELECT *                                            "
		// +
		// "WHERE {                                                           "
		// + " ?x  <http://www.w3.org/2001/vcard-rdf/3.0#NAME>  ?Y         "
		// + "   }";
		// String queryString =
		// "SELECT *                                            "
		// +
		// "WHERE {                                                           "
		// + " ?x  <http://www.w3.org/2001/vcard-rdf/3.0#NAME>  ?y       "
		// + "filter regex(str(?y), \"memory\", \"i\")"
		// + "   }";
		// 11.4.5
		String queryString = "DESCRIBE *                                            "
				+ "WHERE {                                                           "
				+ " ?x  <http://www.w3.org/2001/vcard-rdf/3.0#NAME>  ?y       "
				+ "filter regex(str(?y), \"" + keyword + "\", \"i\")" + "   }";

		Query query = QueryFactory.create(queryString);

		// Execute the query and obtain results
		QueryExecution qe = QueryExecutionFactory.create(query, model);
		// ResultSet results = qe.execSelect();
		Model resultModel = qe.execDescribe();

		// resultModel.write(System.out, "N-TRIPLE");

		// resultModel.write(System.out, "");

		List<Concept> conceptList = new ArrayList<Concept>();
		Concept concept = new Concept();
		StmtIterator stmtIterator = resultModel.listStatements();
		// 声明计数器
		int i = 0;
		while (stmtIterator.hasNext()) {
			Statement statement = stmtIterator.nextStatement();
			Property predicate = statement.getPredicate();
			if (predicate.toString().contains(
					"http://www.w3.org/2001/vcard-rdf/3.0#BDAY")) {
				String bday = statement.getAlt().toString().substring(1, 10);
				concept.setBday(bday);
			} else if (predicate.toString().contains(
					"http://www.w3.org/2001/vcard-rdf/3.0#NAME")) {
				String name = statement.getAlt().toString();
				if (name.contains("@en")) {
					String enName = name.substring(1, name.indexOf("@") - 1);
					concept.setEnName(enName);
				} else if (name.contains("@zh-cn")) {
					String cnName = name.substring(1, name.indexOf("@") - 1);
					concept.setCnName(cnName);
				}
			} else if (predicate.toString().contains(
					"http://www.w3.org/2001/vcard-rdf/3.0#SOURCE")) {
				String source = statement.getAlt().toString();
				source = (String) source.subSequence(1,
						source.indexOf("^^") - 1);
				concept.setSource(source);
			}
			// 当获取前5个节点时，保存一次
			if (++i % 5 == 0) {
				conceptList.add(concept);
				concept = new Concept();
			}
		}
		qe.close();
		resultModel.close();
		return conceptList;
	}

	// select all concept
	public List<Concept> listConcept() {

		// get rdf file location
		String filePath = URLPropertiesUtils
				.getPropertiesUrl(URLPropertiesUtils.RDF_FILE_LOCATION);

		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// create inputStream
		InputStream in = FileManager.get().open(filePath);
		if (in == null) {
			throw new IllegalArgumentException("File: " + filePath
					+ " not found.");
		}

		// read the RDF/XML file
		model.read(in, "", "RDF/XML");

		try {
			in.close();
		} catch (IOException e) {
		}

		List<Concept> conceptList = new ArrayList<Concept>();
		Concept concept = new Concept();
		StmtIterator stmtIterator = model.listStatements();
		// 声明计数器
		int i = 0;
		while (stmtIterator.hasNext()) {
			Statement statement = stmtIterator.nextStatement();
			Property predicate = statement.getPredicate();
			if (predicate.toString().contains(
					"http://www.w3.org/2001/vcard-rdf/3.0#BDAY")) {
				String bday = statement.getAlt().toString().substring(1, 10);
				concept.setBday(bday);
			} else if (predicate.toString().contains(
					"http://www.w3.org/2001/vcard-rdf/3.0#NAME")) {
				String name = statement.getAlt().toString();
				if (name.contains("@en")) {
					String enName = name.substring(1, name.indexOf("@") - 1);
					concept.setEnName(enName);
				} else if (name.contains("@zh-cn")) {
					String cnName = name.substring(1, name.indexOf("@") - 1);
					concept.setCnName(cnName);
				}
			} else if (predicate.toString().contains(
					"http://www.w3.org/2001/vcard-rdf/3.0#SOURCE")) {
				String source = statement.getAlt().toString();
				source = (String) source.subSequence(1,
						source.indexOf("^^") - 1);
				concept.setSource(source);
			}
			// 当获取前5个节点时，保存一次
			if (++i % 5 == 0) {
				conceptList.add(concept);
				concept = new Concept();
			}
		}
		model.close();
		return conceptList;
	}


}
