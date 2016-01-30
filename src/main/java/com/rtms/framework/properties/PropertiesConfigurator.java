package com.rtms.framework.properties;

import java.util.List;
import java.util.Locale;
import java.util.Properties;

import com.rtms.bo.BaseService;
import com.rtms.entity.Label;
import com.rtms.framework.bo.factory.BOFactory;
import com.rtms.framework.exception.RTMSException;

public class PropertiesConfigurator {

	private static Properties properties = null;

	private static final Object mutex = new Object();
	
	private static String locale = Locale.US.toString();

	public static void load(final String locale) throws RTMSException {
		if (properties == null) {
			synchronized (mutex) {
				refreshLabelCache(locale);
			}
		}
	}

	public static String getProperty(final String propertyName) throws RTMSException {
		load(locale);
		String value = properties.getProperty(propertyName.trim());
		if(null == value){
			return propertyName;
		}else{
			return properties.getProperty(propertyName.trim());
		}
	}

	public static void setProperty(final String propertyName, final String propertyValue) throws RTMSException {
		load(locale);
		properties.setProperty(propertyName.trim(), propertyValue.trim());
	}

	public static void refreshLabelCache(String locale) throws RTMSException {
		properties = new Properties();
		BaseService baseBO = BOFactory.getBaseBO();
		final List<Label> labelTxtList = baseBO.initializeApplicationLocale(locale);
		for(Label l : labelTxtList){
			properties.setProperty(l.getLabelCode(), l.getLabelValue());
		}
	}
}
