package com.rtms.util.email;

import java.util.HashMap;
import java.util.Map;

import com.rtms.entity.Login;
import com.rtms.entity.User;

public class TemplateUtil {

	public static Map<String, String> getTemplateAttributeForUserRegistration(final Login login, final User user,final String domainURL) {

		final Map<String, String> templateAttributes = new HashMap<String, String>();
		templateAttributes.put("name", getDisplayName(login, user));
		templateAttributes.put("domainURL", domainURL);
		templateAttributes.put("username", login.getEmailId());
		return templateAttributes;

	}

	public static String getDisplayName(final Login login,final User user) {
		String displayName = "";
		if (user.getDisplayName() == null && login != null) {
			displayName = login.getEmailId();
		}
		return displayName;
	}

}
