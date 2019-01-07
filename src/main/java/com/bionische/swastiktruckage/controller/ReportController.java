package com.bionische.swastiktruckage.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.master.controller.ExcelWriter;
import com.bionische.swastiktruckage.mastermodel.ClientDetails;
/*import com.bionische.swastiktruckage.master.controller.ExcelWriter;
*/import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrCollection;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.model.GetLrDetailsOfClient;
import com.bionische.swastiktruckage.model.GetPaymentDetails;
import com.bionische.swastiktruckage.model.GetVoucherReport;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.GetLrDetailsOfClientRepository;
import com.bionische.swastiktruckage.repository.GetPaymentDetailsRepository;
import com.bionische.swastiktruckage.repository.GetVoucherReportRepository;
import com.bionische.swastiktruckage.repository.LrBillingRepository;
import com.bionische.swastiktruckage.repository.TransactionBillHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionLrCollectionRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
import com.bionische.swastiktruckage.repository.VehicleDetailsRepository;

@Controller
public class ReportController {
	
	@Autowired
	LrBillingRepository lrBillingRepository;
	
	@Autowired
	TransactionLrHeaderRepository transactionLrHeaderRepository;
	
	@Autowired
	TransactionLrCollectionRepository transactionLrCollectionRepository;
	
	@Autowired
	TransactionBillHeaderRepository transactionBillHeaderRepository;
	
	@Autowired
	GetPaymentDetailsRepository getPaymentDetailsRepository;
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;
	
	@Autowired
	GetLrDetailsOfClientRepository getLrDetailsOfClientRepository;
	
	@Autowired
	ClientDetailsRepository clientDetailsRepository;
	
	@Autowired
	GetVoucherReportRepository getVoucherReportRepository;
	
	
	public List<LrBilling> lrHeaderList;
	public List<TransactionLrHeader> lrList;
	List<GetPaymentDetails> billList;
	List<TransactionLrCollection> collectionList;
	List<GetLrDetailsOfClient> clientLrList;
	List<TransactionBillHeader> clientBillList;
	List<GetVoucherReport> voucherList;
	
	@RequestMapping(value="/showpendingPaymentLrList", method=RequestMethod.GET)
	  
	public ModelAndView showpendingPaymentLrList(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("report/paymentPendingLrList");
		 lrHeaderList = new ArrayList<LrBilling>();
		try
		{
			lrHeaderList = lrBillingRepository.paymentPendingLrList();
			System.out.println("lrHeaderList:"+lrHeaderList.toString());
			
			model.addObject("lrHeaderList",lrHeaderList);
		}		
		
		catch (Exception e) {
			e.printStackTrace();
			model = new ModelAndView("common/errorMsg");

		}
		return model;
		
	}
	
	@RequestMapping(value="/showLrListByDate", method=RequestMethod.GET)

	public ModelAndView showLrListByDate(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("report/lrList");
		
		try
		{
			
			String fromDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			
			if(fromDate!=null && toDate!=null)
			{
				lrList = transactionLrHeaderRepository.lrListByDate(fromDate,toDate);
			 model.addObject("from",fromDate);
			 model.addObject("to",toDate);
			}
			else
			{
				lrList = transactionLrHeaderRepository.lrListByDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("from",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("to",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
			float totalBill = 0;
			for(TransactionLrHeader lr:lrList)
			{
				totalBill+=lr.getTotal();
			}
			
			model.addObject("lrList",lrList);
			model.addObject("totalLr",lrList.size());
			model.addObject("totalBill",totalBill);
		}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		return model;
		
	}


	@RequestMapping(value="/showCollectionList", method=RequestMethod.GET)

	public ModelAndView showCollectionList(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("report/collectionList");
		
		try
		{
			
			String fromDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			
			if(fromDate!=null && toDate!=null)
			{
				collectionList = transactionLrCollectionRepository.collectionBillByDate(fromDate,toDate);
			 model.addObject("from",fromDate);
			 model.addObject("to",toDate);
			}
			else
			{
				collectionList = transactionLrCollectionRepository.collectionBillByDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()),new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("from",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("to",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
			
			float totalBill = 0; 
			for(TransactionLrCollection collection : collectionList)
			{
				totalBill+=collection.getTotal();
			}
			
			model.addObject("collectionList",collectionList);
			model.addObject("totalCollection",collectionList.size());
			model.addObject("totalBill",totalBill);
		}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		return model;
		
	}
	
	@RequestMapping(value="/showPaidBills", method=RequestMethod.GET)

	public ModelAndView showPaidBills(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("report/generatedBill");
		
		try
		{
			
			String fromDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			
			if(fromDate!=null && toDate!=null)
			{
				billList = getPaymentDetailsRepository.paymentDetailsByDate(1,fromDate,toDate);
			 model.addObject("from",fromDate);
			 model.addObject("to",toDate);
			}
			else
			{
				billList = getPaymentDetailsRepository.paymentDetailsByDate(1,new SimpleDateFormat("yyyy-MM-dd").format(new Date()),new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("from",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("to",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
			
			float totalBill = 0; 
			for(GetPaymentDetails bill : billList)
			{
				totalBill+=bill.getBillTotal();
			}
			
			model.addObject("billList",billList);
			model.addObject("totalList",billList.size());
			model.addObject("totalBill",totalBill);
		}
			catch (Exception e) {
				e.printStackTrace();
				
			}
		
		
		return model;
		
	}
	
	
	  @RequestMapping(value="/showExcel/{type}", method=RequestMethod.GET)
	  
	  public String showExcel(@PathVariable("type") int type,HttpServletRequest 
			  request,HttpServletResponse response ) 
	  { 
		  String url = "redirect:/"; 
		 try { 		  
			  
	if(type==1) 
	{
	  
	  ExcelWriter.paymentPendingExcel(lrHeaderList,response);
	  url="redirect:/showpendingPaymentLrList"; 
	  } 
	else if(type==2) {
	  
	  ExcelWriter.lrExcel(lrList,response);
	  url="redirect:/showLrListByDate"; 
	  
	} 
	else if(type==3) {
	  
	  ExcelWriter.totalBillExcel(billList,response); 
	  url="redirect:/showPaidBills"; 
	  }
	else if(type==4) {
	  
	  ExcelWriter.collectionExcel(collectionList,response);
	  url="redirect:/showLrListByDate"; 
	  }else if(type==5) {
		  ExcelWriter.lrExcel(lrList,response);
		  url="redirect:/showDataLrListByDateAndVehicleWise";
	  }
	
	  else if(type==6) {
		  ExcelWriter.clientLrListExcel(clientLrList,response);
		  url="redirect:/showLrListOfClient";
	  }
	  else if(type==7) {
		  ExcelWriter.voucherExcel(voucherList,response);
		  url="redirect:/showVoucher";
	  }
	  
	  } catch (IOException e) 
		 { // TODO Auto-generated catch block
	  e.printStackTrace(); url = "redirect:/errorMessage";
	  }
	  
	  return url;
	  
	  }
	 
	  
	  @RequestMapping(value="/showDataLrListByDateAndVehicleWise", method=RequestMethod.GET)

		public ModelAndView showDataLrListByDateAndVehicleWise(HttpServletRequest request)   
		{
			ModelAndView model=new ModelAndView("report/vehicleWiseReport");
			
			try
			{
				
				List<VehicleDetails> vehicleDetailsList=new ArrayList<>();
				
				vehicleDetailsList=vehicleDetailsRepository.findAll();
				
				 model.addObject("from",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				 model.addObject("to",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				
				model.addObject("vehicleDetailsList", vehicleDetailsList);
			}
				catch (Exception e) {
					e.printStackTrace();
					
				}
			return model;
			
		}
	  
	  
	  @RequestMapping(value="/getDataLrListByDateAndVehicleWise", method=RequestMethod.GET)

		public ModelAndView getDataLrListByDateAndVehicleWise(HttpServletRequest request)   
		{
			ModelAndView model=new ModelAndView("report/vehicleWiseReport");
			
			try
			{
				
				String fromDate = request.getParameter("from");
				String toDate = request.getParameter("to");
				String vehNo=request.getParameter("vehNo");
				
				
				if(fromDate!=null && toDate!=null && vehNo!=null)
				{
					lrList = transactionLrHeaderRepository.lrListByDateAndVehNo(fromDate,toDate,vehNo);
				 model.addObject("from",fromDate);
				 model.addObject("to",toDate);
				
				}
				float totalBill = 0;
				for(TransactionLrHeader lr:lrList)
				{
					totalBill+=lr.getTotal();
				}
				
				model.addObject("vehNo", vehNo);
				model.addObject("lrList",lrList);
				model.addObject("totalLr",lrList.size());
				model.addObject("totalBill",totalBill);
			}
				catch (Exception e) {
					e.printStackTrace();
					
				}
			return model;
			
		}
	  
	  @RequestMapping(value="/showLrListOfClient", method=RequestMethod.GET)
	  
		public ModelAndView showLrListOfClient(HttpServletRequest request)   
		{
			ModelAndView model=new ModelAndView("report/lrListOfClient");
			
			List<ClientDetails> clients = clientDetailsRepository.findAll();
			model.addObject("clientList",clients);
			
			return model;
			
		}
	
	  
	  @RequestMapping(value="/getLrListByClientId", method=RequestMethod.GET)
	  
		public @ResponseBody List<GetLrDetailsOfClient> getLrListByClientId(HttpServletRequest request)   
		{
			
		  clientLrList = new ArrayList<GetLrDetailsOfClient>();
		    
			int clientId = Integer.parseInt(request.getParameter("clientId"));
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			
		  try { 
			  clientLrList = getLrDetailsOfClientRepository.getLrByClientId(clientId ,fromDate, toDate);
		  System.out.println("lrHeaderList:"+lrHeaderList.toString());
		  }
		 		  catch (Exception e) { 
		 			  e.printStackTrace(); 
		  
		  }
		 
			return clientLrList;
			
		}
	
	  @RequestMapping(value="/showBillListOfClient", method=RequestMethod.GET)
	  
		public ModelAndView showBillListOfClient(HttpServletRequest request)   
		{
			ModelAndView model=new ModelAndView("report/billListOfClient");
			
			List<ClientDetails> clients = clientDetailsRepository.findAll();
			model.addObject("clientList",clients);
			
			return model;
			
		}
	  
	  @RequestMapping(value="/getBillListByClientId", method=RequestMethod.GET)
	  
		public @ResponseBody List<TransactionBillHeader> getBillListByClientId(HttpServletRequest request)   
		{
		 
		  clientBillList = new ArrayList<TransactionBillHeader>();
		    
			int clientId = Integer.parseInt(request.getParameter("clientId"));
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			
		  try { 
			  clientBillList = transactionBillHeaderRepository.getBillByClientId(clientId ,fromDate, toDate);
		 
		      }
		 		  catch (Exception e) { 
		 			  e.printStackTrace(); 
		  
		  }
		 
			return clientBillList;
			
		}
	  
	  @RequestMapping(value="/getLrByBillHeader", method=RequestMethod.GET)
	  
		public @ResponseBody List<LrBilling> getLrByBillHeader(HttpServletRequest request)   
		{
		 
			List<LrBilling> lrList = new ArrayList<LrBilling>();
		    
			int billHeaderId = Integer.parseInt(request.getParameter("billHeaderId"));
						
		  try { 
			  lrList = lrBillingRepository.getLrByBillHeader(billHeaderId);
		 
		      }
		 		  catch (Exception e) { 
		 			  e.printStackTrace(); 
		  
		  }
		 
			return lrList;
			
		}
	  
	  @RequestMapping(value="/showVoucher", method=RequestMethod.GET)
	  
		public ModelAndView showVoucher(HttpServletRequest request)   
		{
			ModelAndView model=new ModelAndView("report/voucher");
			
			List<VehicleDetails> vehicles = vehicleDetailsRepository.findAll();
			model.addObject("vehicles",vehicles);
			
			return model;
			
		}
	  
	  @RequestMapping(value="/getVoucherReport", method=RequestMethod.GET)
	  
		public @ResponseBody List<GetVoucherReport> getVoucherReport(HttpServletRequest request)   
		{
		 
		    voucherList = new ArrayList<GetVoucherReport>();
		    
			int vehId = Integer.parseInt(request.getParameter("vehId"));
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
		 
			voucherList = getVoucherReportRepository.getVoucherReport(vehId,fromDate,toDate);
		 
		 
			return voucherList;
			
		}
}
