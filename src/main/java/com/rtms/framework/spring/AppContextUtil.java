package com.rtms.framework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class AppContextUtil {

	public static String applicationContextfile = "";
	private static ApplicationContext appContext = null;

	/**
	 * This method returns the Application context for the spring.
	 * 
	 * @return Spring ApplicationContext
	 */
	public static ApplicationContext getAppcontext() {
		if (appContext == null) {
			appContext = new ClassPathXmlApplicationContext(applicationContextfile);
		}
		return appContext;
	}

}
