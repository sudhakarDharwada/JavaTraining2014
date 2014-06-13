package com.servlets.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	static Logger log=Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		System.out.println("Loginservlet");
		log.info("login success");
		resp.sendRedirect("success.html");
	}
}
