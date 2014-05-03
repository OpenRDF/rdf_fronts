package com.openrdf.action.base;

import com.openrdf.utils.url.properties.URLPropertiesUtils;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {

	/**
	 * BaseAction 
	 */
	private static final long serialVersionUID = 1L;
	private String RDF_CAS_HREF = "";

	public String toRegisterPage(){
		// redirect to register page
		return "success";
	}
	
	public String toLoginPage(){
		// redirect to login page 
		RDF_CAS_HREF = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
		return "success";
	}
	
	// ==================== getters and setters ===========================//
	public void setRDF_CAS_HREF(String rDF_CAS_HREF) {
		RDF_CAS_HREF = rDF_CAS_HREF;
	}

	public String getRDF_CAS_HREF() {
		return RDF_CAS_HREF;
	}
}
