package com.servlets.filters;

import java.io.IOException;
import java.io.PrintWriter;
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

import org.apache.log4j.Logger;

public class AuthenticationFilter implements Filter{
	ResourceBundle rb=null;
	static ServletContext context;
	static Logger log=Logger.getLogger(AuthenticationFilter.class);
	public void destroy()
	{
	}
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain chain) throws IOException, ServletException
	{
		
		context=req.getServletContext();
		log.debug("checking loading properies file or not");
		rb=(ResourceBundle) context.getAttribute("file");
		log.info("property file loaded");
		
		HttpServletResponse response=(HttpServletResponse)resp;
		HttpServletRequest request=(HttpServletRequest)req;
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		String username=req.getParameter("username");
		//String password=req.getParameter("pwd");
		session.setAttribute("name", username);
		
		log.debug("checking whether entered into if condition or not");
		if(rb.containsKey(username)){
			log.info("entered into if condition");
			session.setAttribute("login", "true");
			log.info("checking user credentials info: "+username);
			chain.doFilter(req, resp);
		}
		request.getRequestDispatcher("login.html").include(req, resp);
		out.println("<center>Login Failed<center>");
	}
	public void init(FilterConfig filterconfig) throws ServletException
	{
		//context=filterconfig.getServletContext();
	}
}
