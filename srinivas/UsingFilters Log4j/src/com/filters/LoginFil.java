package com.filters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class LoginFil implements Filter {

	String file;
	Properties prop;
	PrintWriter out;
	RequestDispatcher rd; 
	static Logger logger = Logger.getLogger(LoginFil.class);

	@Override
	public void destroy() {


	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain filterchain) throws IOException, ServletException {
		
		
		logger.debug("DEBUG message");
		/*logger.info("INFO message");
		logger.error("Error message");
		logger.warn("WARN message");
		logger.fatal("FATAL message");*/

		logger.info("At loginfilter");
		logger.warn("this is warning");
		System.out.println("At loginfilter");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		HttpSession session = request.getSession(true);
		PrintWriter out = res.getWriter();
		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");
		//if(session.isNew()){
		
		Set<Entry<Object, Object>> s= prop.entrySet();
		
		logger.info("checking set"+s.isEmpty());
		System.out.println("checking set"+s.isEmpty());
		
		for (Entry<Object, Object> e : prop.entrySet()) {
			String name2 = (String) e.getKey();
			String pwd2 = (String) e.getValue();
			System.out.println("name2 "+ name2 +""+ pwd2);
			if (name2.equals(name) && pwd2.equals(pwd)) {
				logger.info("equal!");
				System.out.println("Equal!!");
				session.setAttribute("name", name);
				rd = req.getRequestDispatcher("userdetails.jsp");
				rd.forward(req, res);
			}

			else {
				System.out.println("Not find!");
				RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/home.html");
				
	            out.println("<font color=red>Either user name or password is wrong.</font>");
	            rd.include(req, res);
				
			}
		}

		
		 String uri = request.getRequestURI();
		 
			if(uri.endsWith(".jsp")){
				System.out.println("app is redirected to home.html page from home.jsp!!!!!!");
				response.sendRedirect("home.html");
			}
			
			filterchain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {

		file = "/home/valuelabs/workspace/task/WebContent/users.properties";
		prop = new Properties();
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
			prop.load(input);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}




}