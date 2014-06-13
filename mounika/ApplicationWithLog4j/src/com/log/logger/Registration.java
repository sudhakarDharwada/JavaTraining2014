package com.log.logger;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger log = Logger.getLogger(Registration.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PrintWriter out = response.getWriter();
		log.info("Getting Registration Detailes through request scope");
		String name = request.getParameter("Sname");
		String fname = request.getParameter("Fname");
		String sex = request.getParameter("Sex");
		String state = request.getParameter("state");
		// String[] edu = request.getParameterValues("group");
		log.info("session  again used ");
		HttpSession session = request.getSession();
		session.setAttribute("name2", name);
		session.setAttribute("fname1", fname);
		session.setAttribute("sex1", sex);
		session.setAttribute("state1", state);
		RequestDispatcher rd = request.getRequestDispatcher("upload.html");
		rd.forward(request, response);

	}

}
