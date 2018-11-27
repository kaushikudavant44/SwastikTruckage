package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.User;


@Controller
@RequestMapping(value = "/templates")
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	@RequestMapping(value = "/dataTable", method = RequestMethod.GET)
	public ModelAndView getLogin(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("templates/datatable");

		return model;

	}

	@RequestMapping(value = "/icons", method = RequestMethod.GET)
	public ModelAndView icons(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("templates/icons");

		return model;

	}

	@RequestMapping(value = "/getGrid", method = RequestMethod.GET)
	public ModelAndView getGrid(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("templates/grid");

		return model;

	}

	@RequestMapping(value = "/datepicker", method = RequestMethod.GET)
	public ModelAndView datepicker(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("templates/datepicker");

		return model;

	}

	
	@RequestMapping(value = "/imagePicker", method = RequestMethod.GET)
	public ModelAndView imagePicker(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("templates/imagepicker");
		model.addObject("url", "home/ats/");

		return model;

	}
	
	@RequestMapping(value = "/advancedForm", method = RequestMethod.GET)
	public ModelAndView advanceForm(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("templates/advancedform");
		model.addObject("url", "home/ats/");

		return model;

	}
	
	  @RequestMapping("/addNewUser")  
	    public ModelAndView showform(){  

		  
		  ModelAndView view =new ModelAndView("/templates/addNewUser");
		  List<String>list=new ArrayList<>();
		  list.add("123");
		  list.add("456");
		  list.add("789");
		  
		  
		  
		  view.addObject("user", new User());
		  view.addObject("list", list);
		  
	        return view;  
	    }  
	
	 

	  @RequestMapping(value = "/saveNewUser", method = RequestMethod.POST)
      public String addStudent(@ModelAttribute("user")User user, BindingResult result, Model model) {
		  
		  logger.error("User details "+user.toString());
		  
		  return "redirect:/templates/addNewUser";
	  }
	
}
