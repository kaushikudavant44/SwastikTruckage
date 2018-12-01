package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.CompanyDetails;
import com.bionische.swastiktruckage.mastermodel.OfficeDetails;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.TransactionLrContaintDetails;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.CompanyDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;

@Controller
public class TransactionController {
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	
	@Autowired
	OfficeDetailsRepository officeDetailsRepository;
	
	@Autowired
	ClientDetailsRepository clientDetailsRepository;
	
	List<TransactionLrContaintDetails> transactionLrContaintDetailsList=new ArrayList<>();
	
	@RequestMapping(value = "/sample", method = RequestMethod.GET)

	public ModelAndView showPatientLoginPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("master/offices");
		
		try {

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	
	@RequestMapping(value = "/showLR", method = RequestMethod.GET)

	public ModelAndView showLR(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		
		try {
			
			CompanyDetails companyDetails=new CompanyDetails();
			
			OfficeStaff staffDetails=new OfficeStaff();
			
			//get staff id through session
			//TODO
			int staffId=8;
			List<OfficeDetails> officeList=officeDetailsRepository.findByIsUsed(true);
			List<ClientDetails> clientList=clientDetailsRepository.findAll();
			
			
			
			companyDetails=companyDetailsRepository.findByCompanyId(1);
			staffDetails=officeStaffRepository.findByStaffId(staffId);
			
			model.addObject("clientList", clientList);
			model.addObject("officeList", officeList);
			model.addObject("companyDetails", companyDetails);
			model.addObject("staffDetails", staffDetails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	
	@RequestMapping(value = "/addContaint", method = RequestMethod.GET)

	public @ResponseBody List<TransactionLrContaintDetails> addContaint(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		TransactionLrContaintDetails transactionLrContaintDetails=new TransactionLrContaintDetails();
		transactionLrContaintDetails.setLrHeaderId(0);
		transactionLrContaintDetails.setDetailId(0);
		transactionLrContaintDetails.setNoOfContaints(Float.parseFloat(request.getParameter("noOfContaint")));
		transactionLrContaintDetails.setGoods(request.getParameter("goods"));
		transactionLrContaintDetails.setDescription(request.getParameter("description"));
		
		System.out.println("cdcs"+transactionLrContaintDetails.toString());
		try {
			
			transactionLrContaintDetailsList.add(transactionLrContaintDetails);
			System.out.println(transactionLrContaintDetailsList.toString());
			     
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
		return transactionLrContaintDetailsList;

	}

}
