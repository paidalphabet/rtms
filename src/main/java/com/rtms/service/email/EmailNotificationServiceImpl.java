package com.rtms.service.email;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.velocity.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.rtms.framework.constants.ApplicationConstants;
import com.rtms.framework.exception.WiseGoalsExeption;

public class EmailNotificationServiceImpl extends AbstractVelocityInitializer	implements EmailNotificationService, Runnable {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmailNotificationServiceImpl.class);
	private String from;
	private List<String> toList = new ArrayList<String>();
	private List<String> ccList = new ArrayList<String>();
	private List<String> bccList = new ArrayList<String>();
	private String message;
	private String subject;
	private int templateID;

	public int getTemplateID() {
		return templateID;
	}

	public void setTemplateID(int templateID) {
		this.templateID = templateID;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getToList() {
		return toList;
	}

	public void setToList(List<String> toList) {
		this.toList = toList;
	}

	public List<String> getCcList() {
		return ccList;
	}

	public void setCcList(List<String> ccList) {
		this.ccList = ccList;
	}

	public List<String> getBccList() {
		return bccList;
	}

	public void setBccList(List<String> bccList) {
		this.bccList = bccList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void run() {
		try {
			final Properties properties = new Properties();
			final String username = ApplicationConstants.EMAIL_ACC_USERNAME;
			final String password = ApplicationConstants.EMAIL_ACC_PASSWORD;
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.smtp.host", ApplicationConstants.EMAIL_ACC_SMTP_HOST);
			properties.put("mail.smtp.port", "587");
			final Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			final Message emailMessage = new MimeMessage(session);
			emailMessage.setFrom(new InternetAddress(from));
			if (toList != null && toList.size() > 0) {
				for (final String toRecipient : toList) {
					emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toRecipient));
				}
			}
			if (ccList != null && ccList.size() > 0) {
				for (final String toCC : ccList) {
					emailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(toCC));
				}
			}
			if (bccList != null && bccList.size() > 0) {
				for (final String toBCC : bccList) {
					emailMessage.addRecipient(Message.RecipientType.BCC, new InternetAddress(toBCC));
				}
			}
			emailMessage.setFrom(new InternetAddress(from));

			emailMessage.setSubject(subject);

			Multipart mp = new MimeMultipart();
			MimeBodyPart htmlPart = new MimeBodyPart();
			htmlPart.setContent(message, "text/html");
			mp.addBodyPart(htmlPart);
			emailMessage.setContent(mp);
			session.setDebug(true);

			Transport.send(emailMessage);
		} catch (final MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void sendEmail(final Map<String, String> emailExtendedProperties, final String templateID) throws IOException {
		LOGGER.debug("Inside sendEmail thread");
		super.init();

		Template template = null;
		try {
			template = super.getTemplate(templateID);
		} catch (WiseGoalsExeption e) {
			e.printStackTrace();
		}
		if (template != null) {
			StringWriter writer = new StringWriter();
			super.populateVelocityContext(emailExtendedProperties, velocityContext);
			template.merge(velocityContext, writer);
			this.setMessage(writer.toString());

			LOGGER.debug("Email Content - " + this.getMessage());
			final Thread emailThread = new Thread(this);
			LOGGER.debug("Inside sendEmail thread " + emailThread.getName());
			emailThread.start();
		}
	}

}
