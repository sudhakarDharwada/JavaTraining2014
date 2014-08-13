
package com.val.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		System.out.println("In servlet");
		if("admin@cal.com".equals(req.getParameter("email")) && "admin".equals(req.getParameter("pwd")))
		{
			resp.sendRedirect("Admin.html");
		}
		else
		{
			resp.sendRedirect("User.html");
		}
	}
	
}
