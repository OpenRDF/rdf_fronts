package com.openrdf.dbpedia;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.openrdf.beans.DBPedia;
import com.openrdf.utils.Utils;
import com.openrdf.utils.properties.URLPropertiesUtils;
import com.openrdf.utils.rest.client.RESTClient;

public class DBPediaOpt extends DefaultHandler {

	private Logger logger = Logger.getLogger(DBPediaOpt.class);

	private List<DBPedia> dbpediaList = null;
	private DBPedia dbPedia = null;

	public List<DBPedia> getDBPediaByKeyword(String keywords) throws Exception {

		List<DBPedia> dbpediaList = new ArrayList<DBPedia>();
		// 获取调用地址
		String url = URLPropertiesUtils
				.getPropertiesUrl(URLPropertiesUtils.DBPedia_API_URL)
				+ keywords;
		// 调用接口 获取dbpedia返回值
		RESTClient restClient = new RESTClient();
		String dbpediaXML = restClient.RESTGET(url);
		InputStream inputStream = null;
		try {
			dbpediaXML = new String(dbpediaXML.getBytes("ISO-8859-1"), "UTF-8");
			inputStream = new ByteArrayInputStream(dbpediaXML.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
//			e1.printStackTrace();
			throw new Exception("接口异常");
		}
		// DOM4J解析XML文件
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(inputStream);
			Element root = document.getRootElement();
			for (Iterator<?> i = root.elementIterator(); i.hasNext();) {
				Element node = (Element) i.next();
				DBPedia dbPedia = new DBPedia();
				Element labelElement = node.element("Label");
				dbPedia.setLabel(labelElement.getText());
				Element URIElement = node.element("URI");
				dbPedia.setUrl(URIElement.getText());
				Element descriptionElement = node.element("Description");
				dbPedia.setDescription(descriptionElement.getText());
				logger.info(dbPedia.getLabel() + dbPedia.getUrl()
						+ dbPedia.getDescription());
				dbpediaList.add(dbPedia);
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return dbpediaList;
	}
}
