package com.openrdf.utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Utils���߰�
 * 
 * @description ��������������л�ȱ��ҵ���ģ�����ʹ������ϵ���ߡ�
 * @URL �����ַ��http://github.com/openRDF/rdfcode
 * @rdf com.openrdf.utils
 * @dateTime 2014-2-27 
 * @author XieXianbin
 * @email a.b@hotmail.com
 *
 */

public class Utils {

	/**
	 * ��ȡ��ǰʱ�䣬��ʽ�磺2014-2-28
	 */
	public static String getDate(){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(date);
	}
	
	/**
	 * ��ȡ��ǰʱ�䣬��ʽ�磺2014-2-28 0:12:27
	 */
	public static String getDateTime(){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		return dateFormat.format(date);
	}
	
	/**
	 * ���UUID������Ψһ�ı�ʶһ���û�id
	 */
	
	public static UUID geneUUID(){
		// ���һ��UUID
		UUID uuid = UUID.randomUUID();
		return uuid;
	}
}
