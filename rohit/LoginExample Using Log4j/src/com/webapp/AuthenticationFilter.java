package com.webapp;

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

public class AuthenticationFilter implements Filter {
	
	public static Logger log; 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		log.debug("checking autherisation using filter");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		log.debug("requested uri: "+uri);
		HttpSession session = req.getSession(false);
		if(session == null && !(uri.endsWith("login.html") || uri.endsWith("login")))
		{
			log.info("Info : unautherised request");
			res.sendRedirect("login.html");
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException 
	{
		log = Logger.getRootLogger();
	}
}