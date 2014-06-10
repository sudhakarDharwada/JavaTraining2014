

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class Page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Page1() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs=request.getSession();
		String session=hs.getAttribute("uname").toString();
		if(!hs.isNew()){
			if(session!=null){
				String title = "Welcome to value labs site";
				out.println(
						"<html>\n" +
						"<head><title>" + title + "</title></head>\n" +
						"<body bgcolor=\"#f0f0f0\">\n" +
						"<h1 align=\"center\">" + title + "</h1>\n" +
						"</body></html>");
				out.print("<br>you want to register pls click it other wise click notnow</br>");
				out.print("<a href=\"Gmail.html\">Register</a> ");
				out.print("<a href=\"./Logout\">NotNow</a>");
			}
			else{
				out.print("<h1>Sorry you must visit login page!</h1>");  
				RequestDispatcher rd=request.getRequestDispatcher("./Logout");  
				rd.include(request, response);

			}
		}
		else {
			out.print("<h1>Sorry you must visit login page!</h1>");  
			RequestDispatcher rd=request.getRequestDispatcher("./Logout");  
			rd.include(request, response);
		}
	}
	
}


