package com.val.Listeners;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class FileLoadListener implements ServletContextListener
{
	private static Logger logger=Logger.getLogger(FileLoadListener.class);
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		
	}

	public void contextInitialized(ServletContextEvent e) 
	{
		String filepath=e.getServletContext().getInitParameter("User-Credentials");
		ResourceBundle rb=ResourceBundle.getBundle(filepath);
		ServletContext context=e.getServletContext();
		context.setAttribute("file",rb);
		logger.info("User Properties File loaded");
	}
}
