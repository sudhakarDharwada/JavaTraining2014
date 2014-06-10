package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayDetailsServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		session.setAttribute("fname", req.getParameter("firstname"));
		session.setAttribute("lname", req.getParameter("lastname"));
		session.setAttribute("email", req.getParameter("email"));
		session.setAttribute("vehicle", req.getParameter("vehicle"));
		session.setAttribute("country", req.getParameter("Country"));
		
		
		
	}
	
	

}
