package com.openrdf.junit;

import com.openrdf.utils.encrypt.Base64Encrpt;

import junit.framework.TestCase;

public class Encrypt extends TestCase {

	public void test(){
		
		Base64Encrpt base64Encrpt = new Base64Encrpt();
//		String str = base64Encrpt.getEncString("0818d.");
//		System.out.println(str);
		System.out.println(base64Encrpt.getDesString("pXYBJIinLNc="));
	}
}
