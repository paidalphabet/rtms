package com.rtms.framework.exception;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerInterceptor implements MethodInterceptor {

	private final static Logger LOGGER = LoggerFactory.getLogger(LoggerInterceptor.class);
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		LOGGER.debug("Invoked Method : " + invocation.getMethod().getName() + " in "+invocation.getThis());
		LOGGER.debug("Method arguments : " + Arrays.toString(invocation.getArguments()));
		try {
			Object result = invocation.proceed();
			LOGGER.debug("Exit from method "+invocation.getMethod().getName());
			return result;
		} catch (IllegalArgumentException e) {
			LOGGER.debug("Exception in "+invocation.getMethod().getName());
			throw e;
		}
	}

}
