package com.openrdf.base.action;

import com.openrdf.base.service.OpenRDFBaseService;
import com.opensymphony.xwork2.ActionSupport;

public class OpenRDFBaseAction extends ActionSupport {

	private OpenRDFBaseService openRDFBaseService;

	public OpenRDFBaseService getOpenRDFBaseService() {
		return openRDFBaseService;
	}

	public void setOpenRDFBaseService(OpenRDFBaseService openRDFBaseService) {
		this.openRDFBaseService = openRDFBaseService;
	}
	
}
