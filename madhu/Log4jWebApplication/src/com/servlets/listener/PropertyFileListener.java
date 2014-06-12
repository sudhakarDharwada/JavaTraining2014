package com.servlets.listener;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class PropertyFileListener implements ServletContextListener {
	static Logger log=Logger.getLogger(PropertyFileListener.class);
	static ServletContext context;
	public void contextDestroyed(ServletContextEvent arg0) {

	}
	public void contextInitialized(ServletContextEvent e)
	{
		log.info("getting filepath");
		String filepath=e.getServletContext().getInitParameter("User-Credentials");
		ResourceBundle rb=ResourceBundle.getBundle(filepath);
		if(rb==null){
			log.fatal("property file not loaded");
		}
		context=e.getServletContext();
		context.setAttribute("file",rb);
		
	}
}
