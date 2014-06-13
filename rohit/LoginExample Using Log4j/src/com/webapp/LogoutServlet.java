package com.webapp;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LogoutServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public Logger log;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
    	HttpSession session = request.getSession(false);
    	log.debug("checking if session exist or not at logout");
    	if(session != null)
    	{
    		log.info("Info : session exists");
    		session.invalidate();
    		log.debug("invalidating the session");
    	}
    	log.info("Info : loggedout successfully");
    	response.sendRedirect("login.html");
    }
    public void init( )
	{
		log = Logger.getRootLogger();
	}
}
