package com.servlets.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener
{
	//static int current=0,total=0;
	public void sessionCreated(HttpSessionEvent e)
	{
		System.out.println("Session Created");
		HttpSession session=e.getSession();
		session.setMaxInactiveInterval(50);
		
		/*context=e.getSession().getServletContext();
		context.setAttribute("totalusers", total);
		context.setAttribute("currentusers", current);*/
	}
	public void sessionDestroyed(HttpSessionEvent e)
	{	
		System.out.println("Session Destroyed");
		//current--;
		//context.setAttribute("currentusers",current);
	}
}
