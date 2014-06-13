package com.servlets.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener
{
	static Logger log=Logger.getLogger(SessionListener.class);
	
	public void sessionCreated(HttpSessionEvent e)
	{
		System.out.println("Session Created");
		HttpSession session=e.getSession();
		log.info("session time setted");
		session.setMaxInactiveInterval(50);
		
	}
	public void sessionDestroyed(HttpSessionEvent e)
	{	
		log.warn("session destroyed,you should login again");
		System.out.println("Session Destroyed");
	}
}
