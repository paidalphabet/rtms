package com.rtms.framework.servlet;

import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.rtms.framework.constants.ApplicationContextConstants;
import com.rtms.framework.exception.RTMSException;
import com.rtms.framework.properties.PropertiesConfigurator;
import com.rtms.framework.spring.AppContextUtil;

public class AppContextLoader extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init(final ServletConfig config) throws ServletException {
		super.init(config);

		final String springcfgFile = ApplicationContextConstants.APPLICATION_CONTEXT;
		AppContextUtil.applicationContextfile = springcfgFile;
		AppContextUtil.getAppcontext();

		/*
		 * 
		 * Loads all labels with provided Locale type in memory
		 * 
		 */
		try {
			PropertiesConfigurator.load(Locale.US.toString());
		} catch (RTMSException e) {
			e.printStackTrace();
		}

	}
}
