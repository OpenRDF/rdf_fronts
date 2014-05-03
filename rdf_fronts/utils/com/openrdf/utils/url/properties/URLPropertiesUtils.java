package com.openrdf.utils.url.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Utils URL Properties 单子类: 用来实例化跳转地址。
 * 
 * @description 本程序用于来自谢先斌毕业论文，如有使用请联系作 者，注明出处。
 * @URL 代码地址：http://github.com/openRDF/rdf_fronts
 * @rdf com.openrdf.utils.url.properties
 * @dateTime 2014-5-2
 * @author XieXianbin
 * @email a.b@hotmail.com
 * 
 */
public class URLPropertiesUtils {

	final static Logger log = Logger.getLogger(URLPropertiesUtils.class);
	// URL地址属性
	private static Properties URLProperties = null; 
	// CAS
	public static final String RDF_CAS_HREF="RDF_CAS_HREF";
	// 后台
	public static final String RDF_BACKEND_HREF="RDF_BACKEND_HREF";
	// 前台
	public static final String RDF_FRONTS_HREF="RDF_FRONTS_HREF";
	
	// 获取URL地址 
	public static String getPropertiesUrl(String URLKey){
		return getURLProperties().getProperty(URLKey);
	}
	
	// 单子类 实例化
	public static Properties getURLProperties(){
		if(URLProperties == null){
			// 系统发布路径
			String systemPath = URLPropertiesUtils.class.getClassLoader().getResource("/").getPath();
			// 网址配置文件位置
			String proFilePath = systemPath + "url.properties"; 
			log.debug(proFilePath);
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(proFilePath);
				URLProperties = new Properties();
				URLProperties.load(inputStream);
			} catch (FileNotFoundException e) {
//				e.printStackTrace();
				log.error("Could NOT Found config.properties File in the Project dir.");
			} catch (IOException e) {
//				e.printStackTrace();
				log.error("When read config.properties Occor an IOException: " + e + ".");
			}finally{
				if(inputStream != null){
					try {
						// 关闭文件流 
						inputStream.close();
					} catch (IOException e) {
//						e.printStackTrace();
						log.error("When Close cinputStream Occor an IOException: " + e + ".");
					}
				}
			}
		}
		return URLProperties;
	}
}
