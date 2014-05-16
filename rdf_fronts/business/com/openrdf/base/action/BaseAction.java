package com.openrdf.base.action;

import com.openrdf.utils.url.properties.URLPropertiesUtils;

public class BaseAction extends OpenRDFBaseAction {

	/**
	 * BaseAction 
	 */
	private static final long serialVersionUID = 1L;
	private String rdf_fronts_href = "";
	private String rdf_cas_href = "";

	public String toIndexPage(){
		rdf_cas_href = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
		return "success";
	}
	
	public String toLoginPage(){
		// redirect to login page
		rdf_cas_href = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
		return "success";
	}
	
	public String toRegisterPage(){
		// redirect to register page 
		rdf_fronts_href = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_FRONTS_HREF);
		rdf_cas_href = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
		return "success";
	}
	
	public String toProtocalPage(){
		// redirect to protocal page 
		rdf_fronts_href = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_FRONTS_HREF);
		rdf_cas_href = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
		return "success";
	}

	// ==================== getters ===========================//
	public String getRdf_fronts_href() {
		return rdf_fronts_href;
	}

	public String getRdf_cas_href() {
		return rdf_cas_href;
	}
}
