package com.val.Listeners;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FileLoadListener implements ServletContextListener
{
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent e) 
	{
		String filepath=e.getServletContext().getInitParameter("User-Credentials");
		ResourceBundle rb=ResourceBundle.getBundle(filepath);
		ServletContext context=e.getServletContext();
		context.setAttribute("file",rb);
	}
}
