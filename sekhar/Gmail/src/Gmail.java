import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.txw2.Document;
@WebServlet("/Gmail")
public class Gmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Gmail() {
		super();
	}
	public void init(ServletConfig config) throws ServletException {


	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname=request.getParameter("userid");
		String pwd=request.getParameter("pswrd");
		try {
			File file = new File("/home/administrator/Desktop/javapgms1/Gmail/WebContent/WEB-INF/data.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			fileInput.close();
			String value = properties.getProperty(uname);
			if(pwd.equalsIgnoreCase(value))
			{
				Cookie ck=new Cookie("uname",uname);
				response.addCookie(ck);
				request.getRequestDispatcher("page1.html").forward(request, response);
			}
			else
			{
				 out.print("Sorry UserName or Password Error!");  
			        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
			        rd.include(request, response);  
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
