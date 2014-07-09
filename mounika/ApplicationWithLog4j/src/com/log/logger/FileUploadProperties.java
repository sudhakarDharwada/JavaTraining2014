package com.log.logger;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class FileUploadProperties implements ServletContextListener
{
static Logger log=Logger.getLogger(FileUploadProperties.class);


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext ctx = servletContextEvent.getServletContext();
		System.out.println("contxt intiated");
		String filepath = ctx.getInitParameter("myParam");
		ResourceBundle bundle = ResourceBundle.getBundle(filepath);
		ctx.setAttribute("file", bundle);
	log.info("files loaded successfully");
	}

}
