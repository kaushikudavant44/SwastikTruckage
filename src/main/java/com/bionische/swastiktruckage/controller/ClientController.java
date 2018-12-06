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
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.ClientFullDetailsRepository;
import com.bionische.swastiktruckage.repository.LrBillingRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionBillDetailsRepository;
import com.bionische.swastiktruckage.repository.TransactionBillHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionBillLogsRepository;
import com.bionische.swastiktruckage.repository.TransactionLrInvoiceDetailRepository;
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
	ClientDetailsRepository clientDetailsRepository;
	
	@Autowired
	LrBillingRepository lrBillingRepository;
	
	@Autowired
	TransactionBillHeaderRepository transactionBillHeaderRepository;
	
	@Autowired
	TransactionBillDetailsRepository transactionBillDetailsRepository;
	
	@Autowired
	TransactionBillLogsRepository transactionBillLogsRepository;
	
	@Autowired
	TransactionLrInvoiceDetailRepository transactionLrInvoiceDetailRepository;
	
	@Autowired
	ClientFullDetailsRepository clientFullDetailsRepository;
	
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
		
		try {
		Info info = clientDetailsService.insertClientDetails(clientDetails);
		
		if(info.isError())
		{
			message = "Failed";
		}
		else
		{
			message = "Successfull";
		}
		} catch (Exception e) {
			e.printStackTrace();
			url = "redirect:/errorMessage";

		}
		return url;

	}
		
	@RequestMapping(value="/showAllClientDetails", method=RequestMethod.GET)

	public ModelAndView showAllClientDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/testing");
		List<ClientFullDetails> allClientDetails = clientDetailsService.getAllClientDetailsByStatus(1);
		
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
		
		try {
		List<States> stateList = stateDetailsService.getAllStates();
		List<City> cityList= cityRepository.findByStateId(clientDetails.getStateId());
	
		model.addObject("stateList",stateList);
		model.addObject("cityList",cityList);
		model.addObject("clientDetails",clientDetails);
		} catch (Exception e) {
			e.printStackTrace();
			model = new ModelAndView("common/errorMsg");

		}
		return model;
		
	}	
	
	@RequestMapping(value="/deleteClientById", method=RequestMethod.GET)

	public @ResponseBody Info deleteClientById(HttpServletRequest request)   
	{
		
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
	@RequestMapping(value="/showLrBillPage", method=RequestMethod.GET)

	public ModelAndView showLrBillPage(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/showBillPage");
		
		return model;
		
	}
	
	
	@RequestMapping(value="/saveClientBillDetails", method=RequestMethod.POST)

	public ModelAndView saveClientBillDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/showBillPage");
		
        int clientId = Integer.parseInt(request.getParameter("clientId"));
		
        //get client details
        ClientFullDetails clientFullDetails = clientFullDetailsRepository.getClientDetailById(clientId);
        
		List<LrBilling> clientBillDetails = lrBillingRepository.getBillDetailByClientId(clientId);
		
		float totalBill=0;
		int totalQty=0;
		for(LrBilling clientBill : clientBillDetails)
		{
			totalBill+=clientBill.getTotal();	
			totalQty+=clientBill.getQuantity();
			clientBill.setInvoiceDetailList(transactionLrInvoiceDetailRepository.findByInvHeaderId(clientBill.getInvHeaderId()));
		}
		
		//save bill header
		
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
		
		TransactionBillHeader billHeader = transactionBillHeaderRepository.save(transactionBillHeader);
	
		// save bill details
		
		if(billHeader!=null)
		{
		for(LrBilling  bill: clientBillDetails)
		{
			TransactionBillDetails transactionBillDetails = new TransactionBillDetails();
		    
			transactionBillDetails.setBillHeaderId(billHeader.getBillHeaderId());
			transactionBillDetails.setLrHeaderId(bill.getLrHeaderId());
			transactionBillDetailsRepository.save(transactionBillDetails);
			
		}
		}
		
		//save staff logs
		 HttpSession session = request.getSession();
		 OfficeStaff officeStaffDetails = (OfficeStaff)session.getAttribute("staffDetails");
		 
		TransactionBillLogs transactionBillLogs = new TransactionBillLogs();
		
		transactionBillLogs.setBillHeaderId(billHeader.getBillHeaderId());
		transactionBillLogs.setModifiedById(officeStaffDetails.getStaffId());
		transactionBillLogs.setModifiedByOffice(officeStaffDetails.getStaffOfficeId());
		
		transactionBillLogsRepository.save(transactionBillLogs);
		
		model.addObject("clientFullDetails",clientFullDetails);
		model.addObject("clientBillDetails",clientBillDetails);
		model.addObject("trBillHeader",billHeader);
		model.addObject("totalBill",totalBill);
		model.addObject("totalQty",totalQty);
		
		
		return model;
		
	}
	
	@RequestMapping(value="/clientNameValidation", method=RequestMethod.GET)

	public @ResponseBody int clientNameValidation(HttpServletRequest request)   
	{
		int i=0;
		
		String clientName = request.getParameter("clientName"); 	
				
		ClientDetails clientDetails = new ClientDetails();
		
		try {
			
			clientDetails=clientDetailsRepository.findByClientName(clientName);	
			 
			 if(clientDetails==null)
			 {
				i=1;
			 }
			 

			} catch (Exception e) {
			e.printStackTrace();
			}
			return i;
		
	}	
	
}
