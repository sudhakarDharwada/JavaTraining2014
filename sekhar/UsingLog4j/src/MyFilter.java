

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyFilter implements Filter {
	static Logger log = Logger.getLogger(MyFilter.class.getClass());

	public MyFilter() {
	}
	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PropertyConfigurator.configure("/home/administrator/Desktop/javapgms1/GmailsUsingFiltersListerners/log4j.properties");
		HttpServletRequest req= (HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		PrintWriter out=res.getWriter();
		HttpSession hs=req.getSession();
		log.info("welcome to filter");
		if(hs!=null){
			chain.doFilter(request, response);
		}
		else{
			out.print("Please login first");
			res.sendRedirect("./LoginPage");
			log.info("Myfiter to Login");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
