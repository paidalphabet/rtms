package com.rtms.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rtms.dao.BaseDAO;
import com.rtms.entity.Label;
import com.rtms.framework.bo.factory.ApplicationContextFactory;
import com.rtms.framework.exception.TrackedException;
import com.rtms.service.email.EmailNotificationService;

@Service
public class BaseServiceImpl implements BaseService{

	@Autowired
	private BaseDAO baseDao;
	
	@Autowired
	private EmailNotificationService emailNotificationService;

	/**
	 * @param emailNotificationService the emailNotificationService to set
	 */
	@Override
	public void setEmailNotificationService(EmailNotificationService emailNotificationService) {
		this.emailNotificationService = emailNotificationService;
	}
	
	/**
	 * @return the emailNotificationService
	 */
	public EmailNotificationService getEmailNotificationService() {
		return emailNotificationService;
	}

	public void saveTrackedException(final TrackedException trackedException) {
		getBaseDao().save(trackedException);
	}

	public List<Label> initializeApplicationLocale(final String locale) {
		return getBaseDao().initializeApplicationLocale(locale);
	}
}
