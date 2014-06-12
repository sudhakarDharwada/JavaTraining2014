package com.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.util.Enumeration;
import java.util.ResourceBundle;
public class LoginServlet extends HttpServlet
{
	public void init( ){
		
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		System.out.println("sample1");
		ServletContext ctx = req.getServletContext();
		ResourceBundle rb = (ResourceBundle) ctx.getAttribute("input");
		String uname=req.getParameter("user");
		String pwd=req.getParameter("passwd");
		System.out.println(rb);
		String passwd=rb.getString(uname);
		if(uname!=null && pwd!=null)
		{
			if(passwd.equals(pwd) && passwd!=null && pwd!=null)
			{
				
				HttpSession session = req.getSession();
				session.setAttribute("uname", uname);
				RequestDispatcher dispatch=req.getRequestDispatcher("success.html");
				dispatch.forward(req,res);
			}
			else
			{
				RequestDispatcher dispatch=req.getRequestDispatcher("login.html");
				pw.print("username or password is incorrect");
				dispatch.include(req, res);
			}
		}
		else
		{
			RequestDispatcher dispatch=req.getRequestDispatcher("login.html");
			pw.print("username or password is incorrect");
			dispatch.include(req, res);
		}
		
		pw.close();
	}
	
}
