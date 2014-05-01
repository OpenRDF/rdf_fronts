package com.openrdf.junit;


import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.openrdf.beans.Users;


public class SprintTest extends TestCase {

	public void test() {
		String[] beans = new String[]{"beans.xml"};
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(beans);
		Users users = (Users) applicationContext.getBean("aa");
		users.getUserAge();
	}

}
