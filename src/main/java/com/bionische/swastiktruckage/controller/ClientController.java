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
import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.mastermodel.TransactionBillDetails;
import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionBillLogs;
import com.bionische.swastiktruckage.repository.CityRepository;
import com.bionische.swastiktruckage.repository.LrBillingRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionBillDetailsRepository;
import com.bionische.swastiktruckage.repository.TransactionBillHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionBillLogsRepository;
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
	LrBillingRepository lrBillingRepository;
	
	@Autowired
	TransactionBillHeaderRepository transactionBillHeaderRepository;
	
	@Autowired
	TransactionBillDetailsRepository transactionBillDetailsRepository;
	
	@Autowired
	TransactionBillLogsRepository transactionBillLogsRepository;
	
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
		clientDetails.setGstin(request.getParameter("gst"));
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
		ModelAndView model=new ModelAndView("client/testing");
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
	
	
	//billing
	
	@RequestMapping(value="/showLrBilling", method=RequestMethod.GET)

	public ModelAndView showLrBilling(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/lrBilling");
		List<ClientFullDetails> allClientDetails = clientDetailsService.getAllClientDetailsByStatus(1);
		
		model.addObject("allClientDetails",allClientDetails);
	
		return model;
		
	}
	
	
	@RequestMapping(value="/saveClientBillDetails", method=RequestMethod.POST)

	public ModelAndView saveClientBillDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/lrBilling");
		
        int clientId = Integer.parseInt(request.getParameter("clientId"));
		
		List<LrBilling> clientBillDetails = lrBillingRepository.getBillDetailByClientId(clientId);
		System.out.println("clientBillDetailsList:"+clientBillDetails.toString());
		
		float totalBill=0;
		for(LrBilling clientBill : clientBillDetails)
		{
			totalBill+=clientBill.getTotal();					
		}
		
		
		TransactionBillHeader transactionBillHeader = new TransactionBillHeader();
		List<TransactionBillHeader> billHeaderList = transactionBillHeaderRepository.findAll();
		
		if(billHeaderList==null)
		{
			transactionBillHeader.setBillNo(00000001);
		}
		else
		{
			int billNo = transactionBillHeader.getBillNo()+1;
			transactionBillHeader.setBillNo(billNo);
		}
		transactionBillHeader.setBillTo(Integer.parseInt(request.getParameter("clientId")));
		transactionBillHeader.setBillPayableBy(Integer.parseInt(request.getParameter("clientId")));
		transactionBillHeader.setBillDate(request.getParameter("billDate"));
		transactionBillHeader.setBillTotal(totalBill);
		transactionBillHeader.setGstPayableBy((Integer.parseInt(request.getParameter("gstBy"))));
		transactionBillHeader.setBillStatus(0);
		transactionBillHeader.isUsed();
		
		TransactionBillHeader res = transactionBillHeaderRepository.save(transactionBillHeader);
		System.out.println("TransactionBillHeader:"+res.toString());
		
		if(res!=null)
		{
		for(LrBilling  bill: clientBillDetails)
		{
			TransactionBillDetails transactionBillDetails = new TransactionBillDetails();
		    
			transactionBillDetails.setBillHeaderId(res.getBillHeaderId());
			transactionBillDetails.setLrHeaderId(bill.getLrHeaderId());
			transactionBillDetailsRepository.save(transactionBillDetails);
			
		}
		}
		 HttpSession session = request.getSession();
		 OfficeStaff officeStaffDetails = (OfficeStaff)session.getAttribute("staffDetails");
		 
		TransactionBillLogs transactionBillLogs = new TransactionBillLogs();
		
		transactionBillLogs.setBillHeaderId(res.getBillHeaderId());
		transactionBillLogs.setModifiedById(officeStaffDetails.getStaffId());
		transactionBillLogs.setModifiedByOffice(officeStaffDetails.getStaffOfficeId());
		
		transactionBillLogsRepository.save(transactionBillLogs);
		
		return model;
		
	}
	
}
