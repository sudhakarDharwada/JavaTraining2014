package com.servlets;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener{
	private static final String ATTRIBUTE_NAME = "prop";
	Properties prop = new Properties();

	public void contextInitialized(ServletContextEvent event) {
// TODO Auto-generated method stub
		System.out.print("Initialized" +event);
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/Properties/details.properties"));
        }
		catch (IOException e) {
           e.printStackTrace();
        }
        event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
	}

@Override
	public void contextDestroyed(ServletContextEvent event) {
// TODO Auto-generated method stub
		prop.clear();

	}
	public static ServletListener getInstance(ServletContext context) {
        return (ServletListener) context.getAttribute(ATTRIBUTE_NAME);
    }

    public String getProperty(String key) {
       	System.out.println(prop.getProperty(key));
        return prop.getProperty(key);
    }


}

