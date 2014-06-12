package com.vl.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;


public class LoginFilter implements Filter {
	static Logger log = Logger.getLogger(LoginFilter.class);
	public void destroy() {
	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("LoginFilters");
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
