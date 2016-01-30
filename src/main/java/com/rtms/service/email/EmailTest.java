package com.rtms.service.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.rtms.framework.exception.RTMSException;

public class EmailTest {

	/**
	 * @param args
	 * @throws MessagingException 
	 * @throws AddressException 
	 */
	public static void main(String[] args) throws RTMSException, AddressException, MessagingException{
		// TODO Auto-generated method stub
		final Properties properties = new Properties();
		final String mailSmtpHost = "smtp.mailgun.org";
		final String username = "postmaster@sandboxda354e1472db423cb5c3d6b1fac0ce72.mailgun.org";
		final String password = "CYB@sanket22";
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", mailSmtpHost);
		properties.put("mail.smtp.port", "587");
		final Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		final Message emailMessage = new MimeMessage(session);
		emailMessage.setFrom(new InternetAddress("freealphabet@gmail.com"));
		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("freealphabet@gmail.com"));
				
		emailMessage.setSubject("Test mail");

		Multipart mp = new MimeMultipart();
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent("<h1><marquee>SANDESH</marquee></h1><marquee>This text will scroll from right to left</marquee>", "text/html");
        mp.addBodyPart(htmlPart);
        emailMessage.setContent(mp);
        session.setDebug(true);
        
		session.setDebug(true);

		Transport.send(emailMessage);
	}

}
