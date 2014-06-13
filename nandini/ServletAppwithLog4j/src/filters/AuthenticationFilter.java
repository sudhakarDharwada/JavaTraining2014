package filters;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import java.io.IOException;

public class AuthenticationFilter implements Filter{
	private ServletContext context;
	static Logger logger =Logger.getLogger(AuthenticationFilter.class);
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		HttpSession session=req.getSession(false);
		if(session==null && !(uri.endsWith("Login.html") || uri.endsWith("Loggedin")))
		{
			logger.error("uri doesnot match");
			res.sendRedirect("Login.html");
		}
			else{
            // pass the request along the filter chain
				logger.info("uri matched");
            chain.doFilter(request, response);
        }
		
	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context=fconfig.getServletContext();
		logger.info("Authenticatin Filter Initialized");
	}

}
