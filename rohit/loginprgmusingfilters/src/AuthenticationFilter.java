package com.webapp2;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/AuthenticationFilter")
public class AuthenticationFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		HttpSession session = req.getSession(false);
		if(session == null && !(uri.endsWith("login.html") || uri.endsWith("LoginServlet"))){
			res.sendRedirect("login.html");
		}else{
			chain.doFilter(request, response);
		}
	}

	public void destroy() {
		//close any resources here
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
