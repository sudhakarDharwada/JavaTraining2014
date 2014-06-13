package com.vl.filters;

import java.io.IOException;
import java.io.PrintWriter;

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




public class MyFilter implements Filter {
	static Logger log = Logger.getLogger(MyFilter.class);
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response2=(HttpServletResponse) response;
		response2.setContentType("text/html");
		log.info("Myfilter");
		PrintWriter out=response2.getWriter();
		HttpSession hs=((HttpServletRequest) request).getSession();
		String uname=(String) hs.getAttribute("uname");
		if(uname!=null){
			log.info("session existing and username is"+uname);
			chain.doFilter(request, response);
		}
		else{
			log.info("session Expires "+uname);
			out.println("<h2>Session Expire <a href=\"./LoginPage\">click here</a> to Login</h2>");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
