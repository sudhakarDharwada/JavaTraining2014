

import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyListner
 *
 */
@WebListener
public class MyListner implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {
       ResourceBundle bundle=ResourceBundle.getBundle("data");
       ServletContext context=event.getServletContext();
       context.setAttribute("data", bundle);
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        ResourceBundle.clearCache();
    }
	
}
