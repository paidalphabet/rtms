package com.rtms.framework.bo.factory;


import org.apache.velocity.app.VelocityEngine;

import com.rtms.analytics.RequestLoggingHandler;
import com.rtms.bo.BaseBO;
import com.rtms.bo.UserBO;
import com.rtms.bo.calculator.CalculatorBO;
import com.rtms.bo.subscription.SubscriptionBO;
import com.rtms.framework.exception.TrackedExceptionLogger;

public class BOFactory extends ApplicationContextFactory {

	private static final String BASE_BO_BEAN = "baseBoProxy";
	private static final String USER_BO_BEAN = "userBoProxy";
	private static final String VELOCITY_ENGINE = "velocityEngine";
	private static final String CALCULATOR_BO_BEAN = "calculatorBoProxy";
	private static final String TRACKED_EXCEPTION_LOGGER = "trackedExceptionLogger";
	private final static String REQUEST_LOGGING_HANDLER ="requestlogginghandler";
	private final static String SUBSCRIPTION_BO_BEAN = "subscriptionBOProxy"; 
	

	private static BaseBO baseBO;
	private static UserBO userBO;
	private static TrackedExceptionLogger trackedExceptionLogger;
	private static RequestLoggingHandler requestLoggingHandler;
	

	public static BaseBO getBaseBO() {

		if (baseBO != null) {
			return baseBO;
		} else {
			baseBO = (BaseBO) getAppcontext().getBean(BASE_BO_BEAN);
		}
		return baseBO;
	}

	public static UserBO getUserBO() {

		if (userBO != null) {
			return userBO;
		} else {
			userBO = (UserBO) getAppcontext().getBean(USER_BO_BEAN);
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