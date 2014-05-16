package com.openrdf.service;

import org.apache.log4j.Logger;

import com.openrdf.beans.UserLogin;
import com.openrdf.beans.User;
import com.openrdf.dao.UsersDao;

public class UsersService {
	
	private Logger logger = Logger.getLogger(UsersService.class);
	private UsersDao usersDao;

	// add 
	public void addUser(UserLogin userLogin) {
		
		usersDao.addUser(userLogin);
		
	}
	
	// delete 
	
	
	// update 
	
	
	// select 
	
	
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
}
