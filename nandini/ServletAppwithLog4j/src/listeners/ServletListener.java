package listeners;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;


public class ServletListener implements ServletContextListener{
	private static final String ATTRIBUTE_NAME = "prop";
	Properties prop = new Properties();
	static final Logger logger =Logger.getLogger(ServletListener.class);
	public void contextInitialized(ServletContextEvent event) {
// TODO Auto-generated method stub
		
		logger.info("Initialized");
	
		try {
			prop.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/Properties/details.properties"));
        }
		catch (IOException e) {
          logger.error("IOException is tracked",e);
        }
        event.getServletContext().setAttribute(ATTRIBUTE_NAME, this);
	}

@Override
	public void contextDestroyed(ServletContextEvent event) {
// TODO Auto-generated method stub
		prop.clear();

	}
	public static ServletListener getInstance(ServletContext context) {
        return (ServletListener) context.getAttribute(ATTRIBUTE_NAME);
    }

    public String getProperty(String key) {
    	logger.info("key value is obtained is: " + prop.getProperty(key)+" ");
        return prop.getProperty(key);
    }


}

