package com.val.Filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter 
{
	ResourceBundle rb=null;
	public void destroy()
	{
	}
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException 
	{
		ServletContext context=req.getServletContext();
		rb=(ResourceBundle) context.getAttribute("file");
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String username=req.getParameter("username");
		String password=req.getParameter("pwd");
		if(username!=null && username!="" && rb.containsKey(username))
		{	
			if(rb.getString(username).equals(password))
			{
				session.setAttribute("login", "true");
				chain.doFilter(req, resp);
			}
		}
		request.getRequestDispatcher("Login.html").include(req, resp);
		out.println("<center>Login Failed<center>");
	}
	public void init(FilterConfig filterconfig) throws ServletException 
	{
		
	}
}
