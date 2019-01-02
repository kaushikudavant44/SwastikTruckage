package com.bionische.swastiktruckage.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

/*import com.bionische.swastiktruckage.master.controller.ExcelWriter;
*/import com.bionische.swastiktruckage.master.controller.SMSSender;
import com.bionische.swastiktruckage.mastermodel.City;
import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.CompanyDetails;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.mastermodel.TransactionBillDetails;
import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionBillLogs;
import com.bionische.swastiktruckage.mastermodel.TransactionBillPayments;
import com.bionische.swastiktruckage.mastermodel.TransactionLrCollection;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.model.GetPaymentDetails;
import com.bionische.swastiktruckage.repository.CityRepository;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.ClientFullDetailsRepository;
import com.bionische.swastiktruckage.repository.CompanyDetailsRepository;
import com.bionische.swastiktruckage.repository.GetPaymentDetailsRepository;
import com.bionische.swastiktruckage.repository.LrBillingRepository;
import com.bionische.swastiktruckage.repository.TransactionBillDetailsRepository;
import com.bionische.swastiktruckage.repository.TransactionBillHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionBillLogsRepository;
import com.bionische.swastiktruckage.repository.TransactionBillPaymentsRepository;
import com.bionische.swastiktruckage.repository.TransactionLrCollectionRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
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
	TransactionLrHeaderRepository transactionLrHeaderRepository;
	
	@Autowired
	ClientFullDetailsRepository clientFullDetailsRepository;
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;
	
	@Autowired
	TransactionLrCollectionRepository transactionLrCollectionRepository;
	
	@Autowired
	TransactionBillPaymentsRepository transactionBillPaymentsRepository;

	@Autowired
	GetPaymentDetailsRepository getPaymentDetailsRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	
	public String message;
	
	List<TransactionLrHeader> addedLrList = new ArrayList<TransactionLrHeader>();


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
		clientDetails.setBillingName(request.getParameter("billName"));
		clientDetails.setClientContactNo(request.getParameter("contactNo"));
		clientDetails.setClientName(request.getParameter("name"));
		clientDetails.setGstin(request.getParameter("gst"));
		try {
		clientDetails.setPincode(Integer.parseInt(request.getParameter("pincode")));
		}catch(Exception e) {
			e.printStackTrace();
		}
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
		ModelAndView model=new ModelAndView("client/showAllClients");
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
	
	@RequestMapping(value="/showUnPaidClients", method=RequestMethod.GET)

	public ModelAndView showUnPaidClients(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/unPaidClients");
		List<ClientDetails> allClientDetails = clientDetailsRepository.findAll();
		
		model.addObject("allClientDetails",allClientDetails);
	
		return model;
		
	}
	@RequestMapping(value="/showLrBilling/{clientId}", method=RequestMethod.GET)

	public ModelAndView showLrBilling(@PathVariable("clientId") int clientId,HttpServletRequest request)   
	{
		System.out.println("clientId:"+clientId);
		
		ModelAndView model=new ModelAndView("client/lrBilling");
		addedLrList.clear();
		try {
			ClientDetails clientDetails = clientDetailsRepository.findByClientId(clientId);
			/*
			 * List<TransactionLrHeader> transactionLrHeader =
			 * transactionLrHeaderRepository.getLrByClientId(clientId);
			 */
		
			model.addObject("clientDetails",clientDetails);
			/* model.addObject("transactionLrHeader",transactionLrHeader); */
		} catch (Exception e) {
			e.printStackTrace();
			model = new ModelAndView("common/errorMsg");

		}
		return model;
		
	}	
	@RequestMapping(value="/lrDetailsByLrNo", method=RequestMethod.GET)

	public @ResponseBody TransactionLrHeader lrDetailsByLrNo(HttpServletRequest request)   
	{
		int lrNO = Integer.parseInt(request.getParameter("lrNo"));
		System.out.println("lrNO:"+lrNO);
		
		TransactionLrHeader transactionLrHeader = transactionLrHeaderRepository.findByLrNoAndBillStatus(lrNO,0);
		System.out.println("Tra LR "+transactionLrHeader.toString());
		
		
		if(transactionLrHeader!=null)
		{
			addedLrList.add(transactionLrHeader); 
		}
		return transactionLrHeader;
		
	}	
	
	@RequestMapping(value="/saveClientBillDetails", method=RequestMethod.GET)

	public ModelAndView saveClientBillDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/billingPage");
		/*
		 * int[] lrHeaderId;
		 * 
		 * String senderHeaderID[] = request.getParameterValues("0"); String
		 * recHeaderID[] = request.getParameterValues("1");
		 * 
		 * 
		 * if(senderHeaderID!=null) { lrHeaderId =
		 * Arrays.stream(senderHeaderID).mapToInt(Integer::parseInt).toArray(); } else {
		 * lrHeaderId =
		 * Arrays.stream(recHeaderID).mapToInt(Integer::parseInt).toArray(); }
		 */
        List<LrBilling> clientBillDetails = new ArrayList<LrBilling>();
            
     for(TransactionLrHeader lrList : addedLrList)
      {
    	 LrBilling lrBilling = new LrBilling();
    	
    	 lrBilling = lrBillingRepository.getBillDetailByLrId(lrList.getLrHeaderId());
    	 clientBillDetails.add(lrBilling);
      }
     
     ClientFullDetails clientFullDetails = new ClientFullDetails();

     if(clientBillDetails.get(0).getPaymentBy()==0)
     {
      clientFullDetails = clientFullDetailsRepository.getClientDetailById(clientBillDetails.get(0).getConsigneeId());
     }
     else
     {
      clientFullDetails = clientFullDetailsRepository.getClientDetailById(clientBillDetails.get(0).getConsignor());
     } 
     
		float totalBill=0;
		int totalQty=0;
		float totalFreight=0;
		float totalHamali=0;
		for(LrBilling clientBill : clientBillDetails)
		{
			totalBill+=clientBill.getTotal();	
			totalQty+=clientBill.getQuantity();
			totalFreight+=clientBill.getFreight();
			totalHamali+=clientBill.getHamali();
					
			clientBill.setInvoiceDetailList(transactionLrInvoiceDetailRepository.findByInvHeaderId(clientBill.getInvHeaderId()));
		}		
		//save bill header
		
		TransactionBillHeader transactionBillHeader = new TransactionBillHeader();
		TransactionBillHeader billHeaderList = transactionBillHeaderRepository.getLastEntry();
		
		if(billHeaderList!=null)
		{
			int billNo = billHeaderList.getBillNo()+1;
			transactionBillHeader.setBillNo(billNo);
		
		}
		else
		{
			transactionBillHeader.setBillNo(00000001);
		}
		
		if(clientBillDetails.get(0).getPaymentBy()==0)
		{
			transactionBillHeader.setBillTo(clientBillDetails.get(0).getConsigneeId());
		}
		else
		{
			transactionBillHeader.setBillTo(clientBillDetails.get(0).getConsignor());
		}	
		transactionBillHeader.setBillPayableBy(clientBillDetails.get(0).getPaymentBy());
		transactionBillHeader.setBillDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		transactionBillHeader.setBillTotal(totalBill);		
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
		
		for(LrBilling clientBill : clientBillDetails)
		{
			transactionLrHeaderRepository.updatePaymentStatus(clientBill.getLrHeaderId());
		}
		
		addedLrList=null;
		//company details
		CompanyDetails	companyDetails = companyDetailsRepository.findByCompanyId(1);
		
		model.addObject("clientFullDetails",clientFullDetails);	
		model.addObject("trBillHeader",billHeader);
		model.addObject("totalBill",totalBill);
		model.addObject("totalQty",totalQty);
		model.addObject("totalFreight",totalFreight);
		model.addObject("totalHamali",totalHamali);
		model.addObject("clientBillDetails",clientBillDetails);	
		
		model.addObject("companyDetails",companyDetails);
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
	
	@RequestMapping(value="/showAllUnPaidLr", method=RequestMethod.GET)

	public ModelAndView showAllUnPaidLr(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/unpaidLrHeader");
		List<LrBilling> lrHeaderList = new ArrayList<LrBilling>();
		try
		{
			lrHeaderList = lrBillingRepository.getAllUnPaidLr();
			System.out.println("lrHeaderList:"+lrHeaderList.toString());
			model.addObject("message",message);
			message="";
			model.addObject("lrHeaderList",lrHeaderList);
		}		
		
		catch (Exception e) {
			e.printStackTrace();
			model = new ModelAndView("common/errorMsg");

		}
		return model;
		
	}
	
	@RequestMapping(value="/showCollectionInfo/{total}/{lrNo}/{headerId}", method=RequestMethod.GET)

	public ModelAndView showCollectionInfo(@PathVariable("total") float total,@PathVariable("lrNo") int lrNo,@PathVariable("headerId") int headerId,HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/collectionInfo");
		model.addObject("total",total);
		model.addObject("lrNo",lrNo);
		model.addObject("headerId",headerId);
		
		return model;
		
	}
	
	@RequestMapping(value="/insertLrCollection", method=RequestMethod.POST)

	public String insertLrCollection(HttpServletRequest request)   
	{
		String url ="redirect:/showAllUnPaidLr";
		
		HttpSession session = request.getSession();
		OfficeStaff officeStaffDetails = (OfficeStaff)session.getAttribute("staffDetails");
		
		TransactionLrCollection transactionLrCollection = new TransactionLrCollection();
		try
		{
			transactionLrCollection.setLrHeaderId(Integer.parseInt(request.getParameter("headerId")));
			transactionLrCollection.setLrNo(Integer.parseInt(request.getParameter("lrNo")));
			transactionLrCollection.setOfficeId(officeStaffDetails.getStaffOfficeId());
			transactionLrCollection.setPaymentMode(Integer.parseInt(request.getParameter("paymentType")));
			transactionLrCollection.setStaffId(officeStaffDetails.getStaffId());
			transactionLrCollection.setTotal(Float.parseFloat(request.getParameter("total")));
			
			transactionLrCollection.setUsed(true);
			int type=Integer.parseInt(request.getParameter("paymentType"));
			if(type==0)
			{
				transactionLrCollection.setTrId(0);	
			}
			else
			{
				transactionLrCollection.setTrId(Integer.parseInt(request.getParameter("trId")));

			}
						
			TransactionLrCollection	res = transactionLrCollectionRepository.save(transactionLrCollection);
			
			
			if(res!=null)
			{
				transactionLrHeaderRepository.updatePaymentStatus(Integer.parseInt(request.getParameter("headerId")));
				message="Saved Successfully";
			}
			else
			{
				message="Failed";
			}
		}		
		
		catch (Exception e) {
			e.printStackTrace();
			message="Failed";

		}
		return url;
		
	}
	
	@RequestMapping(value="/showGeneratedClientBills", method=RequestMethod.GET)

	public ModelAndView showGeneratedClientBills(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/clientBillList");
		
		try {
			List<GetPaymentDetails> clientBills;
			String fromDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			
			if(fromDate!=null && toDate!=null)
			{
			 clientBills = getPaymentDetailsRepository.paymentDetailsByDate(0,fromDate,toDate);
			 model.addObject("from",fromDate);
			 model.addObject("to",toDate);
			}
			else
			{
			 clientBills = getPaymentDetailsRepository.paymentDetailsByDate(0,new SimpleDateFormat("yyyy-MM-dd").format(new Date()),new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("from",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("to",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
			
			/*
			 * float paid=0; for(TransactionBillPayments installementList : installement) {
			 * paid = installementList.getAmountReceived(); }
			 */
			
			model.addObject("clientBills",clientBills);
		}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			
		model.addObject("message",message);
		message="";
		return model;
		
	}
	
	@RequestMapping(value="/getBillDetailsOfClient/{billHeaderId}", method=RequestMethod.GET)

	public ModelAndView getBillDetailsOfClient(@PathVariable("billHeaderId") int billHeaderId,HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/billingPage");
		List<LrBilling> clientBillDetails = new ArrayList<LrBilling>();
		
        TransactionBillHeader transactionBillHeader = transactionBillHeaderRepository.findByBillHeaderId(billHeaderId);
               
        List<TransactionBillDetails> billDetails= transactionBillDetailsRepository.findByBillHeaderId(billHeaderId);
                   
       for(TransactionBillDetails details : billDetails)
      {
    	 LrBilling lrBilling = new LrBilling();
    	
    	 lrBilling = lrBillingRepository.getBillDetailByLrId(details.getLrHeaderId());
    	
    	 clientBillDetails.add(lrBilling);
      }
     
     ClientFullDetails clientFullDetails = new ClientFullDetails();

     if(clientBillDetails.get(0).getPaymentBy()==0)
     {
      clientFullDetails = clientFullDetailsRepository.getClientDetailById(clientBillDetails.get(0).getConsigneeId());
     }
     else
     {
      clientFullDetails = clientFullDetailsRepository.getClientDetailById(clientBillDetails.get(0).getConsignor());
     } 
     
		float totalBill=0;
		int totalQty=0;
		float totalFreight=0;
		float totalHamali=0;
		for(LrBilling clientBill : clientBillDetails)
		{
			totalBill+=clientBill.getTotal();	
			totalQty+=clientBill.getQuantity();
			totalFreight+=clientBill.getFreight();
			totalHamali+=clientBill.getHamali();
			clientBill.setInvoiceDetailList(transactionLrInvoiceDetailRepository.findByInvHeaderId(clientBill.getInvHeaderId()));
			
		}
		
		
		//company details
		CompanyDetails	companyDetails = companyDetailsRepository.findByCompanyId(1);
		
		model.addObject("clientFullDetails",clientFullDetails);	
		model.addObject("trBillHeader",transactionBillHeader);
		model.addObject("totalBill",totalBill);
		model.addObject("totalQty",totalQty);
		model.addObject("totalFreight",totalFreight);
		model.addObject("totalHamali",totalHamali);
		model.addObject("clientBillDetails",clientBillDetails);	
		
		model.addObject("companyDetails",companyDetails);
		return model;
		
	}
	
	@RequestMapping(value="/showGeneratedCollectionBills", method=RequestMethod.GET)

	public ModelAndView showGeneratedCollectionBills(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/collectionBillList");
		
		try {
			List<TransactionLrCollection> collectionBills;
			String fromDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			
			if(fromDate!=null && toDate!=null)
			{
				collectionBills = transactionLrCollectionRepository.collectionBillByDate(fromDate,toDate);
			 model.addObject("from",fromDate);
			 model.addObject("to",toDate);
			}
			else
			{
				collectionBills = transactionLrCollectionRepository.collectionBillByDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("from",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("to",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
			model.addObject("collectionBills",collectionBills);
		}
			catch (Exception e) {
				e.printStackTrace();
				
			}
			
		return model;
		
	}
	
	@RequestMapping(value="/getBillDetailsOfCollection/{lrHeaderId}/{collectionId}", method=RequestMethod.GET)

	public ModelAndView getBillDetailsOfCollection(@PathVariable("lrHeaderId") int lrHeaderId,@PathVariable("collectionId") int collectionId,HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/collectionBillDetails");
		    	
		TransactionLrCollection transactionLrCollection = transactionLrCollectionRepository.findByCollectionId(collectionId);
		LrBilling collectionBillDetails = lrBillingRepository.getBillDetailByLrId(lrHeaderId);
    	
    	   
     ClientFullDetails clientFullDetails = new ClientFullDetails();

     if(collectionBillDetails.getPaymentBy()==0)
     {
      clientFullDetails = clientFullDetailsRepository.getClientDetailById(collectionBillDetails.getConsigneeId());
     }
     else
     {
      clientFullDetails = clientFullDetailsRepository.getClientDetailById(collectionBillDetails.getConsignor());
     } 
     
		
		model.addObject("clientFullDetails",clientFullDetails);	
		model.addObject("transactionLrCollection",transactionLrCollection);	
		model.addObject("collectionBillDetails",collectionBillDetails);
		return model;
		
	}
	
	@RequestMapping(value="/showPaymentPage/{total}/{billHeaderId}", method=RequestMethod.GET)

	public ModelAndView showCollectionInfo(@PathVariable("total") float total,@PathVariable("billHeaderId") int billHeaderId,HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/paymentPage");
		
		try
		{
			List<LrBilling> clientBillDetails = new ArrayList<LrBilling>();
			
	        TransactionBillHeader transactionBillHeader = transactionBillHeaderRepository.findByBillHeaderId(billHeaderId);
	               
	        List<TransactionBillDetails> billDetails= transactionBillDetailsRepository.findByBillHeaderId(billHeaderId);
	                   
	       for(TransactionBillDetails details : billDetails)
	      {
	    	 LrBilling lrBilling = new LrBilling();
	    	
	    	 lrBilling = lrBillingRepository.getBillDetailByLrId(details.getLrHeaderId());
	    	
	    	 clientBillDetails.add(lrBilling);
	      }
	     
	     ClientFullDetails clientFullDetails = new ClientFullDetails();

	     if(clientBillDetails.get(0).getPaymentBy()==0)
	     {
	      clientFullDetails = clientFullDetailsRepository.getClientDetailById(clientBillDetails.get(0).getConsigneeId());
	     }
	     else
	     {
	      clientFullDetails = clientFullDetailsRepository.getClientDetailById(clientBillDetails.get(0).getConsignor());
	     } 
	     
			float totalBill=0;
			int totalQty=0;
			float totalFreight=0;
			float totalHamali=0;
			for(LrBilling clientBill : clientBillDetails)
			{
				totalBill+=clientBill.getTotal();	
				totalQty+=clientBill.getQuantity();
				totalFreight+=clientBill.getFreight();
				totalHamali+=clientBill.getHamali();
				clientBill.setInvoiceDetailList(transactionLrInvoiceDetailRepository.findByInvHeaderId(clientBill.getInvHeaderId()));
				
			}
			List<TransactionBillPayments> installement = transactionBillPaymentsRepository.findByBillHeaderId(billHeaderId);
			
			model.addObject("installement",installement);
			model.addObject("clientFullDetails",clientFullDetails);	
			model.addObject("trBillHeader",transactionBillHeader);
			model.addObject("totalBill",totalBill);
			model.addObject("totalQty",totalQty);
			model.addObject("totalFreight",totalFreight);
			model.addObject("totalHamali",totalHamali);
			model.addObject("clientBillDetails",clientBillDetails);	
			model.addObject("total",total);
			model.addObject("billHeaderId",billHeaderId);
				
		}
		catch (Exception e) {
			e.printStackTrace();
		
		}
	
		
		
		return model;
		
	}
	
	@RequestMapping(value="/submitPayment", method=RequestMethod.POST)

	public String submitPayment(HttpServletRequest request)   
	{
		String url ="redirect:/showGeneratedClientBills";
		
		int trId=0;
		int billHeaderId = Integer.parseInt(request.getParameter("billHeaderId"));
		int paymentMode = Integer.parseInt(request.getParameter("paymentType"));
		float amount = Float.parseFloat(request.getParameter("amount"));
		
		if(paymentMode!=1)
		{
			trId = Integer.parseInt(request.getParameter("trId"));
		}
		
		HttpSession session = request.getSession();
		OfficeStaff officeStaffDetails = (OfficeStaff)session.getAttribute("staffDetails");
		TransactionBillPayments transactionBillPayments = new TransactionBillPayments();
		
		transactionBillPayments.setAmountReceived(amount);
		transactionBillPayments.setBillHeaderId(billHeaderId);
		transactionBillPayments.setPaymentDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		transactionBillPayments.setPaymentMode(paymentMode);
		transactionBillPayments.setStaffId(officeStaffDetails.getStaffId());
		transactionBillPayments.setTrId(trId);
		
		 	
		try {
			
			TransactionBillPayments res = transactionBillPaymentsRepository.save(transactionBillPayments);
			
			if(res!=null)
			{
				message="Payment Successfull";
			}
			else
			{
				message="Failed";
			}
	
			TransactionBillHeader transactionBillHeader = transactionBillHeaderRepository.findByBillHeaderId(billHeaderId);
			List<TransactionBillPayments> installement = transactionBillPaymentsRepository.findByBillHeaderId(billHeaderId);
			float paid=0;
			for(TransactionBillPayments installementList : installement)
			{
				paid = installementList.getAmountReceived();
			}
		if(transactionBillHeader.getBillTotal()==paid) {
			
			transactionBillHeaderRepository.updateBillStatus(1, billHeaderId);		
			
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
			message="Failed";

		}
		
		return url;
		
	}
	
	
	
}
