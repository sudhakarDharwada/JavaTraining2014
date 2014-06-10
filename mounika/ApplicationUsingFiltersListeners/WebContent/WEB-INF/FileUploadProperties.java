package com;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FileUploadProperties implements ServletContextListener

{

	private String myParam;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent contextevent) {
	
		this.myParam = ((ServletConfig) contextevent).getInitParameter("myParam");	
		System.out.println(myParam);
	}



}
