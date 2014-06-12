package com.vl.profile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Profile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try{
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Profile</title><link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"></head><body>");
			System.out.println("Enter into profile");
			HttpSession hs=request.getSession();
			ServletContext context=request.getServletContext();
			
			String name=hs.getAttribute("uname").toString();
			ResourceBundle prop=(ResourceBundle) context.getAttribute("prop");
			if(name!=null){
				String value[]=prop.getString(name).split(",");
				String photo=name.concat(".jpg");
				String path="./images/".concat(photo);
				out.println("<table border=\"1\" width=\"1000\" align=\"center\"><tr height=\"200\"><td>Head</td></tr><tr height=\"50\"><td><div id=\"templatemo_menu\"><ul><li><a href=\"home.html\" class=\"current\">Home</a></li><li><a href=\"./profile\">Profile</a></li><li><a href=\"Services.html\">Services</a></li><li><a href=\"toDay.html\">toDay</a></li><li><a href=\"Company.html\">Company</a></li><li><a href=\"Contactus.html\">Contact</a></li><li><a href=\"./Logout/\" class=\"last\">Logout</a></li></ul></div></td></tr><tr height=\"500\"><td><table border=\"0\" align=\"center\"><tr><td colspan=\"3\"></td><td><img src=\""+path+"\" height=\"100\" width=\"100\" /></td></tr><tr><th>Name</th><td>:</td><td>"+value[0]+" "+value[1]+"</td></tr><tr><th>Email</th><td>:</td><td>"+value[3]+"</td></tr><tr><th>phone</th><td>:</td><td>"+value[4]+"</td></tr></table></td></tr><tr height=\"50\"><td>footer</td></tr></table>");
			}
			else{
				out.println("<h2>Session Expire <a href=\"./LoginPage\">click here</a> to Login</h2>");
			}
		}
		catch(Exception e){
			out.println("<h2>Session Expire <a href=\"./LoginPage\">click here</a> to Login</h2>");
		}
	}
}
