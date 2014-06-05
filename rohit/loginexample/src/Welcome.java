package com.loginexample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Welcome extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	String filePath;
	FileInputStream input;
	public void init( ){
		filePath = getServletContext().getInitParameter("properties-file");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("/login.html");
		String islogin=null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Properties prop=new Properties();
		input=new FileInputStream(filePath);
		prop.load(input);
		String usrname=request.getParameter("usrname");
		String password=request.getParameter("pwd");
		for(Entry<Object, Object> e:prop.entrySet())
		{
			if(usrname.equals(e.getKey())&&password.equals(e.getValue()))
			{
				HttpSession session = request.getSession();
				session.setAttribute("name", usrname);
				islogin="true";
				session.setMaxInactiveInterval(60);
				session.setAttribute("islogin",islogin );
				response.sendRedirect("usr.jsp");
				break;
			}
		}
		rd.include(request, response);
		out.println("<center><font size="+"2"+" color="+"red"+"> username(or)password you entered is incorrect</font></center>");
	}

}
