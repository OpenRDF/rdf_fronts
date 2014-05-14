package com.openrdf.beans;

/**
 * UserLogin entity. @author MyEclipse Persistence Tools
 */

public class UserLogin implements java.io.Serializable {

	// Fields

	private String userId;
	private String userLoginEmail;
	private String password;
	private String userQq;

	// Constructors

	/** default constructor */
	public UserLogin() {
	}

	/** minimal constructor */
	public UserLogin(String userId) {
		this.userId = userId;
	}
	
	/** full constructor */
	public UserLogin(String userLoginEmail, String password) {
		this.userLoginEmail = userLoginEmail;
		this.password = password;
	}
	
	/** full constructor */
	public UserLogin(String userId, String userLoginEmail, String password,
			String userQq) {
		this.userId = userId;
		this.userLoginEmail = userLoginEmail;
		this.password = password;
		this.userQq = userQq;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserLoginEmail() {
		return this.userLoginEmail;
	}

	public void setUserLoginEmail(String userLoginEmail) {
		this.userLoginEmail = userLoginEmail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

}