package listeners;

import java.util.ResourceBundle;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UserPasswordProperties implements ServletContextListener
{
	static final Logger log = Logger.getLogger(UserPasswordProperties.class);
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext cnt=event.getServletContext();
		String file=cnt.getInitParameter("property-files");
		ResourceBundle rbl = ResourceBundle.getBundle(file);
		PropertyConfigurator.configure(cnt.getInitParameter("property-log"));
		log.info("context initialised");
		if(file==null)
		{
			log.error("property file is not found");
		}
		cnt.setAttribute("input", rbl);
	}
	public void contextDestroyed(ServletContextEvent event) 
	{
		log.info("servlet context listener is destroyed");
	} 
}

