
package com.rtms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rtms.bo.UserService;
import com.rtms.framework.constants.Redirection;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * Logger
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * user dao 
	 */
	@Autowired
	private UserService userService;

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(final HttpServletRequest request, final HttpServletResponse response){
		LOGGER.info("Login returning jsp");
		return new ModelAndView(Redirection.VIEW_LOGIN); 
	}

}