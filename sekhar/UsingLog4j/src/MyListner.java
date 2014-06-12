

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@WebListener
public class MyListner implements ServletContextListener {
	static Logger log = Logger.getLogger(MyListner.class.getClass());
    public void contextInitialized(ServletContextEvent event) {
       PropertyConfigurator.configure("/home/administrator/Desktop/javapgms1/GmailsUsingFiltersListerners/log4j.properties");
       log.info("context init");
       ResourceBundle bundle=ResourceBundle.getBundle("data");
       ServletContext context=event.getServletContext();
       context.setAttribute("data", bundle);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
    	log.info("context destroy");
        ResourceBundle.clearCache();
    }
	
}
