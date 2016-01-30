package com.rtms.bo;

import java.util.List;

import com.rtms.dao.BaseDAO;
import com.rtms.entity.Label;
import com.rtms.framework.exception.TrackedException;
import com.rtms.service.email.EmailNotificationService;

public interface BaseService {

	public BaseDAO getBaseDao();

	public void setBaseDao(BaseDAO baseDao);

	public EmailNotificationService getEmailNotificationService();

	public void saveTrackedException(final TrackedException trackedException);

	public List<Label> initializeApplicationLocale(final String locale);

	void setEmailNotificationService(EmailNotificationService emailNotificationService);
}
