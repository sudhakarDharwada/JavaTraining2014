package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		PrintWriter out=response.getWriter();
		response.setContentType("text/html;charset=UTF-8");
        
        ServletListener sl=ServletListener.getInstance(getServletContext());


        String uname=request.getParameter("username");
        out.println(uname);
        String pwd=request.getParameter("userpasswrd");
        out.println(pwd);
        
        String passwd=sl.getProperty(uname);
        System.out.println("password"+passwd);
        
        if(pwd.equals(passwd))
        {
        	System.out.println("if condition");
        	HttpSession session = request.getSession();
        	session.setAttribute("uname", uname);
        	response.sendRedirect("LoginSuccess.html");
        }
        else
        {
        	RequestDispatcher dis=request.getRequestDispatcher("Login.html");
        	out.write("Enter the username and password correctly");
        	dis.include(request, response);
        }
        
	}

}