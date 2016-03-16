	package com.rtms.bo;

import javax.servlet.http.HttpServletRequest;

import com.rtms.dao.UserDAO;
import com.rtms.entity.User;
import com.rtms.service.email.EmailNotificationService;

public interface UserService extends BaseService {

	public UserDAO getUserdao();

	public void setUserdao(final UserDAO userdao);

	public EmailNotificationService getEmailNotificationService();

	public void setEmailNotificationService(EmailNotificationService emailNotificationService);

	public void buildUserSession(final User user, final HttpServletRequest request);

	public void destroyUserSession(final HttpServletRequest request);

	/**
	 * Logs the HTTP Servlet Request to the database using a thread.
	 * 
	 * @param httpServletRequest the HttpServletRequest to be logged.
	 */
	public void logRequest(final HttpServletRequest request, final String requestLogType);

}
