package com.rtms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rtms.analytics.RequestLoggingHandler;
import com.rtms.bo.UserBO;
import com.rtms.framework.bo.factory.BOFactory;
import com.rtms.framework.constants.HttpSessionAttributeFactory;
import com.rtms.framework.constants.Redirection;
import com.rtms.framework.constants.SessionConstants;
import com.rtms.framework.exception.RTMSException;
import com.rtms.framework.spring.AppContextUtil;
import com.rtms.model.system.BaseBusinessObject;

@Controller
public class AngularRequestController extends BaseController<BaseBusinessObject>{
	
	private final static Logger LOGGER = LoggerFactory.getLogger(AngularRequestController.class);

	private final static String THREAD_POOL_EXECUTOR = "taskExecutor";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model, final HttpServletRequest request)  throws RTMSException {
		String nextPage = Redirection.VIEW_INDEX_UI;
		if(null != HttpSessionAttributeFactory.getAttribute(SessionConstants.USER_ID, request)){
			String userID = (String) HttpSessionAttributeFactory.getAttribute(SessionConstants.USER_ID, request);
			LOGGER.debug("Logged in USER ID :-" +userID);
			nextPage = Redirection.VIEW_HOME;
		}else{
			nextPage = Redirection.VIEW_INDEX_UI;
		}
		return new ModelAndView(nextPage);
	}
	
	@RequestMapping(value = "/homeContent", method = RequestMethod.GET)
	public ModelAndView index(ModelMap model, final HttpServletRequest request)  throws RTMSException {
		return new ModelAndView(Redirection.VIEW_HOME_CONTAINER);
	}
	
	@RequestMapping(value = "/pages/views/{common}/{trailing}", method = RequestMethod.GET)
	public ModelAndView pages(@PathVariable final String common , @PathVariable final String trailing ,final ModelMap model, final HttpServletRequest request)  throws RTMSException {
		final String view = "views/" + common + "/" + trailing;
		return new ModelAndView(view);
	}
	
	@RequestMapping(value="/logRequest",method=RequestMethod.POST)
	public void logRequest(final HttpServletRequest request , final HttpServletResponse response){
		final ThreadPoolTaskExecutor threadPoolTaskExector = (ThreadPoolTaskExecutor) AppContextUtil.getAppcontext().getBean(THREAD_POOL_EXECUTOR);
		UserBO userbo = BOFactory.getUserBO();
		final RequestLoggingHandler requestHandler = BOFactory.getRequestLoggingHandler();
		requestHandler.setUserBO(userbo);
		requestHandler.setHttpServletRequest(request);
		requestHandler.setLoggingType(RequestLoggingHandler.LOG_JAVASCRIPT_MESSAGE);
		threadPoolTaskExector.execute(requestHandler);
		
	}

}
