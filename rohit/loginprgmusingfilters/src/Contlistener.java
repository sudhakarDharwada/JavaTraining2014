package com.webapp2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Contlistener implements ServletContextListener {
 
	@Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        ServletContext ctx = servletContextEvent.getServletContext();
         System.out.println("contxt intiated");
        String filepath = ctx.getInitParameter("properties-file");
        ResourceBundle rbl = ResourceBundle.getBundle(filepath);
        /*Properties prop=new Properties();
		FileInputStream input;
		try {
			input = new FileInputStream(filepath);
			prop.load(input);*/
			ctx.setAttribute("input", rbl);
		/*} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
        System.out.println("property file loaded");
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}
}