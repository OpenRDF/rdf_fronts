package com.openrdf.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.openrdf.beans.User;
import com.openrdf.beans.UserLogin;

public class UsersDao extends HibernateDaoSupport {

	// add addUserLogin
	public void addUserLogin(UserLogin useLogin) {
		this.getHibernateTemplate().save(useLogin);
	}

	// add User
	public void addUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	// get user by id
	public User getUserById(String userId) {
		User user = null;
		user = this.getHibernateTemplate().get(User.class, userId);
		return user;
	}

	// get user by LoginEmail
	@SuppressWarnings("unchecked")
	public UserLogin getUserLoginByUserLoginEmail(String userLoginEmail) {
		String sql = "From UserLogin where userLoginEmail = '" + userLoginEmail
				+ "'";
		List<Object> userLoginList = this.getHibernateTemplate().find(sql);
		if(userLoginList.size() == 0){
			return null;
		}
		return (UserLogin) userLoginList.get(0);
	}

	// update user
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	// delete user
	public void deleteUser(User user) {
		this.getHibernateTemplate().delete(user);
	}

}
