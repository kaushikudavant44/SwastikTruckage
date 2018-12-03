package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceDetail;
import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceHeader;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.CompanyDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionLrContaintDetailsRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionLrInvoiceDetailRepository;
import com.bionische.swastiktruckage.repository.TransactionLrInvoiceHeaderRepository;

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

	@Autowired
	TransactionLrContaintDetailsRepository transactionLrContaintDetailsRepository;

	@Autowired
	TransactionLrInvoiceHeaderRepository transactionLrInvoiceHeaderRepository;
	
	@Autowired
	TransactionLrInvoiceDetailRepository transactionLrInvoiceDetailRepository;
	
	@Autowired
	TransactionLrHeaderRepository transactionLrHeaderRepository;

	List<TransactionLrContaintDetails> transactionLrContaintDetailsList = new ArrayList<>();

	List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailList = new ArrayList<>();

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

			CompanyDetails companyDetails = new CompanyDetails();

			OfficeStaff staffDetails = new OfficeStaff();
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			// get staff id through session
			// TODO
			int staffId = officeStaff.getStaffId();
			List<OfficeDetails> officeList = officeDetailsRepository.findByIsUsed(true);
			List<ClientDetails> clientList = clientDetailsRepository.findAll();

			companyDetails = companyDetailsRepository.findByCompanyId(1);
			staffDetails = officeStaffRepository.findByStaffId(staffId);

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
		TransactionLrContaintDetails transactionLrContaintDetails = new TransactionLrContaintDetails();
		transactionLrContaintDetails.setLrHeaderId(0);
		transactionLrContaintDetails.setDetailId(0);
		transactionLrContaintDetails.setNoOfContaints(Float.parseFloat(request.getParameter("noOfContaint")));
		transactionLrContaintDetails.setGoods(request.getParameter("goods"));
		transactionLrContaintDetails.setDescription(request.getParameter("description"));

		System.out.println("cdcs" + transactionLrContaintDetails.toString());
		try {

			transactionLrContaintDetailsList.add(transactionLrContaintDetails);
			System.out.println(transactionLrContaintDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transactionLrContaintDetailsList;

	}

	@RequestMapping(value = "/deleteContaint", method = RequestMethod.GET)

	public @ResponseBody List<TransactionLrContaintDetails> deleteContaint(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		TransactionLrContaintDetails transactionLrContaintDetails = new TransactionLrContaintDetails();

		int index = Integer.parseInt(request.getParameter("index"));

		try {

			transactionLrContaintDetailsList.remove(index);
			System.out.println(transactionLrContaintDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transactionLrContaintDetailsList;

	}

	@RequestMapping(value = "/addInvoiceNumber", method = RequestMethod.GET)

	public @ResponseBody List<TransactionLrInvoiceDetail> addInvoiceNumber(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		TransactionLrInvoiceDetail transactionLrInvoiceDetail = new TransactionLrInvoiceDetail();

		transactionLrInvoiceDetail.setInvNo(Integer.parseInt(request.getParameter("invoiceNo")));
		System.out.println("dfcfd" + transactionLrInvoiceDetail.toString());
		try {

			transactionLrInvoiceDetailList.add(transactionLrInvoiceDetail);
			System.out.println(transactionLrInvoiceDetailList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transactionLrInvoiceDetailList;

	}

	@RequestMapping(value = "/deleteInvoice", method = RequestMethod.GET)

	public @ResponseBody List<TransactionLrInvoiceDetail> deleteInvoice(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		TransactionLrInvoiceDetail transactionLrInvoiceDetail = new TransactionLrInvoiceDetail();

		int index = Integer.parseInt(request.getParameter("index"));

		try {

			transactionLrInvoiceDetailList.remove(index);
			System.out.println(transactionLrInvoiceDetailList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transactionLrInvoiceDetailList;

	}

	@RequestMapping(value = "/insertLR", method = RequestMethod.POST)

	public ModelAndView insertLR(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");

		try {
			TransactionLrInvoiceHeader transactionLrInvoiceHeader = new TransactionLrInvoiceHeader();

			// transactionLrContaintDetails=new TransactionLrContaintDetails();

			transactionLrInvoiceHeader.setUsed(true);
			TransactionLrInvoiceHeader transactionLrInvoiceHeaderRes = transactionLrInvoiceHeaderRepository.save(transactionLrInvoiceHeader);

			
			if(transactionLrInvoiceHeaderRes !=null) {
				
				for(int i=0;i<transactionLrInvoiceDetailList.size();i++) {
					
					transactionLrInvoiceDetailList.get(i).setInvHeaderId(transactionLrInvoiceHeaderRes.getInvHeaderId());
					
				}
				
			}
			List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailListRes=transactionLrInvoiceDetailRepository.saveAll(transactionLrInvoiceDetailList);
			
			System.out.println("Invoice details"+transactionLrInvoiceDetailListRes.toString());
			int lrId=0;
			TransactionLrHeader transactionLrHeader=new TransactionLrHeader();
			try {
			lrId=transactionLrHeaderRepository.findLastRecord();
			}catch(Exception e) {
				e.printStackTrace();
			}
			if(lrId==0) {
				
				lrId=1800001;
			}else {
				lrId++;
			}
			transactionLrHeader.setLrHeaderId(lrId);
			transactionLrHeader.setInvHeaderId(transactionLrInvoiceHeaderRes.getInvHeaderId());
			transactionLrHeader.setFromId(Integer.parseInt(request.getParameter("formId")));
			transactionLrHeader.setToId(Integer.parseInt(request.getParameter("toId")));
			transactionLrHeader.setConsignor(request.getParameter("consignor"));
			transactionLrHeader.setLrDate(request.getParameter("lrDate"));
			transactionLrHeader.setConsignee(request.getParameter("consignee"));
			transactionLrHeader.setConsigneeId(Integer.parseInt(request.getParameter("consigneeId")));
			transactionLrHeader.setTruckNo(request.getParameter("truckNo"));
			transactionLrHeader.setWeight(Float.parseFloat(request.getParameter("weight")));
			transactionLrHeader.setFreight(Float.parseFloat(request.getParameter("freight")));
			transactionLrHeader.setGst(Float.parseFloat(request.getParameter("gst")));
			transactionLrHeader.setHamali(Float.parseFloat(request.getParameter("hamali")));
			transactionLrHeader.setB_c_charge(Float.parseFloat(request.getParameter("bccharge")));
			transactionLrHeader.setKata(Float.parseFloat(request.getParameter("kata")));
			transactionLrHeader.setLocalTempo(Float.parseFloat(request.getParameter("localtempo")));
			transactionLrHeader.setBharai(Float.parseFloat(request.getParameter("bharai")));
			transactionLrHeader.setDd_charges(Float.parseFloat(request.getParameter("ddcharges")));
			transactionLrHeader.setTotal(Float.parseFloat(request.getParameter("total")));
			transactionLrHeader.setPaymentBy(Integer.parseInt(request.getParameter("paymentBy")));
			transactionLrHeader.setStatus(0);
			
			
			TransactionLrHeader transactionLrHeaderRes=transactionLrHeaderRepository.save(transactionLrHeader);
			
			System.out.println("dds0"+transactionLrHeaderRes.toString());
			if (transactionLrHeaderRes != null) {
			
				
				System.out.println("dccdfvfv" + transactionLrContaintDetailsList.toString());
				for (int i = 0; i < transactionLrContaintDetailsList.size(); i++) {

					transactionLrContaintDetailsList.get(i).setLrHeaderId(transactionLrHeaderRes.getLrHeaderId());
				
				}
			}
			 List<TransactionLrContaintDetails> transactionLrContaintDetailsListRes=transactionLrContaintDetailsRepository.saveAll(transactionLrContaintDetailsList);

			 System.out.println("result"+transactionLrContaintDetailsListRes);
		

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}

}
