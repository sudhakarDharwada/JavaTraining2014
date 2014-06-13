package com.val.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LogoutServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private static Logger logger=Logger.getLogger(LogoutServlet.class);
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		logger.debug("In Logout Servlet");
		HttpSession session=req.getSession(false);
		session.removeAttribute("login");
		session.invalidate();
		logger.info("Session Invalidated");
		req.getRequestDispatcher("Login.html").forward(req, resp);
	}
}
