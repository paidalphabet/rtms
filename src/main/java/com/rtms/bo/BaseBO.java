package com.rtms.bo;

import java.util.List;

import com.rtms.dao.BaseDAO;
import com.rtms.entity.LabelTxt;
import com.rtms.framework.bo.factory.ApplicationContextFactory;
import com.rtms.framework.exception.TrackedException;
import com.rtms.service.email.EmailNotificationService;

public class BaseBO {
	
	private BaseDAO baseDao;

	public BaseDAO getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDAO baseDao) {
		this.baseDao = baseDao;
	}
	
	public EmailNotificationService getEmailNotificationService(){
		return (EmailNotificationService) ApplicationContextFactory.getAppcontext().getBean("emailNotificationService");
	}
	
	public List<LabelTxt> initializeApplicationLocale(final String locale) {
		return baseDao.initializeApplicationLocale(locale);
	}

	public void saveTrackedException(final TrackedException trackedException) {
		getBaseDao().save(trackedException);
		
	}
}
