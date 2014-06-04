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
		System.out.println("++++++++++++++++");
		filePath = getServletContext().getInitParameter("properties-file");
		System.out.println("*******************");
		System.out.println(filePath);
	}
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}*/

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException 
	{
		RequestDispatcher rd = req.getRequestDispatcher("/login.html");
		RequestDispatcher rd1 = req.getRequestDispatcher("/usr.jsp");
		String islogin="false";
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		System.out.println("enter");
		Properties prop=new Properties();
		input=new FileInputStream(filePath);
		prop.load(input);
		String usrname=req.getParameter("usrname");
		System.out.println(usrname);
		String password=req.getParameter("pwd");
		if(usrname==null)
		{
			rd1.forward(req, resp);
		}
		else
		{
		HttpSession session = req.getSession();
		session.setAttribute("name", usrname);
		for(Entry<Object, Object> e:prop.entrySet())
		{
			if(usrname.equals(e.getKey())&&password.equals(e.getValue()))
			{
				islogin="true";
				session.setAttribute("islogin",islogin );
				rd1.forward(req, resp);
				break;
			}
		}
		rd.include(req, resp);
		out.println("<center><font size="+"2"+" color="+"red"+"> username(or)password you entered is incorrect</font></center>");
		}
	}

}
