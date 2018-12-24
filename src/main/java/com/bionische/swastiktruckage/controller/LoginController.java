package com.bionische.swastiktruckage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionBillHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;

@Controller
public class LoginController {
	
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	
	@Autowired
	TransactionLrHeaderRepository transactionLrHeaderRepository;
	
	@Autowired
	TransactionBillHeaderRepository transactionBillHeaderRepository;
	
	
	
private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	public String message;

	
	@RequestMapping(value="/", method=RequestMethod.GET)

	public ModelAndView showStaffLogin(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("login/login");		

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
	
	@RequestMapping(value = "/showHome", method = RequestMethod.GET)

	public ModelAndView showPatientLoginPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/dashboard");
		try {
			
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			int officeId=officeStaff.getStaffOfficeId();
			int lrCount=transactionLrHeaderRepository.getLrCountByOfficeId(officeId);
			int pendingBillCount=transactionBillHeaderRepository.getPendingBillCount();
			int pendingLrCount=transactionLrHeaderRepository.getPendingLrDeliveryCount();
			
		
			model.addObject("lrCount", lrCount);
			model.addObject("pendingBillCount", pendingBillCount);
			model.addObject("pendingLrCount", pendingLrCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	

}
