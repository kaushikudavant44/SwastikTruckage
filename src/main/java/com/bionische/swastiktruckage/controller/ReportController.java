package com.bionische.swastiktruckage.controller;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.master.controller.ExcelWriter;
import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrCollection;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.repository.LrBillingRepository;
import com.bionische.swastiktruckage.repository.TransactionBillHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionLrCollectionRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;

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
	
	@RequestMapping(value="/showpendingPaymentLrList", method=RequestMethod.GET)

	public ModelAndView showpendingPaymentLrList(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("report/paymentPendingLrList");
		List<LrBilling> lrHeaderList = new ArrayList<LrBilling>();
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
			List<TransactionLrHeader> lrList;
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
			List<TransactionLrCollection> collectionList;
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
			List<TransactionBillHeader> billList;
			String fromDate = request.getParameter("from");
			String toDate = request.getParameter("to");
			
			if(fromDate!=null && toDate!=null)
			{
				billList = transactionBillHeaderRepository.billByDate(1,fromDate,toDate);
			 model.addObject("from",fromDate);
			 model.addObject("to",toDate);
			}
			else
			{
				billList = transactionBillHeaderRepository.billByDate(1,new SimpleDateFormat("yyyy-MM-dd").format(new Date()),new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("from",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			 model.addObject("to",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			}
			
			float totalBill = 0; 
			for(TransactionBillHeader bill : billList)
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
		
		Field[] declaredFields = TransactionBillHeader.class.getDeclaredFields();
        for(Field f:declaredFields){
            System.out.println(f.getName());
        }
		return model;
		
	}
	
	@RequestMapping(value="/showExcel", method=RequestMethod.POST)

	public ModelAndView showExcel(@ModelAttribute("billList") List<TransactionBillHeader> list,HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("client/showAllClients");
		
		System.out.println("billList:"+list.toString());
		try {
			ExcelWriter.main();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return model;
		
	}	
}
