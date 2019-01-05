package com.bionische.swastiktruckage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.City;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.repository.CityRepository;
import com.bionische.swastiktruckage.repository.StatesRepository;

@Controller
@SessionScope
public class HomeController {
	
	public static List<States> stateList;
	
	public static List<City> cityList;
	@Autowired
	StatesRepository statesRepository;
	
	@Autowired
	CityRepository cityRepository;

	/*@RequestMapping(value="/getStates", method=RequestMethod.GET)

	public String showPatientLoginPage(HttpServletRequest request)   
	{
		
		
		
		return model;
		
	}	*/
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String  welcomePage() {
		
		try {
	
			stateList = statesRepository.findAll();
			System.out.println("stateList"+stateList.toString());
		}
		catch (Exception e) {
			e.getMessage();
		}
		return "redirect:/showHome";
	}*/
	
	@RequestMapping(value = "/errorMessage", method = RequestMethod.GET)
	public ModelAndView errorMessage(HttpServletRequest request) {
		
		ModelAndView model=new ModelAndView("common/errorMsg");
		
		return model;
	}
	
	@RequestMapping(value="/getCityByStateId", method=RequestMethod.GET)

	public @ResponseBody List getCityByStateId(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView model=new ModelAndView("master/officeRegistration");
		
		int stateId=Integer.parseInt(request.getParameter("stateId"));
		
		
		MultiValueMap<String, Object> map=new LinkedMultiValueMap<String, Object>();
		map.add("stateId",stateId);
	  
		cityList=cityRepository.findByStateId(stateId);
		System.out.println(cityList);
		
		return cityList;
		
	}	
	
    public static String convertToYMD(String date) {
		
		String convertedDate=null;
		try {
			SimpleDateFormat ymdSDF = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dmySDF = new SimpleDateFormat("MM/dd/yyyy");
			Date dmyDate = dmySDF.parse(date);
			
			convertedDate=ymdSDF.format(dmyDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return convertedDate;

	}
	
	
}
