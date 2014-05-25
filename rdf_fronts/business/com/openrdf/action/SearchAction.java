package com.openrdf.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.openrdf.base.action.OpenRDFBaseAction;
import com.openrdf.beans.Concept;
import com.openrdf.beans.ConceptStore;
import com.openrdf.service.SearchService;
import com.openrdf.utils.Utils;
import com.opensymphony.xwork2.ActionContext;

public class SearchAction extends OpenRDFBaseAction  {

	private Logger logger = Logger.getLogger(SearchAction.class);
	private SearchService searchService;
	// 返回信息
	private String resultMessage;
	// search keywords
	private String keywords;
	// 返回搜索信息
	private List<Concept> conceptList;
	

	public String searchAction() {
		
		// 转码字符串
		keywords = Utils.str(keywords);
		logger.info("搜索关键字：" + keywords);
		if (keywords.equalsIgnoreCase("")) {
			resultMessage = "请输入关键字。";
			conceptList = null;
			return "error";
		}
		
		// 获取用户名
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		String userName = (String) session.get("userName");
		if (userName == null) {
			userName = "未登录用户";
		}

		conceptList = searchService.searchKeyWord(keywords, userName);
		if (conceptList.size() == 0) {
			resultMessage = "您搜索的关键字不存在。";
			conceptList = null;
			return "error";
		} else {
			resultMessage = "success";
			// keyword = "";
			for (int i = 0; i < conceptList.size(); i++) {
				logger.info("第" + i + "个：\n名词（cn）："
						+ conceptList.get(i).getCnName() + "\n名词（en）："
						+ conceptList.get(i).getEnName() + "\n定义："
						+ conceptList.get(i).getSource() + "\n更新时间："
						+ conceptList.get(i).getBday());
			}
		}
		return "success";
		
	}
	
	/**
	 * 保存收藏词条 ajax 
	 * 
	 * @return
	 */
	public String storeAction() {
		/** 获取response对象 */
		HttpServletResponse response = ServletActionContext.getResponse();
		/** 获取输出out对象 */
		PrintWriter out;
		try {
			out = response.getWriter();
			// 获取用户名
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			String userName = (String) session.get("userName");
			if (userName == null) {
				out.write("please, login in!");
				return null;
			}
			keywords = Utils.str(keywords);
			logger.info("收藏词条：" + keywords);

			// 生成收藏实体
			ConceptStore conceptStore = new ConceptStore();
			conceptStore.setKeyword(keywords);
			conceptStore.setStoreTime(Utils.getDateTime());
			conceptStore.setUserId(userName);
			conceptStore.setOther("");
			conceptStore.setId(null);

			boolean state = searchService.storeAction(conceptStore);
			logger.info("收藏是否成功：" + !state);
			if (!state) {
				out.print("恭喜您，收藏词条" + keywords + "成功!");
			} else {
				out.print("对不起，不能重复收藏。");
			}
		} catch (IOException e) {
		}
		return null;
	}
	
	/***                   getters and setters                       ***/
	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public List<Concept> getConceptList() {
		return conceptList;
	}

	public void setConceptList(List<Concept> conceptList) {
		this.conceptList = conceptList;
	}
	
}
