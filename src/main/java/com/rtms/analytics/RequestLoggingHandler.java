package com.rtms.analytics;

import javax.servlet.http.HttpServletRequest;

import com.rtms.bo.UserBO;

/**
 * @author sandesh
 *
 */
public class RequestLoggingHandler extends Thread{
	
	public static final String LOG_JAVASCRIPT_MESSAGE = "JAVASCRIPT_LOG_MESSAGES";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1256008176450700424L;
	private HttpServletRequest httpServletRequest;
	private UserBO userBO;
	/**
	 * is it a type of javascript logging
	 */
	private String loggingType;
	/**
	 * @return the loggingType
	 */
	public String getLoggingType() {
		return loggingType;
	}

	/**
	 * @param loggingType the loggingType to set
	 */
	public void setLoggingType(String loggingType) {
		this.loggingType = loggingType;
	}

	/**
	 * @return the httpServletRequest
	 */
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}

	/**
	 * @param httpServletRequest the httpServletRequest to set
	 */
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	
	/**
	 * @return the userBO
	 */
	public UserBO getUserBO() {
		return userBO;
	}

	/**
	 * @param userBO the userBO to set
	 */
	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	public void run(){
		this.getUserBO().logRequest(this.getHttpServletRequest(),this.getLoggingType());
	}

}
