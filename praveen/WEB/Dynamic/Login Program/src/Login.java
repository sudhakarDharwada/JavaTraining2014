package com.vl.main;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vl.resources.PropertyLoader;
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		Properties prop=PropertyLoader.getInstance();

		String name=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String val=prop.getProperty(name);
		if(val!=null){

			String value[]=prop.getProperty(name).split(",");
			for(int i=0;i<value.length;i++){
				System.out.println(value[i]);
			}
			if(value[2].equals(pwd)){
				HttpSession hp=request.getSession();
				hp.setAttribute("uname", name);
				response.sendRedirect("home.jsp");
				System.out.println("matches");
			}
			else {
				response.sendRedirect("LoginErr.html");
				System.out.println("not matches");
			}
		}
		else {
			response.sendRedirect("LoginErr.html");
			System.out.println("not matches");
		}
	}

}
