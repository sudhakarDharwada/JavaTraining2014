package com.webapp2;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Sesnlistener implements HttpSessionListener
{

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionevent) 
	{
		sessionevent.getSession().removeAttribute("name");
		System.out.println("attribute removed and session destroyed");
	}
	
}
