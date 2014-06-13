package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import listeners.ServletListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger =Logger.getLogger(Login.class);
			
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletListener sl=ServletListener.getInstance(getServletContext());
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("username");
        out.println(uname);
        String pwd=request.getParameter("userpasswrd");
        out.println(pwd);
        
		PropertyConfigurator.configure("/home/vnandini/workspace/ServletAppwithLog4j/WebContent/WEB-INF/log4j.properties");
		
		System.out.println("logger :" +logger.getName());
		response.setContentType("text/html;charset=UTF-8"); 
        

        
        String passwd=sl.getProperty(uname);
        System.out.println("password"+passwd);
        
        if(pwd.equals(passwd))
        {
        	logger.info("User Details matched");
        	System.out.println("if condition");
        	HttpSession session = request.getSession();
        	session.setAttribute("uname", uname);
        	response.sendRedirect("LoginSuccess.html");
        }
        else
        {
        	logger.warn("User Details Does not match");
        	RequestDispatcher dis=request.getRequestDispatcher("Login.html");
        	out.write("Enter the username and password correctly");
        	dis.include(request, response);
        }
        
	}

}