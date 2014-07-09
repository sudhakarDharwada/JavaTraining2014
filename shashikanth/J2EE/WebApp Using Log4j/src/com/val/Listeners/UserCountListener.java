package com.val.Listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class UserCountListener implements HttpSessionListener 
{
	private static Logger logger=Logger.getLogger(UserCountListener.class);
	ServletContext ctx=null;
	static int current=0,total=0;
	public void sessionCreated(HttpSessionEvent e) 
	{
		logger.debug("Session Created");
		HttpSession session=e.getSession();
		session.setMaxInactiveInterval(50);
		 total++;  
		 current++;    
		 ctx=e.getSession().getServletContext();  
		 ctx.setAttribute("totalusers", total);  
		 ctx.setAttribute("currentusers", current);
	}
	public void sessionDestroyed(HttpSessionEvent e) 
	{	
		logger.debug("Session Destroyed");
		current--;  
	    ctx.setAttribute("currentusers",current);
	}
}
