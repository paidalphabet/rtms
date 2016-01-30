package com.rtms.framework.bo.factory;


import org.apache.velocity.app.VelocityEngine;

import com.rtms.analytics.RequestLoggingHandler;
import com.rtms.bo.BaseService;
import com.rtms.bo.UserService;
import com.rtms.framework.exception.TrackedExceptionLogger;

public class BOFactory extends ApplicationContextFactory {

	private static final String BASE_BO_BEAN = "baseBoProxy";
	private static final String USER_BO_BEAN = "userBoProxy";
	private static final String VELOCITY_ENGINE = "velocityEngine";
	private static final String TRACKED_EXCEPTION_LOGGER = "trackedExceptionLogger";
	private final static String REQUEST_LOGGING_HANDLER ="requestlogginghandler";

	private static BaseService baseBO;
	private static UserService userBO;
	private static TrackedExceptionLogger trackedExceptionLogger;
	private static RequestLoggingHandler requestLoggingHandler;
	private static VelocityEngine velocityEngine;
	

	public static BaseService getBaseBO() {

		if (baseBO != null) {
			return baseBO;
		} else {
			baseBO = (BaseService) getAppcontext().getBean(BASE_BO_BEAN);
		}
		return baseBO;
	}

	public static UserService getUserBO() {

		if (userBO != null) {
			return userBO;
		} else {
			userBO = (UserService) getAppcontext().getBean(USER_BO_BEAN);
		}
		return userBO;
	}

	public static VelocityEngine getVelocityEngine() {
		if (velocityEngine == null) {
			velocityEngine = (VelocityEngine) getAppcontext().getBean(VELOCITY_ENGINE);
		}
		return velocityEngine;
	}

	public static TrackedExceptionLogger getTrackedExceptionLogger() {
		if (trackedExceptionLogger == null) {
			trackedExceptionLogger = (TrackedExceptionLogger) getAppcontext().getBean(TRACKED_EXCEPTION_LOGGER);
		}
		return trackedExceptionLogger;
	}
	public static RequestLoggingHandler getRequestLoggingHandler(){
		if (requestLoggingHandler == null) {
			requestLoggingHandler = (RequestLoggingHandler) getAppcontext().getBean(REQUEST_LOGGING_HANDLER);
		}
		return requestLoggingHandler;
		
	}
}