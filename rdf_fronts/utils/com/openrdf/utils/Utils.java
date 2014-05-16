package com.openrdf.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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
	 * 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
	 * 
	 * @return long
	 */
	public static long getCurrentTimeMillis(){
		Date date = new Date();
		return date.getTime();
	}
	
	/**
	 * 通过秒数获取当前的时间
	 * 
	 * @param timeMillis
	 * @return 2014-05-16 10:23:45.823
	 */
	public static String getDateTimeBySecond(long timeMillis){
		Timestamp timestamp = new Timestamp(timeMillis);
		return timestamp.toString();
	}
	
	/**
	 * 生成一个uuid
	 */
	
	public static UUID geneUUID(){
		// 随机生成UUID
		UUID uuid = UUID.randomUUID();
		return uuid;
	}
	
	/**
	 * 
	 * @param str
	 * 			要过滤的字符串
	 * @param regEx
	 * 			过滤规则
	 * @return
	 * 			过滤后的字符串
	 * @throws PatternSyntaxException
	 */
	public static String stringFilter(String str, String regEx) {
		// 只允许字母和数字
		if(regEx == null){
			regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		}
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
}
