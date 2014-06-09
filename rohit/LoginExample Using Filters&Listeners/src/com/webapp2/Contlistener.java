package com.webapp2;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Contlistener implements ServletContextListener {
 
	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        ServletContext ctx = servletContextEvent.getServletContext();
        System.out.println("contxt intiated");
        String filepath = ctx.getInitParameter("properties-file");
        ResourceBundle rbl = ResourceBundle.getBundle(filepath);
		ctx.setAttribute("input", rbl);
        System.out.println("property file loaded");
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}