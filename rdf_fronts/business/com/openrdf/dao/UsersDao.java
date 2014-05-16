package com.openrdf.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.openrdf.beans.UserLogin;

public class UsersDao extends HibernateDaoSupport {

	// add
	public void addUser(UserLogin useLogin) {
		this.getHibernateTemplate().save(useLogin);
	}

}
