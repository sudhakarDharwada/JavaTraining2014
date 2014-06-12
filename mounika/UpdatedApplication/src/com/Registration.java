package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("Sname");
		String fname = request.getParameter("Fname");
		String sex = request.getParameter("Sex");
		String state = request.getParameter("state");
		String[] edu = request.getParameterValues("group");

		HttpSession session = request.getSession();
		session.setAttribute("name2", name);
      	session.setAttribute("fname1", fname);
		session.setAttribute("sex1", sex);
		session.setAttribute("state1", state);
				RequestDispatcher rd = request.getRequestDispatcher("upload.html");
		rd.forward(request, response);

	}

}
