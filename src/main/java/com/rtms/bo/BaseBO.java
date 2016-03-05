package com.rtms.bo;

import java.util.List;

import com.rtms.dao.BaseDAO;
import com.rtms.framework.bo.factory.ApplicationContextFactory;
import com.rtms.framework.exception.TrackedException;
import com.rtms.entity.Label;
import com.rtms.service.email.EmailNotificationService;

public class BaseBO {

	private BaseDAO baseDao;

	public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}

	public EmailNotificationService getEmailNotificationService() {
		return (EmailNotificationService) ApplicationContextFactory.getAppcontext().getBean("emailNotificationService");
	}

	public void saveTrackedException(final TrackedException trackedException) {
		getBaseDao().save(trackedException);
	}

	public List<Label> initializeApplicationLocale(final String locale) {
		return getBaseDao().initializeApplicationLocale(locale);
	}
}
