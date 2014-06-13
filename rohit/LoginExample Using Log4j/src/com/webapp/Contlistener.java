package com.webapp;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class Contlistener implements ServletContextListener {
 
	public static Logger log = Logger.getRootLogger(); 
	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
		
        ServletContext ctx = servletContextEvent.getServletContext();
        log.debug("contxt intiated");
        String filepath = ctx.getInitParameter("properties-file");
        ResourceBundle rbl = ResourceBundle.getBundle(filepath);
		ctx.setAttribute("input", rbl);
        log.info("Info : property file loaded");
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}