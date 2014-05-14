package com.openrdf.action;

import com.openrdf.base.action.OpenRDFBaseAction;
import com.openrdf.beans.UserLogin;

public class UserAction extends OpenRDFBaseAction {

	private UserLogin userLogin =new UserLogin(); // 用户登录信息 
	//private String userLoginEmail; // 用户登录邮箱
	//private String password; // 用户登录密码
	
	public String registerUserAction(){
		
		System.out.println(userLogin.getUserLoginEmail());
		System.out.println(userLogin.getPassword());
		
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
	
}
