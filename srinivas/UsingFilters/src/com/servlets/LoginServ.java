package com.servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.listners.AppContextListener;

public class LoginServ extends HttpServlet {

	//String file;
	//Properties prop;
	//PrintWriter out;
	RequestDispatcher rd;

	public void init() {
		//file = "users.properties";
		//prop = new Properties();
		
		
		/*FileInputStream input = null;
		try {
			input = new FileInputStream(file);
			prop.load(input);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}*/

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {


		//HttpSession session = req.getSession(false);
		//out = res.getWriter();
		rd = req.getRequestDispatcher("userdetails.html");
		rd.include(req, res);
	}


}
