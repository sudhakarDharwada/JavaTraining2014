package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import servlets.LoginServlet;

@WebFilter("/ServletFilter")
public class ServletFilter implements Filter {
	
	static final Logger log = Logger.getLogger(ServletFilter.class);

	public void destroy()
	{
		log.info("Servlet Filter is destroyed");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String uri = req.getRequestURI();
		HttpSession session=req.getSession(false);  
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		res.setHeader("Pragma", "no-cache");
		res.setDateHeader("Expires", 0); 
		 if(session == null && !(uri.endsWith("login.html")|| uri.endsWith("serv1")))
		 {
			 log.error("accessing incorect uri"+uri);
			 res.sendRedirect("login.html");
	     }
		 else
		 { 
			 chain.doFilter(request, response);
		 }
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
	     log.info("Servlet Filter is initialized");
	}
}


