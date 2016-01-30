package com.rtms.service.email;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EmailNotificationService {

	public void sendEmail(Map<String, String> emailExtendedProperties, String templateID) throws IOException;

	public String getFrom();

	public void setFrom(String from);

	public List<String> getToList();

	public void setToList(List<String> toList);

	public List<String> getCcList();

	public void setCcList(List<String> ccList);

	public List<String> getBccList();

	public void setBccList(List<String> bccList);

	public String getMessage();

	public void setMessage(String message);

	public String getSubject();

	public void setSubject(String subject);
}
