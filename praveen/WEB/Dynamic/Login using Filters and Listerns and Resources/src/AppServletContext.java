package com.vl.listner;

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
public class AppServletContext implements ServletContextListener {
    public void contextInitialized(ServletContextEvent contextEvent) {
       ServletContext context=contextEvent.getServletContext();
       ResourceBundle rb = ResourceBundle.getBundle("user");
       System.out.println("init listerner");
       context.setAttribute("prop", rb);
    }
    
    public void contextDestroyed(ServletContextEvent contextEvent) {
        System.out.println("distroyed listerner");
        ResourceBundle.clearCache();
    }
	
}
