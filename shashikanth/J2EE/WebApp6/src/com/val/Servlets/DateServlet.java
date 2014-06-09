package com.val.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		Date d=new Date();
		PrintWriter out=resp.getWriter();
		req.getRequestDispatcher("Display.html").include(req, resp);
		out.println("<center><h4>Today's Date</h4></center>");
		out.println("<center>"+d.toLocaleString()+"</center>");
		ServletContext ctx=getServletContext();  
	    int t=(Integer)ctx.getAttribute("totalusers");  
	    int c=(Integer)ctx.getAttribute("currentusers");
	    out.println("</br></br><center>");
	    out.print("<table><tr><td>Total Users:</td><td>"+t+"</td></tr>");  
	    out.print("<tr><td>Current Users:</td><td>"+c+"</td></tr></table>");
	    out.println("</center>");
	}	
}
