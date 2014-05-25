package com.openrdf.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.openrdf.action.SearchAction;
import com.openrdf.beans.ConceptStore;
import com.openrdf.beans.SearchHistory;

public class SearchDao extends HibernateDaoSupport {

	private Logger logger = Logger.getLogger(SearchDao.class);
	
	/**
	 * 通过关键字搜索保存记录
	 * 
	 * @param keyword
	 * @param userName
	 * @return
	 */
	public boolean searchKeyWord(SearchHistory searchHistory) {

		// 保存历史记录 
		this.getHibernateTemplate().save(searchHistory);
		// 处理搜索统计 
		return true;
	}
	
	/**
	 * 获取是否已经收藏
	 * 
	 * @param conceptStore
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ConceptStore> getIsStore(ConceptStore conceptStore) {

		String queryString = " From ConceptStore where keyword = ? and userId = ?";
		Object[] objects = { conceptStore.getKeyword(), conceptStore.getUserId() };
		return this.getHibernateTemplate().find(queryString, objects);
	}

	/**
	 * 保存收藏
	 * 
	 * @param conceptStore
	 */
	public void saveStore(ConceptStore conceptStore) {
		try {
			this.getHibernateTemplate().save(conceptStore);
		} catch (Exception e) {
			logger.info("收藏保存异常：" + e);
		}
	}

}
