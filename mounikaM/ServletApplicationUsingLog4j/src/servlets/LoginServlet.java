package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.ResourceBundle;
public class LoginServlet extends HttpServlet
{
	static Logger log = Logger.getLogger(LoginServlet.class);
	
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		ServletContext ctx = req.getServletContext();
		ResourceBundle rb = (ResourceBundle) ctx.getAttribute("input");
		System.out.println();
		PropertyConfigurator.configure(ctx.getInitParameter("property-log"));
		String uname=req.getParameter("user");
		String pwd=req.getParameter("passwd");
		if(uname!=null && pwd!=null && rb.containsKey(uname))
		{
			String passwd=rb.getString(uname);
			if(passwd.equals(pwd) && passwd!=null && pwd!=null)
			{
				HttpSession session = req.getSession();
				session.setAttribute("uname", uname);
				RequestDispatcher dispatch=req.getRequestDispatcher("success.html");
				dispatch.forward(req,res);
			}
			else
			{
				RequestDispatcher dispatch=req.getRequestDispatcher("login.html");
				pw.print("username or password is incorrect");
				dispatch.include(req, res);
			}
		}
		else
		{
			log.warn("didnt enter the user name or password");
			RequestDispatcher dispatch=req.getRequestDispatcher("login.html");
			pw.print("username or password is incorrect");
			dispatch.include(req, res);
		}
		pw.close();
	}
	
}

