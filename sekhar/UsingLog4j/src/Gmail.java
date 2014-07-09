import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
public class Gmail extends HttpServlet {
	static Logger log = Logger.getLogger(Gmail.class.getClass());

	private static final long serialVersionUID = 1L;
	public Gmail() {
		super();
	}
	public void init(ServletConfig config) throws ServletException {

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
		String uname=request.getParameter("userid");
		String pwd=request.getParameter("pswrd");
		if(uname!=null&&uname!=""&&pwd!=null&&pwd!=""){
			ServletContext context =request.getServletContext();
			ResourceBundle bundle=(ResourceBundle) context.getAttribute("data");
			try {
				String value = bundle.getString(uname);
				if(pwd.equalsIgnoreCase(value))
				{
					log.info("pwd is valid");
					HttpSession hs=request.getSession();
					hs.setAttribute("uname",uname);
					response.sendRedirect("./Page1");
					log.info("session is created"+uname);
				}
				else
				{
					log.info("pwd wrong pls check once");
					out.print("<h1>Sorry UserName or Password Error!</h1>");  
					response.sendRedirect("./LoginPage");  
				}

			} catch (FileNotFoundException e) {
				log.error(e);
			} catch (IOException e) {
				log.error(e);			
			} catch(MissingResourceException e){
					log.info("session expire pls login");
					out.print("<h1>Session Expire pls login again</h1>");  
					response.sendRedirect("./LoginPage");  
				}
		}
		else {
			log.info("session expire plsssss login");
			out.print("<h1>Session Expire pls login again</h1>");  
			response.sendRedirect("./LoginPage");  
		}

	}

}
