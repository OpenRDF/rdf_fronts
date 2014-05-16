package com.openrdf.beans;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User {

	// Fields

	private String userId;
	private String userName;
	private String userPass;
	private String userStatus;
	private String aliPayAccount;
	private Date accountCreateTime;
	private Integer userAge;
	private String userBirthday;
	private String userSex;
	private String userCountry;
	private String userProvince;
	private String userCity;
	private String userAddress;
	private String userPostCode;
	private String userEmail;
	private String userEmail1;
	private String userEmail2;
	private String userPhone;
	private String userQq;
	private String userMsn;
	private String userBriefInfroduction;
	private double userBalance;
	private String userOthers;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId) {
		this.userId = userId;
	}

	/** full constructor */
	public User(String userId, String userName, String userPass,
			String userStatus, String aliPayAccount, Date accountCreateTime,
			Integer userAge, String userBirthday, String userSex,
			String userCountry, String userProvince, String userCity,
			String userAddress, String userPostCode, String userEmail,
			String userEmail1, String userEmail2, String userPhone,
			String userQq, String userMsn, String userBriefInfroduction,
			double userBalance, String userOthers) {
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
		this.userStatus = userStatus;
		this.aliPayAccount = aliPayAccount;
		this.accountCreateTime = accountCreateTime;
		this.userAge = userAge;
		this.userBirthday = userBirthday;
		this.userSex = userSex;
		this.userCountry = userCountry;
		this.userProvince = userProvince;
		this.userCity = userCity;
		this.userAddress = userAddress;
		this.userPostCode = userPostCode;
		this.userEmail = userEmail;
		this.userEmail1 = userEmail1;
		this.userEmail2 = userEmail2;
		this.userPhone = userPhone;
		this.userQq = userQq;
		this.userMsn = userMsn;
		this.userBriefInfroduction = userBriefInfroduction;
		this.userBalance = userBalance;
		this.userOthers = userOthers;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	public String getAliPayAccount() {
		return this.aliPayAccount;
	}

	public void setAliPayAccount(String aliPayAccount) {
		this.aliPayAccount = aliPayAccount;
	}

	public Date getAccountCreateTime() {
		return this.accountCreateTime;
	}

	public void setAccountCreateTime(Date accountCreateTime) {
		this.accountCreateTime = accountCreateTime;
	}

	public Integer getUserAge() {
		return this.userAge;
	}

	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}

	public String getUserBirthday() {
		return this.userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserSex() {
		return this.userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserCountry() {
		return this.userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getUserProvince() {
		return this.userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}

	public String getUserCity() {
		return this.userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserAddress() {
		return this.userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPostCode() {
		return this.userPostCode;
	}

	public void setUserPostCode(String userPostCode) {
		this.userPostCode = userPostCode;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmail1() {
		return this.userEmail1;
	}

	public void setUserEmail1(String userEmail1) {
		this.userEmail1 = userEmail1;
	}

	public String getUserEmail2() {
		return this.userEmail2;
	}

	public void setUserEmail2(String userEmail2) {
		this.userEmail2 = userEmail2;
	}

	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getUserMsn() {
		return this.userMsn;
	}

	public void setUserMsn(String userMsn) {
		this.userMsn = userMsn;
	}

	public String getUserBriefInfroduction() {
		return this.userBriefInfroduction;
	}

	public void setUserBriefInfroduction(String userBriefInfroduction) {
		this.userBriefInfroduction = userBriefInfroduction;
	}

	public double getUserBalance() {
		return this.userBalance;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserOthers() {
		return this.userOthers;
	}

	public void setUserOthers(String userOthers) {
		this.userOthers = userOthers;
	}

}