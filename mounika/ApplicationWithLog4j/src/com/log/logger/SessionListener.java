package com.log.logger;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class SessionListener implements HttpSessionListener {
	private int sessionCount = 0;
	static Logger logger = Logger.getLogger(SessionListener.class);

	public void sessionCreated(HttpSessionEvent event) {
		synchronized (this) {
			sessionCount++;
		}
		logger.info("sessions created" + event.getSession().getId());
		logger.info("Sessions" + sessionCount);

	}

	public void sessionDestroyed(HttpSessionEvent event) {
		synchronized (this) {
			sessionCount--;
		}
		logger.info("session Destroyed" + event.getSession().getId());
		logger.info("Sessions" + sessionCount);
	}

}
