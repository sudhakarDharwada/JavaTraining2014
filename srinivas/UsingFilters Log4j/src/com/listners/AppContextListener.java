package com.listners;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.filters.SessionFil;
 

 
@WebListener
public class AppContextListener implements ServletContextListener {
	
	Properties prop = null;
	 private static final String properties = "prop";
	 static Logger logger = Logger.getLogger(AppContextListener.class);
 
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        
       
         
        String propertyfile  = ctx.getInitParameter("propertyfile");
        prop = new Properties();
        logger.info("At contextInitialized()....");
        System.out.println("At contextInitialized()....");
        logger.info("Checking property file existance :"+prop.isEmpty());
        System.out.println("Checking property file existance :"+prop.isEmpty());
		
		
		
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/users.properties"));
			        } catch (IOException e) {
			           e.printStackTrace();
			        }
		servletContextEvent.getServletContext().setAttribute(properties, this);
        
    }
 
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
                
        
         
    }
    
	public static AppContextListener getInstance(ServletContext context) {
        return (AppContextListener) context.getAttribute(properties);
    }
     
}