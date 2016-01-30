package com.rtms.framework.bo.factory;

import org.springframework.context.ApplicationContext;

import com.rtms.framework.spring.AppContextUtil;

public class ApplicationContextFactory {

	private static ApplicationContext appContext = null;

	private static Object mutex = new Object();

	public static ApplicationContext getAppcontext() {
		if (null == appContext) {
			synchronized (mutex) {
				appContext = AppContextUtil.getAppcontext();
			}
		}
		return appContext;
	}

}
