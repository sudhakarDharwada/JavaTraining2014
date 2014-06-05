package com.servlet.urlencoding;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UrlEncoding extends HttpServlet{
	static String fileName;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config){
		fileName = config.getInitParameter("file");
		//System.out.println(fileName);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);

		String uname=request.getParameter("name");
		String pass=request.getParameter("pass");


		PrintWriter pw=response.getWriter();
		ServletContext context=request.getServletContext();
		HttpSession session=request.getSession();
		session.setAttribute("n1", uname);


		for(String key:prop.stringPropertyNames())
		{
			String value=prop.getProperty(key);
			if(uname.equals(key)&& pass.equals(value))
			{
				session.setAttribute("login","true");
				response.sendRedirect("success.jsp");
				break;
			}
		}
		RequestDispatcher rd=context.getRequestDispatcher("/user.jsp");
		rd.include(request, response);
		pw.println("Login Failed");	
	}
}
