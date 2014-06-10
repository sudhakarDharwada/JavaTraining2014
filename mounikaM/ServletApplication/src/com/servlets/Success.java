package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Success extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Success() {
        super();
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		long l = 0;
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		
		PrintWriter out=response.getWriter();
		if(session!=null)
		{
			String name=(String)session.getAttribute("uname");  
			
			
			String dob=request.getParameter("dob");
			try
			{	
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date d2=dateFormat.parse(dob);
				l=System.currentTimeMillis()-d2.getTime();
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}
			out.println("<html>");
			out.println("<body>");
			out.println("<form action='serv3' method='post'>");
			out.println(name+", your age is "+TimeUnit.MILLISECONDS.toDays(l)/365+" years <br/>");
			out.println("<input type='submit' name='logout' value='logout'/><br/>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		}
		session.invalidate();
	}

}

