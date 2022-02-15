package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.base.BaseClass;


public class PropertiesUtility extends BaseClass {
public static FileInputStream fis=null;
	public static String readproperty(String key) throws Exception{
		log.info("reading a property file for a key"+key);
		Properties prop=new Properties();
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		prop.load(fis);
		} catch (Exception e) {
						e.printStackTrace();
		}
		return prop.getProperty(key);
	}
public static void main (String[] args) {
	System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
}
	}

