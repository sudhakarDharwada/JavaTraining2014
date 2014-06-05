package com.job.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JobDetailes extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<h1>Detailes Are:</h1>");
		pw.println("<h2>Applicants Name:"+request.getParameter("name"));
		pw.println("<h2>Applicants Email:"+request.getParameter("email"));
		pw.println("<h2>Applicants Gender:"+request.getParameter("gender"));
		pw.println("<h2>Stationary Detailes:"+request.getParameter("stationary"));
		pw.println("<br/><td><a href='./Upload.html'>" + "Resume Upload" + "</td></tr><br/>");
		pw.println("</body>");
		pw.println("</html>");
		
		/*ServletContext context=request.getServletContext();
		RequestDispatcher rd=context.getRequestDispatcher("/fileUpload");
		rd.include(request, response);*/
	}

}
