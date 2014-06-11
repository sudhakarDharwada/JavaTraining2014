package com.servlets.main;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException
	{
		PrintWriter out=resp.getWriter();
		req.getRequestDispatcher("welcome.html").include(req, resp);
		out.println("</br></br><center>");
		out.println("Thanking You for visiting");
		out.println("</center>");
	}	
}
