package com.openrdf.utils.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EmailProperties {

	public Properties getEmailProperties() {
		// 系统发布路径
		String systemPath = URLPropertiesUtils.class.getClassLoader()
				.getResource("/").getPath();
		// 网址配置文件位置
		String EMAILPROPERTIES = systemPath + "email.properties";
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(new File(
					EMAILPROPERTIES));
			// 加载属性文件
			Properties properties = new Properties();
			properties.load(fileInputStream);
			fileInputStream.close();
			return properties;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
