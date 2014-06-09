package com.servlets;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
public class LoginServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		doPost(request, response);
	}
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		LoadPropertyFile p=LoadPropertyFile.getInstance(getServletContext());
		
		String uname=req.getParameter("t1");
		String pwd=req.getParameter("t2");
		String passwd=p.getProperty(uname);
	//	HttpSession session = req.getSession();
	//	session.setAttribute("uname", uname);
	//	session.setAttribute("passwd", passwd);
	//	RequestDispatcher dispatch=req.getRequestDispatcher("Confirm.java");
	//	dispatch.forward(req,res);
		String name=p.getProperty(uname);
		try{
			if(name.equals(pwd) && name!=null && pwd!=null)
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
		catch(NullPointerException ne)
		{
			RequestDispatcher dispatch=req.getRequestDispatcher("login.html");
			pw.print("username or password is incorrect");
			dispatch.include(req, res);	
		}
		pw.close();
	}
	
}
