package com.openrdf.action;

import org.apache.log4j.Logger;

import com.openrdf.base.action.OpenRDFBaseAction;
import com.openrdf.beans.UserLogin;
import com.openrdf.service.UsersService;
import com.openrdf.utils.EmailTemp;
import com.openrdf.utils.Utils;
import com.openrdf.utils.email.SendMailAction;
import com.openrdf.utils.encrypt.Base64Encrpt;
import com.openrdf.utils.properties.URLPropertiesUtils;

public class UserAction extends OpenRDFBaseAction {

	private static final long serialVersionUID = -2764265916955637921L;

	private Logger logger = Logger.getLogger(UserAction.class);

	private UserLogin userLogin = new UserLogin(); // 用户登录信息
	private String userLoginEmail; // 用户登录邮箱
	private String userId;
	// private String password; // 用户登录密码
	private UsersService usersService;
	// 当返回值非法时，提示原因。
	private String wrongReason;
	private String rdf_cas_href;
	private String rdf_fronts_href;
	private String emailAuthentication_info;

	/**
	 * 注册用户
	 * 
	 * @return
	 */
	public String registerUserAction() {

		String password = userLogin.getPassword();
		Base64Encrpt base64Encrpt = new Base64Encrpt();
		String userId = Utils.geneUUID().toString();
		userLogin.setUserId(userId);
		userLogin.setUserQq("");
		String userLoginEmail = userLogin.getUserLoginEmail();
		// 过滤Email地址
		String regEx = "[`~!#$%^&*()+=|{}':;',\\[\\]<>/?~！#￥%……&*（）+|{}【】‘；：”“’。，、？]";
		if (!userLoginEmail.endsWith(Utils.stringFilter(userLoginEmail, regEx))) {
			logger.debug("登录邮箱：" + userLoginEmail + "格式规范性不合格。");
			wrongReason = "您的注册邮箱非法。";
			rdf_cas_href = URLPropertiesUtils
					.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
			return "illegalEmail";
		} else {
			logger.debug("邮箱格式规范性合格。");
		}
		userLogin.setPassword(base64Encrpt.getEncString(password));
		// 判断用户邮箱是否存在
		if (usersService.isExistUserLogin(userLoginEmail)) {
			logger.info("登录邮箱已存在：" + userLoginEmail);
			wrongReason = "您的邮箱" + userLoginEmail + "已注册，请登录！";
			rdf_cas_href = URLPropertiesUtils
					.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
			userLogin.setPassword("");
			return "illegalEmail";
		}

		logger.info("注册新用户，用户邮箱：" + userLoginEmail + "，用户密码：" + password
				+ "，UUID：" + userId);
		usersService.addUser(userLogin);
		// 发送邮件
		SendMailAction sendMailAction = new SendMailAction();
		// 拼装认证邮件连接
		rdf_fronts_href = URLPropertiesUtils
				.getPropertiesUrl(URLPropertiesUtils.RDF_FRONTS_HREF);
		String configureUrl = rdf_fronts_href
				+ "/users/emailAuthentication?userLoginEmail=" + userLoginEmail
				+ "&userId=" + userId;
		logger.info("邮箱认证地址：" + configureUrl);
		// 获取邮件内容
		String mailContent = EmailTemp.getRegisterEmailTemp(userLoginEmail,
				password, configureUrl);
		sendMailAction.sendMail(userLoginEmail, "欢迎注册知识库系统！！", mailContent);
		emailAuthentication_info = "邮箱："+ userLoginEmail + "注册成功！";
		return "success";
	}

	/**
	 * 认证邮箱
	 * 
	 * @return
	 */
	public String emailAuthentication() {
		// cas 地址
		rdf_cas_href = URLPropertiesUtils
				.getPropertiesUrl(URLPropertiesUtils.RDF_CAS_HREF);
		String result = usersService
				.emailAuthentication(userLoginEmail, userId);
		if (result.equalsIgnoreCase("authSuccess")) {
			emailAuthentication_info = "恭喜您！邮箱认证成功！";
			return "success";
		} else if (result.equalsIgnoreCase("reEmailAuth")) {
			emailAuthentication_info = "对不起！您的邮箱已经认证成功！";
			return "reEmailAuth";
		} else {
			emailAuthentication_info = "用户不存在，请重新注册。";
			return "userNotFound";
		}
	}

	// ========================= getters and setters ===========================
	// //
	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserLoginEmail() {
		return userLoginEmail;
	}

	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}

	// public String getPassword() {
	// return password;
	// }
	// public void setPassword(String password) {
	// this.password = password;
	// }

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

	public String getRdf_fronts_href() {
		return rdf_fronts_href;
	}

	public void setRdf_fronts_href(String rdf_fronts_href) {
		this.rdf_fronts_href = rdf_fronts_href;
	}

	public String getEmailAuthentication_info() {
		return emailAuthentication_info;
	}

	public void setEmailAuthentication_info(String emailAuthentication_info) {
		this.emailAuthentication_info = emailAuthentication_info;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
