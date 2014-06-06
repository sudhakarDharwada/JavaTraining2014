package com.vl.listner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.vl.resources.PropertyLoader;
public class AppServletContext implements ServletContextListener {
	private final static String fileName="/home/praveen/works/LoginProperty/WebContent/WEB-INF/properties/user.properties";
	private final static Properties PROPERTIES=new Properties();
    public void contextInitialized(ServletContextEvent contextEvent) {
       ServletContext context=contextEvent.getServletContext();
       Properties properties=PropertyLoader.getInstance();
       System.out.println("init listerner");
       context.setAttribute("prop", properties);
    }
    
    public void contextDestroyed(ServletContextEvent contextEvent) {
    	ServletContext context=contextEvent.getServletContext();
        Properties properties=(Properties) context.getAttribute("prop");
        System.out.println("distroyed listerner");
        properties.clear();
    }
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
