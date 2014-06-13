package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginServ extends HttpServlet {

	RequestDispatcher rd;
	static Logger logger = Logger.getLogger(DisplayDetailsServlet.class);

	public void init() {
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {


		logger.info("at LoginServ class");
		rd = req.getRequestDispatcher("userdetails.html");
		rd.include(req, res);
	}


}
