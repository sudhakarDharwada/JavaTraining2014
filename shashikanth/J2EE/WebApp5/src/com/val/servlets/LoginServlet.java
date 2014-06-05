package com.val.servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Properties prop=new Properties();
	private String filepath;
	public void init(ServletConfig config) throws ServletException 
	{
		filepath=config.getServletContext().getInitParameter("User-Credentials");
		try 
		{
			InputStream input=new FileInputStream(filepath);
			prop.load(input);
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		RequestDispatcher rds=req.getRequestDispatcher("Login.jsp");
		String userName=req.getParameter("username");
		String password=req.getParameter("password");
		HttpSession session=req.getSession();
		session.setAttribute("usrname",userName);
		session.setAttribute("pwd",password);
		PrintWriter out=resp.getWriter();
		for(String key:prop.stringPropertyNames())
		{
			String value=prop.getProperty(key);
			if(userName.equals(key)&& password.equals(value))
			{
				session.setAttribute("login","true");
				resp.sendRedirect("Success.jsp");
				break;
			}
		}
		rds.include(req, resp);
		out.println("<center>Login Failed</center>");
	}	
}
