package com.servlets.filters;

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

import org.apache.log4j.Logger;

public class AuthorizationFilter implements Filter {
	static Logger log=Logger.getLogger(AuthorizationFilter.class);
	
	public void destroy()
	{	
	}
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException
	{	
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpSession session=request.getSession();
		if(session!=null)
		{
			log.info("user detailes are there in session");
			chain.doFilter(req, resp);
		}
		else
		{
			log.warn("redirecting to login page");
			response.sendRedirect("login.html");
		}
	}
	public void init(FilterConfig filterconfig) throws ServletException
	{
	}
}
