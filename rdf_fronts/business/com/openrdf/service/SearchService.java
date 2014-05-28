package com.openrdf.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.openrdf.beans.Concept;
import com.openrdf.beans.ConceptStore;
import com.openrdf.beans.DBPedia;
import com.openrdf.beans.SearchHistory;
import com.openrdf.dao.SearchDao;
import com.openrdf.dbpedia.DBPediaOpt;
import com.openrdf.rdf.JenaParser;
import com.openrdf.utils.Utils;

public class SearchService {

	private SearchDao searchDao;
	private Logger logger = Logger.getLogger(SearchService.class);
	
	/**
	 * 搜索关键字 
	 * 
	 * @param keyword
	 * @param userName 
	 * @return
	 */
	public List<Concept> searchKeyWord(String keyword, String userName) {
		// 对RDF文件搜索
		JenaParser jenaParser = new JenaParser();
		List<Concept> conceptList = jenaParser.SearchByKeyword(keyword);
		if (conceptList == null){
			return null;
		}
		// 保存搜索记录 
		SearchHistory searchHistory = new SearchHistory();
		searchHistory.setKeyword(keyword);
		searchHistory.setSerachTime(Utils.getDateTime());
		searchHistory.setWhoSearch(userName);
		searchHistory.setId(null);
		System.out.println(keyword);
		if (conceptList.size() == 0){
			// 查询失败 
			searchHistory.setOther("0");
		}else{
			// 查询成功
			searchHistory.setOther("1");
		}
		searchDao.searchKeyWord(searchHistory);
		return conceptList;
	}
	
	/**
	 * 保存收藏 
	 * 
	 * @param keyword
	 * @param userName
	 * @return 
	 */
	public boolean storeAction(ConceptStore conceptStore) {
		// 判断该用户是否收藏该词条 
		if(searchDao.getIsStore(conceptStore).size() == 0){
			// 保存收藏 
			searchDao.saveStore(conceptStore);
			return false;
		}else{
			return true;
		}
	}

	public List<DBPedia> advanceSearch(String keywords) {
		
		DBPediaOpt dbPediaOpt = new DBPediaOpt();
		List<DBPedia> dbpediaList = dbPediaOpt.getDBPediaByKeyword(keywords);
		if (dbpediaList == null || dbpediaList.size() == 0){
			return null;
		}
		return dbpediaList;
	}
	/***                   getters and setters                       ***/
	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

	
}
