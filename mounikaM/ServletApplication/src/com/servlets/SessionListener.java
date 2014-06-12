package com.servlets;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{

	public void sessionCreated(HttpSessionEvent sessionEvent) 
	{
		System.out.println("Session Created ID="+sessionEvent.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) 
	{
		System.out.println("Session Destroyed ID="+sessionEvent.getSession().getId());
	}
	
	public void attributeAdded(HttpSessionBindingEvent event) 
	{
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute added : " + attributeName + " : " + attributeValue);
	}

	public void attributeRemoved(HttpSessionBindingEvent event) 
	{
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		System.out.println("Attribute removed : " + attributeName + " : " + attributeValue);
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) 
	{
		
	}

}
