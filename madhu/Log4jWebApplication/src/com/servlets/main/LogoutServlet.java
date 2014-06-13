package com.servlets.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LogoutServlet extends HttpServlet{
	/**
	 * 
	 */
	static Logger log=Logger.getLogger(LogoutServlet.class);
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		HttpSession session=req.getSession(false);
		log.warn("removing session attributes");
		session.removeAttribute("login");
		log.error("session attributes are removed");
		session.invalidate();
		log.info("session invalidated");
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
}
