package com.bionische.swastiktruckage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MasterController {
	
	@RequestMapping(value="/showHome", method=RequestMethod.GET)

	public ModelAndView showPatientLoginPage(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("test/index");
		try {
	
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return model;
		
	}	

}
