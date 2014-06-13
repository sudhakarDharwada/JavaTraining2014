package com.vl.listner;


import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
public class AppServletContext implements ServletContextListener {
	static Logger log = Logger.getLogger(AppServletContext.class);
	public void contextInitialized(ServletContextEvent contextEvent) {
		String propertyPath=contextEvent.getServletContext().getInitParameter("property-path");
		System.out.println("path "+propertyPath);
		PropertyConfigurator.configure(propertyPath);
		ServletContext context=contextEvent.getServletContext();
		ResourceBundle rb = ResourceBundle.getBundle("user");
		log.info("init listerner");
		context.setAttribute("prop", rb);

	}

	public void contextDestroyed(ServletContextEvent contextEvent) {
		log.info("distroyed listerner");
		ResourceBundle.clearCache();
	}

}
