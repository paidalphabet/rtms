package com.rtms.framework.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.rtms.analytics.RequestLoggingHandler;
import com.rtms.bo.UserBO;
import com.rtms.framework.bo.factory.BOFactory;
import com.rtms.framework.constants.ApplicationConstants;
import com.rtms.framework.spring.AppContextUtil;

public class MVCInterceptor implements HandlerInterceptor {

	private final static Logger LOGGER = LoggerFactory.getLogger(MVCInterceptor.class);
	
	private final static String THREAD_POOL_EXECUTOR = "taskExecutor";
	
	/**
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(final HttpServletRequest request,final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception {
		LOGGER.info("Post-handle..........");
	}

	/**
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	@SuppressWarnings("unused")
	public boolean preHandle(final HttpServletRequest request,final HttpServletResponse response,final Object handler)
			throws Exception {
		LOGGER.info("Pre-handle...........");
		final HttpSession session = request.getSession(true);
		if (ApplicationConstants.LOG_REQUESTS) {
			final ThreadPoolTaskExecutor threadPoolTaskExector = (ThreadPoolTaskExecutor) AppContextUtil.getAppcontext().getBean(THREAD_POOL_EXECUTOR);
			UserBO userbo = BOFactory.getUserBO();
			final RequestLoggingHandler requestHandler = BOFactory.getRequestLoggingHandler();
			requestHandler.setUserBO(userbo);
			requestHandler.setHttpServletRequest(request);
			threadPoolTaskExector.execute(requestHandler);
		}
		return true;
	}

	/**
	 * (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(final HttpServletRequest request,final HttpServletResponse response,final Object handler,final Exception ex)
			throws Exception {
		LOGGER.info("After completion handle.........");
	}
}
