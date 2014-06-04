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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("/login.html");
		String islogin="false";
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		Properties prop=new Properties();
		input=new FileInputStream(filePath);
		prop.load(input);
		String usrname=req.getParameter("usrname");
		String password=req.getParameter("pwd");
		HttpSession session = req.getSession();
		session.setAttribute("name", usrname);
		for(Entry<Object, Object> e:prop.entrySet())
		{
			if(usrname.equals(e.getKey())&&password.equals(e.getValue()))
			{
				islogin="true";
				session.setAttribute("islogin",islogin );
				resp.sendRedirect("usr.jsp");
				break;
			}
		}
		rd.include(req, resp);
		out.println("<center><font size="+"2"+" color="+"red"+"> username(or)password you entered is incorrect</font></center>");
	}

}
