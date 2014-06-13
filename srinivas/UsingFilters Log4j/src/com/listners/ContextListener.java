package com.listners;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
 
//@WebListener("application context listener")
public class ContextListener implements ServletContextListener {
 
	static Logger logger = Logger.getLogger(ContextListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        // initialize log4j here
    	logger.info("At ContextListener class..");
        ServletContext context = event.getServletContext();
        String log4jConfigFile = context.getInitParameter("log4j");
        String fullPath = context.getRealPath("") + File.separator + log4jConfigFile;
         
        PropertyConfigurator.configure(fullPath);
         
    }
     
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // do nothing
    }  
}