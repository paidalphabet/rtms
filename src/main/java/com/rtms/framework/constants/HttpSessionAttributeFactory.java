package com.rtms.framework.constants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class HttpSessionAttributeFactory {
	
	public static void setAttribute(final String key , final Object value , HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute(key, value);
	}

	public static Object getAttribute(final String key , HttpServletRequest request){
		HttpSession session = request.getSession();
		Object sessionValue = session.getAttribute(key);
		return sessionValue;
	}
	
	public static Object removeAttribute(final String key , HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute(key);
		return null;
	}
}
