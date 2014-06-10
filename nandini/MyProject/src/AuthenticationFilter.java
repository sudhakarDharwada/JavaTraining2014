
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class AuthenticationFilter implements Filter{
	private ServletContext context;
	@Override
    
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
		if(session==null && !(uri.endsWith("Login.html") || uri.endsWith("Login")))
			res.sendRedirect("Login.html");
		else{
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
		
	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		// TODO Auto-generated method stub
		this.context=fconfig.getServletContext();
		this.context.log("Authenticatin Filter Initialized");
	}

}
