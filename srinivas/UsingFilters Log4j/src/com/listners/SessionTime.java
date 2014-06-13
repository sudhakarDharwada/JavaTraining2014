package com.listners;

import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionTime implements HttpSessionListener{  
	ServletContext ctx=null;  
	static Logger logger = Logger.getLogger(SessionTime.class);  

	public void sessionCreated(HttpSessionEvent e) {  

		HttpSession session = e.getSession();
		HttpSession session1 = e.getSession();
		logger.info("session Created:");
		System.out.print(" (session) Created:");
		logger.info("ID=" + session1.getId() + " MaxInactiveInterval=" + session1.getMaxInactiveInterval());
		System.out.println("ID=" + session1.getId() + " MaxInactiveInterval=" + session1.getMaxInactiveInterval());

	}  

	public void sessionDestroyed(HttpSessionEvent e) {  


	}




}  