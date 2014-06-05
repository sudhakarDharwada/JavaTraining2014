package com.servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	String file;
	Properties prop;
	PrintWriter out;
	RequestDispatcher rd;

	public void init() {
		file = "/home/valuelabs/workspace/task/WebContent/WEB-INF/users.properties";
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

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String name = req.getParameter("name");
		String pwd = req.getParameter("pwd");

		HttpSession session = req.getSession(true);
		

		out = res.getWriter();
		
		for (Entry<Object, Object> e : prop.entrySet()) {
			String name2 = (String) e.getKey();
			String pwd2 = (String) e.getValue();
			if (name2.equals(name) && pwd2.equals(pwd)) {
				System.out.println("Equal!!");
				session.setAttribute("name", name);
				rd = req.getRequestDispatcher("userdetails.jsp");
				rd.forward(req, res);
			}

			else {
				System.out.println("Not find!");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.html");
	            PrintWriter out= res.getWriter();
	            out.println("<font color=red>Either user name or password is wrong.</font>");
	            rd.include(req, res);
				
			}
		}

	}

}
