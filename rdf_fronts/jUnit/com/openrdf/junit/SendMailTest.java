package com.openrdf.junit;

import com.openrdf.utils.email.SendMailAction;

import junit.framework.TestCase;

public class SendMailTest extends TestCase {

	public void test(){
		SendMailAction sendMailAction = new SendMailAction();
		System.out.println(sendMailAction.sendMail("xianbinxie@163.com", "123", "123"));
	}
}
