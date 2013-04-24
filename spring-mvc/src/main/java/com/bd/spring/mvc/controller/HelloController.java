package com.bd.spring.mvc.controller;

import java.net.URL;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bd.spring.mvc.domain.User_ProfileEntry;
import com.bd.spring.mvc.service.UserProfileRestServiceClient;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/welcome")
public class HelloController {

	private static Logger logger = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	UserProfileRestServiceClient userProfileRestServiceClient;

	@RequestMapping(method = RequestMethod.GET)
	public String welcome() {
		logger.debug("entering inside welcome...");
		return "index";
	}

	@RequestMapping(value = "/printWelcome", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		logger.debug("entering inside printWelcome...");
		model.addAttribute("message", "SOA Integration Welcome Page");
		return "hello2";
	}

	@RequestMapping(value = "/showUserProfileForm", method = RequestMethod.GET)
	public ModelAndView showUserProfileForm(ModelMap model) {
		logger.debug("entering inside addUserProfileForm...");

		User_ProfileEntry userProfileEntry = new User_ProfileEntry();

		// Note that in the ModelAndView object we have passed a blank userProfileEntry object with name “command”.
		// The spring framework expects an object with name command if we are using <form:form> in our JSP file.
		ModelAndView modelAndView = new ModelAndView("addUserProfile", "command", userProfileEntry);

		return modelAndView;
	}

	@RequestMapping(value = "/addUserProfile", method = RequestMethod.POST)
	public ModelAndView addUserProfile(@ModelAttribute("userProfileEntry") User_ProfileEntry userProfileEntry, BindingResult result) {
		logger.debug("entering inside addUserProfile...");

		ObjectMapper mapper = new ObjectMapper();

		String payload;
		try {
			payload = mapper.writeValueAsString(userProfileEntry);

			logger.debug("request payload: " + payload);

			userProfileRestServiceClient.createUserProfileJson(payload);
			
		} catch (Exception e) {
			logger.error("Exception received: ", e);
		}

		return getUserProfiles();
	}

	@RequestMapping(value = "/userprofiles", method = RequestMethod.GET)
	public ModelAndView getUserProfiles() {

		logger.debug("entering inside getUserProfiles...");

		ModelAndView modelAndView = new ModelAndView("hello");

		//mock response from rest-service
//		List<User_ProfileEntry> userProfileList = userProfileRestServiceClient.getAllUserProfiles();
		
		//actual response from mule esb through xml to json transformation
		List<User_ProfileEntry> userProfileList = userProfileRestServiceClient.getAllUserProfilesXmlToJsonTransformed();

		modelAndView.addObject("userProfileList", userProfileList);

		return modelAndView;

	}

	@RequestMapping(value = "/showForm", method = RequestMethod.GET)
	public ModelAndView showForm(@RequestParam(value = "var", required = false) String var) throws Exception {
		ModelAndView modelAndView = new ModelAndView("feed");
		try {
			modelAndView.addObject("feeds", "feedDomainList -a alist object");
		} catch (Exception e) {
			logger.error("Exception received: ", e);
			throw e;
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addUserProfileSoap", method = RequestMethod.POST)
	public ModelAndView addUserProfileSoap(@ModelAttribute(value = "userProfileEntry") User_ProfileEntry userProfileEntry, BindingResult result) {
		logger.debug("entering inside addUserProfile...");

		// userProfileRestServiceClient.

		URL wsdlURL;
		// try {
		// wsdlURL = new URL("http://localhost:8080/soap-service/UserProfileService?wsdl");
		// UserProfileService userProfileService = new UserProfileService(wsdlURL);
		// UserProfileServicePort port = userProfileService.getUserProfileServicePort();

		// } catch (MalformedURLException e) {
		// logger.error("MalformedURLException received:", e);
		// }

		// UserProfileResponse userProfile = port.

		return getUserProfiles();
	}

}