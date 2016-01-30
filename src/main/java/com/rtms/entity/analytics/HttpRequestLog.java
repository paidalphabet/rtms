package com.rtms.entity.analytics;

import com.rtms.model.system.BaseBusinessObject;

public class HttpRequestLog extends BaseBusinessObject{
	
	private String requestLogID;
	private String authType;
	private String contextPath;
	private String headers;
	private String requestMethod;
	private String remoteHost;
	private String remoteUser;
	private String requestedSessionID;
	private String requestURI;
	private String sessionDetails;
	private String parameters;
	private String requestLogType;
	
	/**
	 * @return the requestLogID
	 */
	public String getRequestLogID() {
		return requestLogID;
	}
	/**
	 * @param requestLogID the requestLogID to set
	 */
	public void setRequestLogID(String requestLogID) {
		this.requestLogID = requestLogID;
	}
	/**
	 * @return the authType
	 */
	public String getAuthType() {
		return authType;
	}
	/**
	 * @param authType the authType to set
	 */
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	/**
	 * @return the contextPath
	 */
	public String getContextPath() {
		return contextPath;
	}
	/**
	 * @param contextPath the contextPath to set
	 */
	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}
	/**
	 * @return the headers
	 */
	public String getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(String headers) {
		this.headers = headers;
	}
	/**
	 * @return the requestMethod
	 */
	public String getRequestMethod() {
		return requestMethod;
	}
	/**
	 * @param requestMethod the requestMethod to set
	 */
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	/**
	 * @return the remoteHost
	 */
	public String getRemoteHost() {
		return remoteHost;
	}
	/**
	 * @param remoteHost the remoteHost to set
	 */
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	/**
	 * @return the remoteUser
	 */
	public String getRemoteUser() {
		return remoteUser;
	}
	/**
	 * @param remoteUser the remoteUser to set
	 */
	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}
	/**
	 * @return the requestedSessionID
	 */
	public String getRequestedSessionID() {
		return requestedSessionID;
	}
	/**
	 * @param requestedSessionID the requestedSessionID to set
	 */
	public void setRequestedSessionID(String requestedSessionID) {
		this.requestedSessionID = requestedSessionID;
	}
	/**
	 * @return the requestURI
	 */
	public String getRequestURI() {
		return requestURI;
	}
	/**
	 * @param requestURI the requestURI to set
	 */
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	/**
	 * @return the sessionDetails
	 */
	public String getSessionDetails() {
		return sessionDetails;
	}
	/**
	 * @param sessionDetails the sessionDetails to set
	 */
	public void setSessionDetails(String sessionDetails) {
		this.sessionDetails = sessionDetails;
	}
	/**
	 * @return the paramters
	 */
	public String getParameters() {
		return parameters;
	}
	/**
	 * @param parameters the paramters to set
	 */
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	/**
	 * @return the requestLogType
	 */
	public String getRequestLogType() {
		return requestLogType;
	}
	/**
	 * @param requestLogType the requestLogType to set
	 */
	public void setRequestLogType(String requestLogType) {
		this.requestLogType = requestLogType;
	}
}
