package com.log.logger;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(Display.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		log.info("Getting values through session");
		String n = (String) session.getAttribute("name2");
		String m = (String) session.getAttribute("fname1");
		String p = (String) session.getAttribute("sex1");
		String q = (String) session.getAttribute("state1");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body bgcolor= pink>");
		out.print("<h1>People Who Are Registererd </h1>");
		out.print("<h3>Student Name:</h3>" + n);
		out.print("<h3>FathersName:</h3>" + m);
		out.print("<h3>sex:</h3>" + p);
		out.print("<h3>state:</h3>" + q);
		out.print(" <h3> file has uploaded sucessfully</h3>");
		out.println("<a href=\"Logout\">Click To Logout </a>");
		out.print("</body>");
		out.print("</html>");

	}
}
