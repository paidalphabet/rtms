package com.rtms.framework.properties;

import java.util.List;
import java.util.Locale;
import java.util.Properties;

import com.rtms.bo.BaseBO;
import com.rtms.entity.LabelTxt;
import com.rtms.framework.bo.factory.BOFactory;
import com.rtms.framework.exception.WiseGoalsExeption;

public class PropertiesConfigurator {

	private static Properties properties = null;

	private static final Object mutex = new Object();
	
	private static String locale = Locale.US.toString();

	public static void load(final String locale) throws WiseGoalsExeption {
		if (properties == null) {
			synchronized (mutex) {
				refreshLabelCache(locale);
			}
		}
	}

	public static String getProperty(final String propertyName) throws WiseGoalsExeption {
		load(locale);
		String value = properties.getProperty(propertyName.trim());
		if(null == value){
			return propertyName;
		}else{
			return properties.getProperty(propertyName.trim());
		}
	}

	public static void setProperty(final String propertyName, final String propertyValue) throws WiseGoalsExeption {
		load(locale);
		properties.setProperty(propertyName.trim(), propertyValue.trim());
	}

	public static void refreshLabelCache(String locale) throws WiseGoalsExeption {
		properties = new Properties();
		BaseBO baseBO = BOFactory.getBaseBO();
		final List<LabelTxt> labelTxtList = baseBO.initializeApplicationLocale(locale);
		for(LabelTxt l : labelTxtList){
			properties.setProperty(l.getLabelCode(), l.getLabelValue());
		}
	}
}
