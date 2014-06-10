package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DisplayServ extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession  session =  req.getSession(false);
		PrintWriter out = resp.getWriter();
			
			out.println("<html>");
			out.println("<body>");
			out.println("<form action = \"home.html\" method = \"post\" ");
			out.println("<h5>" +session.getAttribute("fname")+"</h5>");
			out.println("<h5>"+session.getAttribute("lname")+"</h5>");
			out.println("<h5>" +session.getAttribute("email")+"</h5>");
			out.println("<h5>"+session.getAttribute("vehicle")+"</h5>");
			out.println("<h5>"+session.getAttribute("country")+"</h5>");
			
			out.println("<input type=\"submit\" value=\"Logout!\" onclick=\"textfield()\" name=\"submit\" >\" ");
			out.println("</html>");
			out.println("</body>");
			
			
			
		
			
		}
		
	}

