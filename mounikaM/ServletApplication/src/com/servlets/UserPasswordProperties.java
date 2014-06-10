package com.servlets;

import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



public class UserPasswordProperties implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
		System.out.print("context initialised");
		ServletContext cnt=event.getServletContext();
		String file=cnt.getInitParameter("property-files");
		ResourceBundle rbl = ResourceBundle.getBundle(file);
		cnt.setAttribute("input", rbl);
	}
	public void contextDestroyed(ServletContextEvent event) 
	{
		
	} 
}

