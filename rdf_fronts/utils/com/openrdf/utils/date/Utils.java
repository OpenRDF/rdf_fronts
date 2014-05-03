package com.openrdf.utils.date;

import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Utils工具类
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @rdf com.openrdf.utils
 * @dateTime 2014-2-27 
 * @author XieXianbin
 * @email a.b@hotmail.com
 *
 */

public class Utils {

	/**
	 * 获取日期，格式：2014-2-28
	 */
	public static String getDate(){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateInstance();
		return dateFormat.format(date);
	}
	
	/**
	 * 获取日期时间，格式：2014-2-28 0:12:27
	 */
	public static String getDateTime(){
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance();
		return dateFormat.format(date);
	}
	
	/**
	 * 生成一个uuid
	 */
	
	public static UUID geneUUID(){
		// 随机生成UUID
		UUID uuid = UUID.randomUUID();
		return uuid;
	}
}
