package com.val.Filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
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

import com.val.DAO.Credentials;

public class AuthenticationFilter implements Filter 
{
	HashMap<String, String> hp=null;
	@Override
	public void destroy() {
		
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("In Filter");
		
		Credentials cd=new Credentials();
		try 
		{
			hp=cd.getCredentials();
			HttpServletRequest request=(HttpServletRequest)req;
			HttpServletResponse response=(HttpServletResponse)resp;
			HttpSession session=request.getSession();
			PrintWriter out=response.getWriter();
			String email=req.getParameter("email");
			
			String password=req.getParameter("pwd");
			if(email!=null && email!="" && hp.containsKey(email))
			{	
				if(hp.get(email).equals(password))
				{
					session.setAttribute("login", "true");
					chain.doFilter(req, resp);
				}
			}
			request.getRequestDispatcher("Login.html").include(req, resp);
			out.println("<center>Login Failed<center>");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		
	}

}
