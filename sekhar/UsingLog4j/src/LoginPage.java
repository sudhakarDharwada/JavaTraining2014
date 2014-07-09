

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		PrintWriter out=response.getWriter();
		out.println("<html><head><title>Login page</title></head><center><body><h1 style=\"font-family: Comic Sans Ms;\"center\";font-size:20pt;color:#00FF00;>Simple Login Page</h1><form action=./Gmail>Username<input type=\"text\" name=\"userid\" /><br><br>Password<input type=\"password\" name=\"pswrd\" /><br><br><input type=\"submit\" value=\"submit\" /><input type=\"reset\" value=\"Cancel\" /></form></body></center></html>");
	}
	
}


