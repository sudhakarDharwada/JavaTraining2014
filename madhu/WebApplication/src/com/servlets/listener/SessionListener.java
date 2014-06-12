package com.servlets.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener
{
	public void sessionCreated(HttpSessionEvent e)
	{
		System.out.println("Session Created");
		HttpSession session=e.getSession();
		session.setMaxInactiveInterval(50);
		
	}
	public void sessionDestroyed(HttpSessionEvent e)
	{	
		System.out.println("Session Destroyed");
	}
}
