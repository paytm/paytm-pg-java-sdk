/*******************************************************************************
 * Copyright (C) 2019 Paytm
 ******************************************************************************/
package com.paytm.pg.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utility to provide property value from project.properties resource
 */
public class PropertiesUtil {
	private static PropertiesUtil instance = null;
	private static Properties prop;

	private PropertiesUtil() {
		super();
	}

	/**
	 * This method returns the one time instance of PropertiesUtil
	 * 
	 * @return PropertiesUtil
	 * @throws IOException if project.properties file not found.
	 */
	public static PropertiesUtil getInstance() throws IOException {
		if (instance == null) {
			instance = new PropertiesUtil();
			prop = new Properties();
			InputStream inputStream = instance.getClass().getResourceAsStream("/com/paytm/project.properties");
			prop.load(inputStream);
		}
		return instance;
	}

	/**
	 * This method return the value of property.
	 * 
	 * @param property key in project.properties
	 * @return value regarding key
	 */
	public String getProperty(String property) {
		return prop.getProperty(property);
	}

}
