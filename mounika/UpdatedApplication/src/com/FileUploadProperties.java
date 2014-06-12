package com;


import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



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
		System.out.println("files loaded successfully");
	}

}
