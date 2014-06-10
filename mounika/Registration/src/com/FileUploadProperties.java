package com;

import java.io.FileInputStream;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.sun.xml.internal.fastinfoset.sax.Properties;

public class FileUploadProperties implements ServletContextListener

{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext ctx = servletContextEvent.getServletContext();
		System.out.println("contxt intiated");
		String filepath = ctx.getInitParameter("myParam");
		ResourceBundle bundle = ResourceBundle.getBundle(filepath);
		ctx.setAttribute("file", bundle);
		System.out.println("property file loaded");
	}

}
