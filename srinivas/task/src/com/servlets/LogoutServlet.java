package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.html");
        PrintWriter out= resp.getWriter();
        req.getSession().invalidate();
        out.println("<font color=red>you have successfully loggedout!!!.</font>");
        rd.include(req, resp);
		
	}
	
}
