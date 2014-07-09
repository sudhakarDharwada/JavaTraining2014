package com.webapp;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class Sesnlistener implements HttpSessionListener
{
	public static Logger log = Logger.getRootLogger();
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		log.debug("session created");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionevent) 
	{
		sessionevent.getSession().removeAttribute("name");
		log.debug("attribute removed and session destroyed");
	}
	
}
