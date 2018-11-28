package com.bionische.swastiktruckage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {
	
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);

	@RequestMapping(value = "/showClientRegistrationForm", method = RequestMethod.GET)
	public ModelAndView showClientRegistrationForm(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("client/ClientRegistration");
		

		return model;

	}
	

	

}
