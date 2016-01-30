package com.rtms.bo;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rtms.dao.UserDAO;
import com.rtms.entity.User;
import com.rtms.entity.analytics.HttpRequestLog;
import com.rtms.framework.constants.HttpSessionAttributeFactory;
import com.rtms.framework.constants.SessionConstants;
import com.rtms.framework.session.user.UserSessionObject;
import com.rtms.service.email.EmailNotificationService;
import com.rtms.transformer.CommonSystemTransformer;

public class UserBO extends BaseBO {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserBO.class);
	public UserDAO userdao;
	public EmailNotificationService emailNotificationService;

	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(final UserDAO userdao) {
		this.userdao = userdao;
	}

	public EmailNotificationService getEmailNotificationService() {
		return emailNotificationService;
	}

	public void setEmailNotificationService(EmailNotificationService emailNotificationService) {
		this.emailNotificationService = emailNotificationService;
	}

	private static void buildUserSession(final User user, final HttpServletRequest request) {
		final UserSessionObject userSessionObject = new UserSessionObject();
		if (null != user  && null != request) {
			userSessionObject.setDisplayName(user.getEmailID());
			userSessionObject.setEmailID(user.getEmailID());
			userSessionObject.setUserID(user.getId());

			HttpSessionAttributeFactory.setAttribute(SessionConstants.USER_SESSION_OBJECT, userSessionObject, request);
			HttpSessionAttributeFactory.setAttribute(SessionConstants.LOGIN_NAME, userSessionObject.getEmailID(), request);
			HttpSessionAttributeFactory.setAttribute(SessionConstants.USER_ID, userSessionObject.getUserID(), request);
		}
	}

	private static void destroyUserSession(final HttpServletRequest request) {
		if (null != request) {
			HttpSessionAttributeFactory.removeAttribute(SessionConstants.USER_ID, request);
			HttpSessionAttributeFactory.removeAttribute(SessionConstants.USER_SESSION_OBJECT, request);
			LOGGER.debug("Session destroy completed");
		}
	}

		/**
		 * Logs the HTTP Servlet Request to the database using a thread.
		 * @param httpServletRequest the HttpServletRequest to be logged.
		 */
		public void logRequest(final HttpServletRequest request,final String requestLogType) {
			final HttpRequestLog requestLog = CommonSystemTransformer.convertToHttpRequestLog(request,requestLogType);
			userdao.save(requestLog);		
		}

}
