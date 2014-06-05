package com.vl.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyLoader {
	private final static String fileName="./properties/user.properties";
	private final static Properties PROPERTIES=new Properties();
	public static Properties getInstance() {
		InputStream input = null;
		try {
			input=new FileInputStream(fileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			PROPERTIES.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return PROPERTIES;
	}
}
