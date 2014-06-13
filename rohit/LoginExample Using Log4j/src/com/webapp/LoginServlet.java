package com.webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public Logger log;
	public void init( )
	{
		log = Logger.getRootLogger();
		ServletContext ctx = getServletContext();
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext ctx = request.getServletContext();
		log.debug("contetxt created");
		ResourceBundle rb = (ResourceBundle)ctx.getAttribute("input");
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if(rb.containsKey(user))
		{
			log.debug("checking login credentials");
			if(pwd.equals(rb.getString(user)))
			{
				HttpSession session = request.getSession();
				session.setAttribute("name", user);
				session.setMaxInactiveInterval(4*60);
				log.debug("loggedin successfully redirected to success page");
				response.sendRedirect("loginsuccess.html");
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
		PrintWriter out= response.getWriter();
		log.info("Info : wrong credentials");
		out.println("<font color=red>Either user name or password is wrong.</font>");
		rd.include(request, response);
	}
}