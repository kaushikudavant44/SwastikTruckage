package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.LrGraph;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.StaffRoles;
import com.bionische.swastiktruckage.model.NavBarMainMenu;
import com.bionische.swastiktruckage.model.NavBarSubMainMenu;
import com.bionische.swastiktruckage.repository.LrGraphRepository;
import com.bionische.swastiktruckage.repository.NavBarMainMenuRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.StaffRolesRepository;
import com.bionische.swastiktruckage.repository.TransactionBillHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@SessionScope
public class LoginController {
	
	@Autowired
	LrGraphRepository lrGraphRepository;
	
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	
	@Autowired
	TransactionLrHeaderRepository transactionLrHeaderRepository;
	
	@Autowired
	TransactionBillHeaderRepository transactionBillHeaderRepository;
	@Autowired
	StaffRolesRepository staffRolesRepository;
	@Autowired
	NavBarMainMenuRepository navBarMainMenuRepository;
	
	
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
		String url ="redirect:/";
		 HttpSession session = request.getSession();
		 
		String contactNo = request.getParameter("contactNo"); 
		String password = request.getParameter("password"); 
		
		try
		{
		OfficeStaff officeStaffDetails = officeStaffRepository.findByStaffContactNoAndPassword(contactNo, password);
		
		if(officeStaffDetails!=null)
		{
			System.out.println("Success");
			StaffRoles staffRolesRes=staffRolesRepository.findByStaffId(officeStaffDetails.getStaffId());
			 ObjectMapper mapper = new ObjectMapper();
			
			 List<NavBarSubMainMenu> navBarSubMainMenuList = mapper.readValue(staffRolesRes.getRole(), List.class);
			 System.out.println("navBarSubMainMenuList "+navBarSubMainMenuList.toString());
			List<NavBarMainMenu> navBarMainMenuList=navBarMainMenuRepository.findAll();
			
			session.setAttribute("navBarMainMenuList", navBarMainMenuList);
			session.setAttribute("navBarSubMainMenuList", navBarSubMainMenuList);
			
			
			 
			message="";
			session.setAttribute("staffDetails", officeStaffDetails);
			url="redirect:/showHome";
		}
		else
		{
			message="Invalid Credential";
			url="redirect:/";
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
			List<LrGraph> lrGraphList=new ArrayList<>();
			
			lrGraphList=lrGraphRepository.getLrCountAndLrDate(officeId);
			System.out.println(lrGraphList.toString());
			
			
			model.addObject("lrGraphList", lrGraphList);
			model.addObject("lrCount", lrCount);
			model.addObject("pendingBillCount", pendingBillCount);
			model.addObject("pendingLrCount", pendingLrCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)

	public ModelAndView logout(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("login/login");		

		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		session.invalidate();
		
		return model;
		
	}	

}
