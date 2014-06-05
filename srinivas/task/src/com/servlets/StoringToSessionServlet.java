package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StoringToSessionServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session  =  req.getSession(false);
		PrintWriter out= resp.getWriter();
		System.out.println("At storing to session servlet");
	
		
		if (session == null) {

			out.println("session checking");
			System.out.println("session checking");
		    resp.sendRedirect("error.html");
		    System.out.println("After session checking");
		}
		
		session.setAttribute("fname", req.getParameter("firstname"));
		session.setAttribute("lname", req.getParameter("lastname"));
		session.setAttribute("email", req.getParameter("email"));
		session.setAttribute("vehicle", req.getParameter("vehicle"));
		session.setAttribute("country", req.getParameter("Country"));
		
		System.out.println(session.getAttribute("name1"));
		System.out.println(session.getAttribute("fname"));
		System.out.println(session.getAttribute("lname"));
		System.out.println(session.getAttribute("email"));
		System.out.println(session.getAttribute("vehicle"));
		System.out.println(session.getAttribute("country"));
		
		
		RequestDispatcher rd = req.getRequestDispatcher("output.jsp");
		rd.forward(req, resp);
	}

	
}
