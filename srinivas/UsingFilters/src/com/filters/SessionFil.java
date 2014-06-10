package com.filters;

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

public class SessionFil implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,FilterChain filterchain) throws IOException, ServletException {
		
		HttpServletRequest request  = (HttpServletRequest) req;
		HttpServletResponse response  = (HttpServletResponse) resp;
		
		HttpSession session = request.getSession(false);
		
		session.setAttribute("fname", req.getParameter("firstname"));
		session.setAttribute("lname", req.getParameter("lastname"));
		session.setAttribute("email", req.getParameter("email"));
		session.setAttribute("vehicle", req.getParameter("vehicle"));
		session.setAttribute("country", req.getParameter("Country"));
		
		filterchain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	

}
