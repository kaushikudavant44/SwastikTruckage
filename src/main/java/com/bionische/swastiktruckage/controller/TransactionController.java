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
import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceDetail;
import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceHeader;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.CompanyDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionLrContaintDetailsRepository;
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

			// get staff id through session
			// TODO
			int staffId = 8;
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

			if (transactionLrInvoiceHeaderRes != null) {
				System.out.println("dccdfvfv" + transactionLrContaintDetailsList.toString());
				for (int i = 0; i < transactionLrContaintDetailsList.size(); i++) {

					transactionLrContaintDetailsList.get(i).setLrHeaderId(transactionLrInvoiceHeaderRes.getInvHeaderId());
					
					

				}
			}
			 List<TransactionLrContaintDetails> transactionLrContaintDetailsListRes=transactionLrContaintDetailsRepository.saveAll(transactionLrContaintDetailsList);

			 System.out.println("result"+transactionLrContaintDetailsListRes);
			// List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailList=

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}

}
