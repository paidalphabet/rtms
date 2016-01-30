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

public interface UserService extends BaseService {

	public UserDAO getUserdao();

	public void setUserdao(final UserDAO userdao);

	public EmailNotificationService getEmailNotificationService();

	public void setEmailNotificationService(EmailNotificationService emailNotificationService);

	private static void buildUserSession(final User user, final HttpServletRequest request);

	private static void destroyUserSession(final HttpServletRequest request);

	/**
	 * Logs the HTTP Servlet Request to the database using a thread.
	 * 
	 * @param httpServletRequest the HttpServletRequest to be logged.
	 */
	public void logRequest(final HttpServletRequest request, final String requestLogType);

}
