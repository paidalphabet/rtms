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
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		LOGGER.info("Post-handle..........");
	}

	@Override
	@SuppressWarnings("unused")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
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

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		LOGGER.info("After completion handle.........");
	}

}
