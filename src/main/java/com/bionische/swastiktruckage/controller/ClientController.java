package com.bionische.swastiktruckage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.City;
import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.repository.CityRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.service.ClientDetailsService;
import com.bionische.swastiktruckage.service.StateDetailsService;

@Controller
public class ClientController {
	
	@Autowired
	ClientDetailsService clientDetailsService;
	
	@Autowired
	StateDetailsService stateDetailsService;
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	public String message;


	@RequestMapping(value="/showClientReg", method=RequestMethod.GET)
	public ModelAndView showClientReg(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/clientReg");
		List<States> stateList = stateDetailsService.getAllStates();
			
		model.addObject("message",message);
		model.addObject("stateList",stateList);
		message="";
		return model;
		
	}	
	@RequestMapping(value = "/insertClientInfo", method = RequestMethod.POST)
	public String insertClientInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String url ="redirect:/showClientReg";
		
		ClientDetails clientDetails = new ClientDetails();
		
		String clientId = request.getParameter("clientId");
	    if(clientId!=null)	
	    {
	    	clientDetails.setClientId(Integer.parseInt(clientId));
	    	url ="redirect:/showAllClientDetails";
	    }
		
		clientDetails.setCityId(Integer.parseInt(request.getParameter("cityId")));
		clientDetails.setClientAddress(request.getParameter("address"));
		clientDetails.setClientContactNo(request.getParameter("contactNo"));
		clientDetails.setClientName(request.getParameter("name"));
		clientDetails.setGstin(Float.parseFloat(request.getParameter("gst")));
		clientDetails.setPincode(Integer.parseInt(request.getParameter("pincode")));
		clientDetails.setStateId(Integer.parseInt(request.getParameter("stateId")));
		clientDetails.setUsed(true);
		
		Info info = clientDetailsService.insertClientDetails(clientDetails);
		
		if(info.isError())
		{
			message = "Failed";
		}
		else
		{
			message = "Successfull";
		}

		return url;

	}
		
	@RequestMapping(value="/showAllClientDetails", method=RequestMethod.GET)

	public ModelAndView showAllClientDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/showAllClients");
		List<ClientFullDetails> allClientDetails = clientDetailsService.getAllClientDetailsByStatus(1);
		
		System.out.println("message:"+message);
		model.addObject("message",message);
		model.addObject("allClientDetails",allClientDetails);
		message="";
		return model;
		
	}	
	
	@RequestMapping(value="/showEditClientDetails/{clientId}", method=RequestMethod.GET)

	public ModelAndView showEditClientDetails(@PathVariable("clientId") int clientId,HttpServletRequest request)   
	{
		ClientDetails clientDetails = clientDetailsService.getClientDetailsById(clientId);
		
		ModelAndView model=new ModelAndView("client/editClientDetails");
		List<States> stateList = stateDetailsService.getAllStates();
		List<City> cityList= cityRepository.findByStateId(clientDetails.getStateId());
	
		model.addObject("stateList",stateList);
		model.addObject("cityList",cityList);
		model.addObject("clientDetails",clientDetails);
		return model;
		
	}	
	
	@RequestMapping(value="/deleteClientById", method=RequestMethod.GET)

	public @ResponseBody Info deleteClientById(HttpServletRequest request)   
	{
		
		
		System.out.println("lkjhgf");
		int clientId = Integer.parseInt(request.getParameter("clientId")); 	
				
		Info info = clientDetailsService.deleteClientById(clientId);
		
		return info;
		
	}	
	
	@RequestMapping(value="/showStaffLogin", method=RequestMethod.GET)

	public ModelAndView showStaffLogin(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("master/staffLoginPage");		

		model.addObject("message",message);
		message="";
		return model;
		
	}	
	
	@RequestMapping(value="/staffLoginProcess", method=RequestMethod.POST)

	public String staffLoginProcess(HttpServletRequest request)   
	{
		String url ="redirect:/showStaffLogin";
		 HttpSession session = request.getSession();
		 
		String contactNo = request.getParameter("contactNo"); 
		String password = request.getParameter("password"); 
		
		try
		{
		OfficeStaff officeStaffDetails = officeStaffRepository.findByStaffContactNoAndPassword(contactNo, password);
		
		if(officeStaffDetails!=null)
		{
			message="";
			session.setAttribute("staffDetails", officeStaffDetails);
			url="redirect:/showHome";
		}
		else
		{
			message="Invalid Credential";
			url="redirect:/showStaffLogin";
		}
		
		
		}
		catch (Exception e) {
			e.getMessage();
		}
		
		return url;
		
	}	
	
	
}
