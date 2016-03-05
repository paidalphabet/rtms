package com.rtms.servlet.javascript;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseURLGenerator extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9199686582484834813L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/javascript");
		final String appURL = "var appURL = 'http://" + request.getServerName() + "/'";
		response.setContentType("text/javascript; charset=UTF-8");
		response.getWriter().write(appURL + ";\n");
	}

}