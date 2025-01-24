package com.framework.utils;

import java.util.Properties;

public class ReadPropertyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties prop = PropUtil.readData("prod", "Config.properties");
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	}

}
