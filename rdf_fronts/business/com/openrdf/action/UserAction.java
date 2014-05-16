package com.openrdf.action;

import org.apache.log4j.Logger;

import com.openrdf.base.action.OpenRDFBaseAction;
import com.openrdf.beans.UserLogin;
import com.openrdf.service.UsersService;
import com.openrdf.utils.Utils;
import com.openrdf.utils.encrypt.Base64Encrpt;
import com.openrdf.utils.url.properties.URLPropertiesUtils;

public class UserAction extends OpenRDFBaseAction {

	private Logger logger = Logger.getLogger(UserAction.class);
	
	private UserLogin userLogin =new UserLogin(); // 用户登录信息 
	//private String userLoginEmail; // 用户登录邮箱
	//private String password; // 用户登录密码
	private UsersService usersService;
	// 当返回值非法时，提示原因。
	private String wrongReason;
	private String rdf_cas_href;
	
	public String registerUserAction(){
		
		String password = userLogin.getPassword();
		Base64Encrpt base64Encrpt = new Base64Encrpt();
		String userId = Utils.geneUUID().toString();
		userLogin.setUserId(userId);
		userLogin.setUserQq("");
		String userLoginEmail = userLogin.getUserLoginEmail();
		// 过滤Email地址
		String regEx = "[`~!#$%^&*()+=|{}':;',\\[\\]<>/?~！#￥%……&*（）+|{}【】‘；：”“’。，、？]";
		if(!userLoginEmail.endsWith(Utils.stringFilter(userLoginEmail, regEx))){
			logger.debug("登录邮箱：" + userLoginEmail + "格式规范性不合格。");
			wrongReason = "您的注册邮箱非法。";
			rdf_cas_href = URLPropertiesUtils.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
			return "illegalEmail";
		}else{
			logger.debug("邮箱格式规范性合格。");
		}
		
		userLogin.setPassword(base64Encrpt.getEncString(password));
		logger.info("注册新用户，用户邮箱：" + userLoginEmail + "，用户密码：" + password + "，UUID："+ userId);
		usersService.addUser(userLogin);
		// 发送邮件
		
		return "success";
	}

	
	
	// ========================= getters and setters =========================== //
	public UserLogin getUserLogin() {
		return userLogin;
	}
	
	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}
//	public String getUserLoginEmail() {
//		return userLoginEmail;
//	}
//	public void setUserLoginEmail(String userLoginEmail) {
//		this.userLoginEmail = userLoginEmail;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public String getWrongReason() {
		return wrongReason;
	}

	public void setWrongReason(String wrongReason) {
		this.wrongReason = wrongReason;
	}

	public String getRdf_cas_href() {
		return rdf_cas_href;
	}

	public void setRdf_cas_href(String rdf_cas_href) {
		this.rdf_cas_href = rdf_cas_href;
	}
	
}
