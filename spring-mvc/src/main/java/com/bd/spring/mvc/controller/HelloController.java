package com.bd.spring.mvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bd.spring.mvc.domain.User_ProfileEntry;
import com.bd.spring.mvc.service.UserProfileRestServiceClient;

@Controller
@RequestMapping("/welcome")
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	UserProfileRestServiceClient userProfileRestServiceClient;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		logger.debug("entering inside printWelcome...");

		model.addAttribute("message", "Spring 3 MVC Hello World");
		
		return "hello";

	}

	@RequestMapping(value = "/userprofiles", method = RequestMethod.GET)
	public String getUserProfiles(ModelMap model) {

		logger.debug("entering inside getUserProfiles...");
		
		
		List<User_ProfileEntry> userProfileList = userProfileRestServiceClient.getAllUserProfiles();

		model.addAttribute("message", "Spring 3 MVC Hello World");
		
		//TODO
		//develop a jsp page and set the userProfileList...
		return "hello";

	}

}