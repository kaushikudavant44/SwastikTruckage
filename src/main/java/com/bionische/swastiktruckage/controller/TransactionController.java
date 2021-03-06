package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.common.DateConverter;
import com.bionische.swastiktruckage.master.controller.SMSSender;
import com.bionische.swastiktruckage.mastermodel.City;
import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.CompanyDetails;
import com.bionische.swastiktruckage.mastermodel.GetAllLrDetails;
import com.bionische.swastiktruckage.mastermodel.Goods;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.LRDetails;
import com.bionische.swastiktruckage.mastermodel.LrContaintDetails;
import com.bionische.swastiktruckage.mastermodel.LrLogs;
import com.bionische.swastiktruckage.mastermodel.OfficeDetails;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.mastermodel.TransactionLrContaintDetails;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceDetail;
import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceHeader;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.ClientFullDetailsRepository;
import com.bionische.swastiktruckage.repository.CompanyDetailsRepository;
import com.bionische.swastiktruckage.repository.GetAllLrDetailsRepository;
import com.bionische.swastiktruckage.repository.GoodsRepository;
import com.bionische.swastiktruckage.repository.LRDetailsRepository;
import com.bionische.swastiktruckage.repository.LrBillingRepository;
import com.bionische.swastiktruckage.repository.LrContaintDetailsRepository;
import com.bionische.swastiktruckage.repository.LrLogsRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionLrContaintDetailsRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
import com.bionische.swastiktruckage.repository.TransactionLrInvoiceDetailRepository;
import com.bionische.swastiktruckage.repository.TransactionLrInvoiceHeaderRepository;
import com.bionische.swastiktruckage.repository.VehicleDetailsRepository;
import com.bionische.swastiktruckage.service.ClientDetailsService;
import com.bionische.swastiktruckage.service.StateDetailsService;

@Controller
@SessionScope
public class TransactionController {

	@Autowired
	ClientDetailsService clientDetailsService;
	
	@Autowired
	LRDetailsRepository lRDetailsRepository;
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;
	
	@Autowired
	LrContaintDetailsRepository lrContaintDetailsRepository;
	
	@Autowired
	LrLogsRepository lrLogsRepository;
	
	@Autowired
	GetAllLrDetailsRepository getAllLrDetailsRepository;
	
	@Autowired
	CompanyDetailsRepository companyDetailsRepository;

	@Autowired
	OfficeStaffRepository officeStaffRepository;

	@Autowired
	OfficeDetailsRepository officeDetailsRepository;

	@Autowired
	ClientDetailsRepository clientDetailsRepository;
	
	@Autowired
	ClientFullDetailsRepository clientFullDetailsRepository;

	@Autowired
	TransactionLrContaintDetailsRepository transactionLrContaintDetailsRepository;

	@Autowired
	TransactionLrInvoiceHeaderRepository transactionLrInvoiceHeaderRepository;
	
	@Autowired
	TransactionLrInvoiceDetailRepository transactionLrInvoiceDetailRepository;
	
	@Autowired
	TransactionLrHeaderRepository transactionLrHeaderRepository;
	
	@Autowired
	LrBillingRepository lrBillingRepository;
	
	@Autowired
	StateDetailsService stateDetailsService;
	
	@Autowired
	GoodsRepository goodsRepository;

	List<LrContaintDetails> lrContaintDetailsList = new ArrayList<>();

	List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailList = new ArrayList<>();
	
	List<TransactionLrContaintDetails> transactionLrContaintDetailsList=new ArrayList<>();
	
	public String message;
	
	List<ClientFullDetails> clientList;
	
	@RequestMapping(value = "/showLRRegistration", method = RequestMethod.GET)

	public ModelAndView showLR(HttpServletRequest request) {
		/*ModelAndView model = new ModelAndView("transaction/lrGenerate");*/

		ModelAndView model = new ModelAndView("transaction/tempLRCreate");
		try {
			lrContaintDetailsList.clear();
			transactionLrInvoiceDetailList.clear();
			transactionLrContaintDetailsList.clear();
			CompanyDetails companyDetails = new CompanyDetails();

			OfficeStaff staffDetails = new OfficeStaff();
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			// get staff id through session
			// TODO
			int staffId = officeStaff.getStaffId();
			List<OfficeDetails> officeList = officeDetailsRepository.findByIsUsed(true);
			 clientList = clientFullDetailsRepository.getAllClientDetailsByStatus(1);
			List<City> cityList = stateDetailsService.getAllCity();
			List<States> stateList=stateDetailsService.getAllStates();
			
			List<Goods> goodsList=goodsRepository.findByIsUsedOrderByGoodsIdDescIsUsed(true);

			companyDetails = companyDetailsRepository.findByCompanyId(1);
			staffDetails = officeStaffRepository.findByStaffId(staffId);

			model.addObject("stateList", stateList);
			model.addObject("goodsList", goodsList);
			model.addObject("cityList", cityList);
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

	public @ResponseBody List<LrContaintDetails> addContaint(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		LrContaintDetails lrContaintDetails = new LrContaintDetails();
		lrContaintDetails.setLrHeaderId(0);
		lrContaintDetails.setDetailId(0);
		lrContaintDetails.setNoOfContaints(Float.parseFloat(request.getParameter("noOfContaint")));
		lrContaintDetails.setGoodsId(Integer.parseInt(request.getParameter("goodsId")));
		lrContaintDetails.setDescription(request.getParameter("description"));
		lrContaintDetails.setGoodsName(request.getParameter("goodsName"));
		System.out.println("adding containt " + lrContaintDetails.toString());
		try {

			lrContaintDetailsList.add(lrContaintDetails);
			System.out.println(lrContaintDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lrContaintDetailsList;

	}

	@RequestMapping(value = "/deleteContaint", method = RequestMethod.GET)

	public @ResponseBody List<LrContaintDetails> deleteContaint(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
	//	LrContaintDetails lrContaintDetails = new LrContaintDetails();

		int index = Integer.parseInt(request.getParameter("index"));

		try {

			lrContaintDetailsList.remove(index);
			System.out.println(lrContaintDetailsList.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return lrContaintDetailsList;

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

	public String insertLR(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		int staffId=officeStaff.getStaffId();
		TransactionLrHeader transactionLrHeaderRes1 = null;
		int lrId=0;
		try {
			TransactionLrInvoiceHeader transactionLrInvoiceHeader = new TransactionLrInvoiceHeader();

			// transactionLrContaintDetails=new TransactionLrContaintDetails();

			transactionLrInvoiceHeader.setUsed(true);
			TransactionLrInvoiceHeader transactionLrInvoiceHeaderRes = transactionLrInvoiceHeaderRepository.save(transactionLrInvoiceHeader);
			String invoiceNumbers=request.getParameter("invoiceNo");
			
			String[] invNo=invoiceNumbers.split(",");
			System.out.println("cd"+invNo.toString());
			if(transactionLrInvoiceHeaderRes !=null) {
				
				for(int i=0;i<invNo.length;i++) {
					
					TransactionLrInvoiceDetail transactionLrInvoiceDetail=new TransactionLrInvoiceDetail();
					transactionLrInvoiceDetail.setInvHeaderId(transactionLrInvoiceHeaderRes.getInvHeaderId());
					transactionLrInvoiceDetail.setInvNo((Integer.parseInt(invNo[i])));
					transactionLrInvoiceDetailList.add(transactionLrInvoiceDetail);
					
				}
				
			}
			List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailListRes=transactionLrInvoiceDetailRepository.saveAll(transactionLrInvoiceDetailList);
			
			System.out.println("Invoice details"+transactionLrInvoiceDetailListRes.toString());
			
			
			try {
				TransactionLrHeader transactionLrHeaderRes=transactionLrHeaderRepository.findLastRecord();
				if(transactionLrHeaderRes!=null) {
					lrId=transactionLrHeaderRes.getLrNo();
					lrId++;
				}else {
					lrId=20000;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			TransactionLrHeader transactionLrHeader=new TransactionLrHeader();
			
			String lrDate=DateConverter.convertToYMD(request.getParameter("lrDate"));
			
			transactionLrHeader.setLrNo(lrId);
			transactionLrHeader.setInvHeaderId(transactionLrInvoiceHeaderRes.getInvHeaderId());
			transactionLrHeader.setFromId(Integer.parseInt(request.getParameter("fromId")));
			transactionLrHeader.setConsignor(Integer.parseInt(request.getParameter("consignor")));
			transactionLrHeader.setLrDate(lrDate);
			transactionLrHeader.setConsigneeId(Integer.parseInt(request.getParameter("consigneeId")));
			transactionLrHeader.setTruckNo(request.getParameter("truckNo"));
			transactionLrHeader.setWeight(request.getParameter("weight"));
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
			transactionLrHeader.setBillStatus(0);
			transactionLrHeader.setDeliveryStatus(0);
			transactionLrHeader.setUsed(true);
			
			
			 transactionLrHeaderRes1=transactionLrHeaderRepository.save(transactionLrHeader);
			
			System.out.println("dds0"+transactionLrHeaderRes1.toString());
			
			if (transactionLrHeaderRes1 != null) {
				ClientDetails	clientDetails = clientDetailsRepository.findByClientId(transactionLrHeaderRes1.getConsignor());
			
				SMSSender.send(clientDetails.getClientContactNo(),"LR has been generated");
			}
			
			if (transactionLrHeaderRes1 != null) {
			
				
				System.out.println("dccdfvfv" + lrContaintDetailsList.toString());
				
				for (int i = 0; i < lrContaintDetailsList.size(); i++) {
					
					TransactionLrContaintDetails transactionLrContaintDetails=new TransactionLrContaintDetails();
					
					
					transactionLrContaintDetails.setLrHeaderId(transactionLrHeaderRes1.getLrHeaderId());
					transactionLrContaintDetails.setDescription(lrContaintDetailsList.get(i).getDescription());
					transactionLrContaintDetails.setGoodsId(lrContaintDetailsList.get(i).getGoodsId());
					transactionLrContaintDetails.setNoOfContaints(lrContaintDetailsList.get(i).getNoOfContaints());
					transactionLrContaintDetailsList.add(transactionLrContaintDetails);
				}
				
			}
			
			 List<TransactionLrContaintDetails> transactionLrContaintDetailsListRes=transactionLrContaintDetailsRepository.saveAll(transactionLrContaintDetailsList);
			
			 System.out.println("result"+transactionLrContaintDetailsListRes);
		try {
			
			 LrLogs lrLogs=new LrLogs();
			 
			 lrLogs.setLrNo(transactionLrHeaderRes1.getLrNo());
			 lrLogs.setModifiedById(staffId);
			 lrLogs.setModifiedByOffice(transactionLrHeaderRes1.getFromId());
			 lrLogs=lrLogsRepository.save(lrLogs);
			 System.out.println("xsxs"+lrLogs.toString());
		

		} catch (Exception e) {
				e.printStackTrace();
		}	
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/showLrPreview/"+transactionLrHeaderRes1.getLrHeaderId();

	}
	
	@RequestMapping(value = "/showLrDetails", method = RequestMethod.GET)

	public ModelAndView showLrDetails(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/showLrDetails");
		
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		int officeId=officeStaff.getStaffOfficeId();
		System.out.println("cdd"+officeId);
		List<GetAllLrDetails> lrDetailsList=new ArrayList<>();
		
		try {
			lrDetailsList=getAllLrDetailsRepository.findAllLr(officeId);
			
			for(int i=0;i<lrDetailsList.size();i++) {
				lrDetailsList.get(i).setLrDate(DateConverter.convertToDMY(lrDetailsList.get(i).getLrDate()));
			}
			System.out.println("cdydcb"+lrDetailsList.toString());
			model.addObject("lrDetailsList", lrDetailsList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/editLRDetails/{lrheaderId}", method = RequestMethod.GET)

	public ModelAndView editLRDetails(HttpServletRequest request, @PathVariable int lrheaderId) {
		ModelAndView model = new ModelAndView("transaction/editLr");

		LRDetails lrDetails=new LRDetails();
		
		List<VehicleDetails> vehicleDetailsList=new ArrayList<>();
		
		try {
			
			vehicleDetailsList=vehicleDetailsRepository.findByIsUsed(true);
			lrContaintDetailsList.clear();
			
			transactionLrContaintDetailsList.clear();
			
			transactionLrInvoiceDetailList.clear();
			List<Goods> goodsList=goodsRepository.findByIsUsedOrderByGoodsIdDescIsUsed(true);
			
			lrDetails=lRDetailsRepository.findByLrHeaderId(lrheaderId);
			
			lrDetails.setLrDate(DateConverter.convertToDMY(lrDetails.getLrDate()));
			
			List<LrContaintDetails> lrContaintDetailsListResult=new ArrayList<>();
			
			lrContaintDetailsListResult=lrContaintDetailsRepository.findByLrHeaderId(lrDetails.getLrHeaderId());
			
			
			List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailRes=new ArrayList<>();
			System.out.println("lr details"+lrDetails.toString());
			try {
				lrContaintDetailsList.addAll(lrContaintDetailsListResult);
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			try {
			 transactionLrInvoiceDetailRes=transactionLrInvoiceDetailRepository.findByInvHeaderId(lrDetails.getInvHeaderId());
			
			 transactionLrInvoiceDetailList.addAll(transactionLrInvoiceDetailRes);
			}catch(Exception e) {
				e.printStackTrace();
			}
			clientList = clientFullDetailsRepository.getAllClientDetailsByStatus(1);
			
			System.out.println("containt"+lrContaintDetailsList.toString());
			
			System.out.println("invoice"+transactionLrInvoiceDetailList.toString());
			
			model.addObject("clientList", clientList);
			
			model.addObject("lrDetails", lrDetails);
			
			model.addObject("lrContaintDetailsList", lrContaintDetailsList);
			
			model.addObject("transactionLrInvoiceDetailList", transactionLrInvoiceDetailList);
			 
			model.addObject("vehicleDetailsList", vehicleDetailsList);
			
			model.addObject("goodsList", goodsList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/insertEditedLR", method = RequestMethod.POST)

	public String insertEditedLR(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/showLrDetails");
		
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		int staffId=officeStaff.getStaffId();
		
		
		
		int invHeaderId=Integer.parseInt(request.getParameter("invHeaderId"));
		try {
			
			for(int i=0;i<transactionLrInvoiceDetailList.size();i++) {
				
				transactionLrInvoiceDetailList.get(i).setInvHeaderId(invHeaderId);
				
			}

			List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailListRes=transactionLrInvoiceDetailRepository.saveAll(transactionLrInvoiceDetailList);
			
			System.out.println("Invoice details"+transactionLrInvoiceDetailListRes.toString());
			
			TransactionLrHeader transactionLrHeader=new TransactionLrHeader();
			
			
			
			
			transactionLrHeader.setLrHeaderId(Integer.parseInt(request.getParameter("lrHeaderId")));
			transactionLrHeader.setLrNo(Integer.parseInt(request.getParameter("lrNo")));
			transactionLrHeader.setInvHeaderId(invHeaderId);
			transactionLrHeader.setFromId(Integer.parseInt(request.getParameter("fromId")));
			transactionLrHeader.setConsignor(Integer.parseInt(request.getParameter("consignor")));
			transactionLrHeader.setLrDate(DateConverter.convertToYMD(request.getParameter("lrDate")));
			transactionLrHeader.setConsigneeId(Integer.parseInt(request.getParameter("consigneeId")));
			transactionLrHeader.setTruckNo(request.getParameter("vehId"));
			transactionLrHeader.setWeight(request.getParameter("weight"));
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
			transactionLrHeader.setBillStatus(0);
			transactionLrHeader.setDeliveryStatus(0);
			transactionLrHeader.setUsed(true);
			
			
			TransactionLrHeader transactionLrHeaderRes1=transactionLrHeaderRepository.save(transactionLrHeader);
			
			System.out.println("dds0"+transactionLrHeaderRes1.toString());
			transactionLrContaintDetailsList.clear();
			
			if (transactionLrHeaderRes1 != null) {

				for (int i = 0; i < lrContaintDetailsList.size(); i++) {
					
					
					if(lrContaintDetailsList.get(i).getDetailId()==0) {
					
					TransactionLrContaintDetails transactionLrContaintDetails=new TransactionLrContaintDetails();
				
					transactionLrContaintDetails.setLrHeaderId(transactionLrHeaderRes1.getLrHeaderId());
					transactionLrContaintDetails.setDescription(lrContaintDetailsList.get(i).getDescription());
					transactionLrContaintDetails.setGoodsId(lrContaintDetailsList.get(i).getGoodsId());
					transactionLrContaintDetails.setNoOfContaints(lrContaintDetailsList.get(i).getNoOfContaints());
					transactionLrContaintDetailsList.add(transactionLrContaintDetails);
					}
				}
				
			}
			
			 List<TransactionLrContaintDetails> transactionLrContaintDetailsListRes=transactionLrContaintDetailsRepository.saveAll(transactionLrContaintDetailsList);
			
			 System.out.println("result"+transactionLrContaintDetailsListRes);
		try {
			
			 LrLogs lrLogs=new LrLogs();
			 
			 lrLogs.setLrNo(transactionLrHeaderRes1.getLrNo());
			 lrLogs.setModifiedById(staffId);
			 lrLogs.setModifiedByOffice(transactionLrHeaderRes1.getFromId());
			 lrLogs=lrLogsRepository.save(lrLogs);
			 System.out.println("xsxs"+lrLogs.toString());
		

		} catch (Exception e) {
				e.printStackTrace();
		}	
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/showLrDetails";

	}
	
	@RequestMapping(value = "/deleteEditedInvoice", method = RequestMethod.GET)
	public @ResponseBody List<TransactionLrInvoiceDetail> deleteEditedInvoice(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		TransactionLrInvoiceDetail transactionLrInvoiceDetail = new TransactionLrInvoiceDetail();

		int index = Integer.parseInt(request.getParameter("index"));
		int key = Integer.parseInt(request.getParameter("key"));
		try {

			int delete=transactionLrInvoiceDetailRepository.deleteByDetailId(index);
			
			if(delete==1)
			{
			transactionLrInvoiceDetailList.remove(key);
			}else {
				transactionLrInvoiceDetailList.remove(key);
				System.out.println(transactionLrInvoiceDetailList.toString());
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return transactionLrInvoiceDetailList;

	}
	
	@RequestMapping(value = "/deleteEditedContaint", method = RequestMethod.GET)

	public @ResponseBody List<LrContaintDetails> deleteEditedContaint(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/lrGenerate");
		LrContaintDetails lrContaintDetails = new LrContaintDetails();

		int index = Integer.parseInt(request.getParameter("index"));
		int key=Integer.parseInt(request.getParameter("key"));
		try {

			int deletecontaint=transactionLrContaintDetailsRepository.deleteByDetailId(index);
			System.out.println(lrContaintDetailsList.toString());
			if(deletecontaint==1) {
			lrContaintDetailsList.remove(key);
			System.out.println(lrContaintDetailsList.toString());
			}else {
				lrContaintDetailsList.remove(key);
				System.out.println(lrContaintDetailsList.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lrContaintDetailsList;

	}
	@RequestMapping(value = "/deleteLr/{lrHeaderId}", method = RequestMethod.GET)

	public String deleteLr(HttpServletRequest request,@PathVariable int lrHeaderId) {
		ModelAndView model = new ModelAndView("transaction/showLrDetails");

			TransactionLrHeader transactionLrHeader=new TransactionLrHeader();
		
			
		try {
			int isUsed=transactionLrHeaderRepository.updateLrByHeaderId(lrHeaderId);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/showLrDetails";

	}
	@RequestMapping(value = "/showLrPreview/{lrheaderId}", method = RequestMethod.GET)

	public ModelAndView showLrPreview(HttpServletRequest request, @PathVariable int lrheaderId) {
		ModelAndView model = new ModelAndView("transaction/lrPreview");

		LRDetails lrDetails=new LRDetails();
		
		try {
			
			
			lrContaintDetailsList.clear();
			
			transactionLrContaintDetailsList.clear();
			
			transactionLrInvoiceDetailList.clear();
			
			List<Goods> goodsList=goodsRepository.findByIsUsedOrderByGoodsIdDescIsUsed(true);
			
			lrDetails=lRDetailsRepository.findByLrHeaderId(lrheaderId);
			
			
			lrDetails.setLrDate(DateConverter.convertToDMY(lrDetails.getLrDate()));
			
			
			List<LrContaintDetails> lrContaintDetailsListResult=new ArrayList<>();
			
			lrContaintDetailsListResult=lrContaintDetailsRepository.findByLrHeaderId(lrDetails.getLrHeaderId());
			float total=0.0f;
			for(int i=0;i<lrContaintDetailsListResult.size();i++) {
				
				float containt=lrContaintDetailsListResult.get(i).getNoOfContaints();
				
				total=total+containt;
			}
			System.out.println("total="+total);
			
			List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailRes=new ArrayList<>();
			System.out.println("lr details"+lrContaintDetailsListResult.toString());
			try {
				lrContaintDetailsList.addAll(lrContaintDetailsListResult);
			
			}catch (Exception e) {
				e.printStackTrace();
			}
			try {
			 transactionLrInvoiceDetailRes=transactionLrInvoiceDetailRepository.findByInvHeaderId(lrDetails.getInvHeaderId());
			
			 transactionLrInvoiceDetailList.addAll(transactionLrInvoiceDetailRes);
			}catch(Exception e) {
				e.printStackTrace();
			}
			System.out.println("containt"+lrContaintDetailsList.toString());
			
			System.out.println("invoice"+transactionLrInvoiceDetailList.toString());
			
			System.out.println("Lr Details"+lrDetails.toString());
			
			
			model.addObject("containtTotal", total);
			model.addObject("lrDetails", lrDetails);
			
			model.addObject("lrContaintDetailsList", lrContaintDetailsList);
			
			model.addObject("transactionLrInvoiceDetailList", transactionLrInvoiceDetailList);
			 
			model.addObject("goodsList", goodsList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	
	@RequestMapping(value = "/insertTempLR", method = RequestMethod.POST)

	public String insertTempLR(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/tempLRCreate");
		
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		int staffId=officeStaff.getStaffId();
		TransactionLrHeader transactionLrHeaderRes1 = null;
		int lrId=0;
		try {
			TransactionLrInvoiceHeader transactionLrInvoiceHeader = new TransactionLrInvoiceHeader();

			// transactionLrContaintDetails=new TransactionLrContaintDetails();

			transactionLrInvoiceHeader.setUsed(true);
			TransactionLrInvoiceHeader transactionLrInvoiceHeaderRes = transactionLrInvoiceHeaderRepository.save(transactionLrInvoiceHeader);
			String invoiceNumbers=request.getParameter("invoiceNo");
			
			String[] invNo=invoiceNumbers.split(",");
			System.out.println("cd"+invNo.toString());
			if(transactionLrInvoiceHeaderRes !=null) {
				
				for(int i=0;i<invNo.length;i++) {
					
					TransactionLrInvoiceDetail transactionLrInvoiceDetail=new TransactionLrInvoiceDetail();
					transactionLrInvoiceDetail.setInvHeaderId(transactionLrInvoiceHeaderRes.getInvHeaderId());
					transactionLrInvoiceDetail.setInvNo((Integer.parseInt(invNo[i])));
					transactionLrInvoiceDetailList.add(transactionLrInvoiceDetail);
					
				}
				
			}
			List<TransactionLrInvoiceDetail> transactionLrInvoiceDetailListRes=transactionLrInvoiceDetailRepository.saveAll(transactionLrInvoiceDetailList);
			
			System.out.println("Invoice details"+transactionLrInvoiceDetailListRes.toString());
			
			
			/*try {
				TransactionLrHeader transactionLrHeaderRes=transactionLrHeaderRepository.findLastRecord();
				if(transactionLrHeaderRes!=null) {
					lrId=transactionLrHeaderRes.getLrNo();
					lrId++;
				}else {
					lrId=180001;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}*/
			
			
			TransactionLrHeader transactionLrHeader=new TransactionLrHeader();
			
			String lrDate=DateConverter.convertToYMD(request.getParameter("lrDate"));
			
			transactionLrHeader.setLrNo(Integer.parseInt(request.getParameter("lrNo")));
			transactionLrHeader.setInvHeaderId(transactionLrInvoiceHeaderRes.getInvHeaderId());
			transactionLrHeader.setFromId(Integer.parseInt(request.getParameter("fromId")));
			transactionLrHeader.setConsignor(Integer.parseInt(request.getParameter("consignor")));
			transactionLrHeader.setLrDate(lrDate);
			transactionLrHeader.setConsigneeId(Integer.parseInt(request.getParameter("consigneeId")));
			transactionLrHeader.setTruckNo(request.getParameter("truckNo"));
			
			transactionLrHeader.setWeight(request.getParameter("weight"));
			
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
			transactionLrHeader.setBillStatus(0);
			transactionLrHeader.setDeliveryStatus(0);
			transactionLrHeader.setUsed(true);
			
			
			 transactionLrHeaderRes1=transactionLrHeaderRepository.save(transactionLrHeader);
			
			System.out.println("dds0"+transactionLrHeaderRes1.toString());
			
			if (transactionLrHeaderRes1 != null) {
				ClientDetails	clientDetails = clientDetailsRepository.findByClientId(transactionLrHeaderRes1.getConsignor());
			
				SMSSender.send(clientDetails.getClientContactNo(),"LR has been generated");
			}
			
			if (transactionLrHeaderRes1 != null) {
			
				
				System.out.println("dccdfvfv" + lrContaintDetailsList.toString());
				
				for (int i = 0; i < lrContaintDetailsList.size(); i++) {
					
					TransactionLrContaintDetails transactionLrContaintDetails=new TransactionLrContaintDetails();
					
					
					transactionLrContaintDetails.setLrHeaderId(transactionLrHeaderRes1.getLrHeaderId());
					transactionLrContaintDetails.setDescription(lrContaintDetailsList.get(i).getDescription());
					transactionLrContaintDetails.setGoodsId(lrContaintDetailsList.get(i).getGoodsId());
					transactionLrContaintDetails.setNoOfContaints(lrContaintDetailsList.get(i).getNoOfContaints());
					transactionLrContaintDetailsList.add(transactionLrContaintDetails);
				}
				
			}
			
			 List<TransactionLrContaintDetails> transactionLrContaintDetailsListRes=transactionLrContaintDetailsRepository.saveAll(transactionLrContaintDetailsList);
			
			 System.out.println("result"+transactionLrContaintDetailsListRes);
		try {
			
			 LrLogs lrLogs=new LrLogs();
			 
			 lrLogs.setLrNo(transactionLrHeaderRes1.getLrNo());
			 lrLogs.setModifiedById(staffId);
			 lrLogs.setModifiedByOffice(transactionLrHeaderRes1.getFromId());
			 lrLogs=lrLogsRepository.save(lrLogs);
			 System.out.println("xsxs"+lrLogs.toString());
		

		} catch (Exception e) {
				e.printStackTrace();
		}	
		
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return "redirect:/showLrPreview/"+transactionLrHeaderRes1.getLrHeaderId();

	}
	
	@RequestMapping(value = "/saveClientDetails", method = RequestMethod.GET)
	public @ResponseBody ClientDetails saveClientDetails(HttpServletRequest request, HttpServletResponse response) {
		
		
		Info info=new Info();
		ClientDetails clientDetails = new ClientDetails();
		
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
		 info = clientDetailsService.insertClientDetails(clientDetails);
		
		if(info.isError())
		{
			message = "Something Went Wrong";
		}
		else
		{
			message = "Client Added Successfully";
		}
		} catch (Exception e) {
			e.printStackTrace();
			

		}
		return clientDetails;

	}
		
}
