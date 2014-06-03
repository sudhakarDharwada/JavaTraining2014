package com.servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletForm extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		response.setContentType("text/html");
		
		
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1>Detailes Are:</h1>");
		pw.println("<h2>Applicants Name:"+request.getParameter("name"));
		pw.println("<h2>Applicants Email:"+request.getParameter("email"));
		pw.println("<h2>Applicants Gender:"+request.getParameter("gender"));
		pw.println("<h2>Stationary Detailes:"+request.getParameter("stationary"));
		pw.println("</body>");
		pw.println("</html>");	
	}
}