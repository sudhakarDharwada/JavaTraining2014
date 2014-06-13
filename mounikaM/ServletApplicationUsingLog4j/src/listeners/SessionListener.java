package listeners;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{

	static final Logger log = Logger.getLogger(SessionListener.class);
	
	
	public void sessionCreated(HttpSessionEvent sessionEvent) 
	{
		PropertyConfigurator.configure(((ServletContext) sessionEvent.getSession()).getInitParameter("property-log"));
		log.info("session created "+sessionEvent.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent sessionEvent) 
	{
		log.info("session destroyed "+sessionEvent.getSession().getId());
	}
	
	public void attributeAdded(HttpSessionBindingEvent event) 
	{
		//PropertyConfigurator.configure(((ServletContext) event.getSession()).getInitParameter("property-log"));
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		log.info("Attribute added "+attributeName + " : " + attributeValue);
	}

	public void attributeRemoved(HttpSessionBindingEvent event) 
	{
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		log.info("Attribute removed "+attributeName + " : " + attributeValue);
	}

	public void attributeReplaced(HttpSessionBindingEvent event) 
	{
		String attributeName = event.getName();
		Object attributeValue = event.getValue();
		log.info("attribut value changed to "+attributeName + " : " + attributeValue);
	}

}

