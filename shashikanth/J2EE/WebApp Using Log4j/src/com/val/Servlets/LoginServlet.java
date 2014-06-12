package com.val.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.val.Listeners.FileLoadListener;



public class LoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(LoginServlet.class);
	public void init() throws ServletException 
	{
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		logger.debug("In Login Servlet");
		resp.sendRedirect("Success.html");
	}
	
}
