package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/*
	 * public void init(ServletConfig servletConfig) throws ServletException {
	 * this.myParam = servletConfig.getInitParameter("myParam");
	 * 
	 * try { prop = new Properties(); System.out.println("hi");
	 * 
	 * // String path = //
	 * getServletConfig().getInitParameter("login.properties"); FileInputStream
	 * is = new FileInputStream(myParam); System.out.println(myParam); try {
	 * prop.load(is); // System.out.println(is); //
	 * System.out.println(prop.getProperty("mounika"));
	 * 
	 * } finally { is.close(); } } catch (Exception asd) {
	 * System.out.println(asd.getMessage()); } }
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletContext ctx = request.getServletContext();
		ResourceBundle resource = (ResourceBundle) ctx.getAttribute("file");
		String name = request.getParameter("username");
		String pwd1 = request.getParameter("pwd");

		HttpSession session = request.getSession();
		session.setAttribute("name1", name);

		/*
		 * for (Entry<Object, Object> entry : prop.entrySet()) {
		 * System.out.println((entry.getKey())); if (name.equals(entry.getKey())
		 * && pwd1.equals(entry.getValue())) {
		 */
		// Enumeration<String> e = resource.getKeys();
		if (name==null && resource.containsKey(name)) {
			/*
			 * String name2 = e.nextElement(); String paswd1 =
			 * resource.getString(name2); System.out.println(name2);
			 */

			if (resource.getString(name).equals(pwd1))

			{
				response.sendRedirect("List.html");
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
	}
}
