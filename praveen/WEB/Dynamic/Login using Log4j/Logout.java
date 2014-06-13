package com.vl.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;


public class Logout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Logger logger=Logger.getLogger(Logout.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException ,IOException{
		try{
			HttpSession hs=request.getSession();
			logger.info("uname "+hs.getAttribute("uname"));
			hs.removeAttribute("uname");
			logger.info("uname "+hs.getAttribute("uname"));
			hs.invalidate();
			response.sendRedirect("./LoginPage");
		}
		catch(Exception e) {
			logger.error(e);
		}
	}
}
