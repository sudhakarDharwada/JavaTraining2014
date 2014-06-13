

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Page1 extends HttpServlet {
	static Logger log = Logger.getLogger(Page1.class.getClass());

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
		PropertyConfigurator.configure("/home/administrator/Desktop/javapgms1/GmailsUsingFiltersListerners/log4j.properties");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession hs=request.getSession();
		String session=hs.getAttribute("uname").toString();
		if(!hs.isNew()){
			if(session!=null){
				log.info("session is not a null");
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
				log.fatal("session is null");
				out.print("<h1>Sorry you must visit login page!</h1>");  
				RequestDispatcher rd=request.getRequestDispatcher("./Logout");  
				rd.include(request, response);

			}
		}
		else {
			log.warn("session is new");
			out.print("<h1>Sorry you must visit login page!</h1>");  
			RequestDispatcher rd=request.getRequestDispatcher("./Logout");  
			rd.include(request, response);
		}
	}
	
}


