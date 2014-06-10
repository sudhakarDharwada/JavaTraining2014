package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Session extends HttpServlet {
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      RequestDispatcher rd;
      HttpSession session = req.getSession(false);
      PrintWriter out = resp.getWriter();
		
      session.setAttribute("email", req.getParameter("email"));

      if (session == null) {
        out.println("session checking");
	System.out.println("session checking");
	resp.sendRedirect("error.html");
	System.out.println("After session checking");
      }
      rd = req.getRequestDispatcher("output.jsp");
      rd.forward(req, resp);
   }

}
