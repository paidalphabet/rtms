package com.rtms.transformer;

import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.rtms.entity.analytics.HttpRequestLog;

final public class CommonSystemTransformer {

	public static HttpRequestLog convertToHttpRequestLog(final HttpServletRequest request, final String requestLogType){
		final HttpRequestLog requestLog = new HttpRequestLog();
		requestLog.setAuthType(request.getAuthType());
		requestLog.setContextPath(request.getContextPath());
		requestLog.setHeaders(getRequestHeaders(request));
		requestLog.setRequestMethod(request.getMethod());
		requestLog.setRemoteHost(request.getRemoteHost());
		requestLog.setRemoteUser(request.getRemoteUser());
		requestLog.setRequestedSessionID(request.getRequestedSessionId());
		requestLog.setRequestURI(request.getRequestURI());
		requestLog.setSessionDetails(getSessionDetails(request));
		requestLog.setParameters(getParameters(request));
		requestLog.setCreationDate(new Date());
		requestLog.setModificationDate(new Date());
		requestLog.setRequestLogType(requestLogType);
		return requestLog;
	}

	private static String getRequestHeaders(final HttpServletRequest request) {
		final JSONObject headersJson = new JSONObject();
		final Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			final String headerName = headerNames.nextElement();
			if(request.getHeader(headerName)!=null){
				headersJson.put(headerName, request.getHeader(headerName));
			}
		}
		return headersJson.toString();
	}

	private static String getSessionDetails(final HttpServletRequest request) {
		final JSONObject sessionJSON = new JSONObject();
		final HttpSession session = request.getSession();
		if (session != null) {
			final Enumeration<String> attributeNames = session.getAttributeNames();
			while (attributeNames.hasMoreElements()) {
				final String headerName = attributeNames.nextElement();
				if (session.getAttribute(headerName) != null) {
					sessionJSON.put(headerName, session.getAttribute(headerName).toString());
				}
			}
			sessionJSON.put("sessionID", session.getId());
		}
		return sessionJSON.toString();
	}

	private static String getParameters(final HttpServletRequest request) {
		final Enumeration<String> parameterNames = request.getParameterNames();
		final JSONObject parametersJSON = new JSONObject();
		if (parameterNames != null) {
			while (parameterNames.hasMoreElements()) {
				final String key = parameterNames.nextElement();
				final Object val = request.getParameter(key);
				// String value = val.toString();
				String value = "";
				if (val instanceof String) {
					value = (String) val;
				}
				parametersJSON.put(key, value);
			}
		}
		return parametersJSON.toString();
	}

}