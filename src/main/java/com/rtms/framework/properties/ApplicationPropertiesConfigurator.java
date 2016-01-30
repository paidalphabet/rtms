package com.rtms.framework.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

public class ApplicationPropertiesConfigurator {

	private static Properties properties = null;

	private static final Object mutex = new Object();

	private final static String PROPERTIES_FILE = "/application.properties";

	private static void load(final String locale) {
		try {
			properties = new Properties();
			InputStream inputStream = ApplicationPropertiesConfigurator.class.getResourceAsStream(PROPERTIES_FILE);
			properties.load(inputStream);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static String getProperty(final String propertyName) {
		if (properties == null) {
			synchronized (mutex) {
				load(Locale.US.toString());
			}
		}
		return properties.getProperty(propertyName.trim());
	}

	public static void setProperty(final String propertyName, final String propertyValue) {
		if (properties == null) {
			synchronized (mutex) {
				load(Locale.US.toString());
			}
		}
		properties.setProperty(propertyName.trim(), propertyValue.trim());
	}

}
