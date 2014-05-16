package com.openrdf.service;

import org.apache.log4j.Logger;

import com.openrdf.beans.User;
import com.openrdf.beans.UserLogin;
import com.openrdf.dao.UsersDao;
import com.openrdf.utils.Utils;

public class UsersService {

	private Logger logger = Logger.getLogger(UsersService.class);
	private UsersDao usersDao;

	/**
	 *  add
	 *  
	 * @param userLogin
	 */
	public void addUser(UserLogin userLogin) {
		// 向UserLogin中添加数据
		usersDao.addUserLogin(userLogin);
		// 向Users中添加数据
		String userName = userLogin.getUserLoginEmail().substring(0,
				userLogin.getUserLoginEmail().indexOf("@"));
		User user = new User(userLogin.getUserId(), userName, "", "", "",
				Utils.getCurrentTimeMillis(), 114, "1900-01-01", "", "", "",
				"", "", "", userLogin.getUserLoginEmail(), 0, "", "", "", "",
				"", "", 0, "");
		usersDao.addUser(user);
	}

	// delete

	// update

	// select


	/**
	 *  认证邮箱
	 *  
	 * @param userLoginEmail
	 * @param userId
	 * @return
	 */
	public String emailAuthentication(String userLoginEmail, String userId) {
		User user = usersDao.getUserById(userId);
		if(user == null){
			return "userNotFound";
		}else if(user.getUserEmail().equalsIgnoreCase(userLoginEmail)){
			if(user.getEmailAuthentication() == 0){
				user.setEmailAuthentication(1);
				usersDao.updateUser(user);
				return "authSuccess";
			}else{
				return "reEmailAuth";
			}
		}
		return null;
	}
	
	/**
	 * 判断邮箱是否存在 
	 * 
	 * @param userLoginEmail
	 * @return boolean
	 */
	public boolean isExistUserLogin(String userLoginEmail){
		UserLogin userLogin = usersDao.getUserLoginByUserLoginEmail(userLoginEmail);
		if(userLogin == null){
			// 登录邮箱不存在
			return false;
		}else{
			// 登录邮箱存在 
			return true;
		}
	}
	
	// ========================= getters and setters =========================== //
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
}
