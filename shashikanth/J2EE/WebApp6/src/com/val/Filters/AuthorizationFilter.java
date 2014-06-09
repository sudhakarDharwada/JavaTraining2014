package com.val.Filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter
{

	public void destroy() 
	{	
	}
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException 
	{	
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession session=request.getSession(false);
		if(session!=null)
		{
			chain.doFilter(req, resp);
		}
		else
		{
			response.sendRedirect("Login.html");
		}
	}
	public void init(FilterConfig filterconfig) throws ServletException 
	{
	}
}
