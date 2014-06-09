package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Details extends HttpServlet{

   PrintWriter out ;
   protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
     out = res.getWriter();
     HttpSession session = req.getSession(true);
     String name = (String)session.getAttribute("name");
     if(session == null){
       System.out.println("not logged");
       out.print("not logged!!!!!!");
     }
     else{
       System.out.println(" logged");
     }
     out.println("Hello  "+name + "you have successfully logged in");
     out.println("Email : "+req.getParameter("email"));

     session.setAttribute("email", req.getParameter("email"));
  }

}
