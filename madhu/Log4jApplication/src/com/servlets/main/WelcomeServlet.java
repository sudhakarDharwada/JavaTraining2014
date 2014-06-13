package com.servlets.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class WelcomeServlet extends HttpServlet{
	/**
	 * 
	 */
	static Logger log=Logger.getLogger(WelcomeServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		PrintWriter out=resp.getWriter();
		log.info("success to welcome page");
		req.getRequestDispatcher("welcome.html").include(req, resp);
		out.println("</br></br><center>");
		out.println("Thanking You for visiting");
		out.println("</center>");
	}	
}
