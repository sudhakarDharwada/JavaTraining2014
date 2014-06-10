package com.val.Listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class UserCountListener implements HttpSessionListener 
{
	ServletContext ctx=null;
	static int current=0,total=0;
	public void sessionCreated(HttpSessionEvent e) 
	{
		System.out.println("Session Created");
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
		System.out.println("Session Destroyed");
		current--;  
	    ctx.setAttribute("currentusers",current);
	}
}
