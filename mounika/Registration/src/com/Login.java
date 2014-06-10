package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
	 Properties prop;

	protected String myParam = null;

	  public void init(ServletConfig servletConfig) throws ServletException{
	    this.myParam = servletConfig.getInitParameter("myParam");
	  
       
    	
        try {
        	 prop = new Properties();
        	 System.out.println("hi");
        	

           // String path = getServletConfig().getInitParameter("login.properties");
            FileInputStream is = new FileInputStream(myParam);
            System.out.println(myParam);
            try {
                prop.load(is);
             // System.out.println(is);
               // System.out.println(prop.getProperty("mounika"));
                
                
        		
            } finally {
                is.close();
            }
        } catch (Exception asd) {
            System.out.println(asd.getMessage());
        }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("username");
		String pwd1=request.getParameter("pwd");
		
		HttpSession session = request.getSession(false);
		 session.setAttribute("name", name);
	
		for (Entry<Object, Object> entry : prop.entrySet())
		{
		
		if(name.equals(entry.getKey())&& pwd1.equals(entry.getValue()))
		{
			RequestDispatcher rd=request.getRequestDispatcher("List.jsp");	
			rd.forward(request, response);
		}
	    }
		
		
		
		
		
		
         
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
