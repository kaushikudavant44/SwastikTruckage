package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.master.controller.SMSSender;
import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.GetAllLrDetails;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.MemoDetails;
import com.bionische.swastiktruckage.mastermodel.MemoHeader;
import com.bionische.swastiktruckage.mastermodel.OfficeDetails;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.mastermodel.VehicleOwners;
import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;
import com.bionische.swastiktruckage.mastermodel.VoucherDetails;
import com.bionische.swastiktruckage.model.GetAllMemo;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.GetAllLrDetailsRepository;
import com.bionische.swastiktruckage.repository.GetAllMemoRepository;
import com.bionische.swastiktruckage.repository.MemoDetailsRepository;
import com.bionische.swastiktruckage.repository.MemoHeaderRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
import com.bionische.swastiktruckage.repository.VehicleDetailsRepository;
import com.bionische.swastiktruckage.repository.VehicleOwnersRepository;
import com.bionische.swastiktruckage.repository.VehiclesDriversRepository;
import com.bionische.swastiktruckage.repository.VoucherDetailsRepository;

@Controller
public class MemoController {
	
	
	@Autowired
	VoucherDetailsRepository voucherDetailsRepository;
	
	@Autowired
	GetAllLrDetailsRepository getAllLrDetailsRepository;
	
	@Autowired
	OfficeDetailsRepository officeDetailsRepository;
	
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;
	
	@Autowired
	VehicleOwnersRepository vehicleOwnersRepository;
	
	@Autowired
	VehiclesDriversRepository vehiclesDriversRepository;
	
	@Autowired
	MemoDetailsRepository memoDetailsRepository;
	
	@Autowired
	MemoHeaderRepository memoHeaderRepository;
	
	@Autowired
	TransactionLrHeaderRepository transactionLrHeaderRepository;
	
	@Autowired
	GetAllMemoRepository getAllMemoRepository;
	
	@Autowired
	ClientDetailsRepository clientDetailsRepository;
	
	List<VehicleDetails> vehicalDetailsList=new ArrayList<>();
	
	@RequestMapping(value = "/generateMemo", method = RequestMethod.GET)

	public ModelAndView showPatientLoginPage(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/generateMemo");

		try {
			List<GetAllLrDetails> lrDetailsList=new ArrayList<>();
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			// get staff id through session
			// TODO
			int staffId = officeStaff.getStaffId();
			OfficeStaff staffDetails = new OfficeStaff();
			
			List<VehiclesDrivers> vehicleDriverList=new ArrayList<>();
			
			vehicalDetailsList=vehicleDetailsRepository.findByIsUsed(true);
			List<OfficeDetails> officeList = officeDetailsRepository.findByIsUsed(true);
			//List<ClientDetails> clientDetails=clientDetailsRepository.findByIsUsed(true);
			staffDetails = officeStaffRepository.findByStaffId(staffId);
			lrDetailsList=getAllLrDetailsRepository.findLrForMakeMemo();
			vehicleDriverList=vehiclesDriversRepository.findByIsUsed(true);
			
			
			model.addObject("vehicleDriverList", vehicleDriverList);
			model.addObject("vehicalDetailsList", vehicalDetailsList);
			model.addObject("officeList", officeList);
			model.addObject("staffDetails", staffDetails);
			model.addObject("lrDetailsList", lrDetailsList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	
	@RequestMapping(value = "/getVehicalOwnerDetails", method = RequestMethod.GET)
	public @ResponseBody VehicleOwners getVehicalOwnerDetails(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/generateMemo");
		VehicleOwners vehicleOwners = new VehicleOwners();

		int ownerId = Integer.parseInt(request.getParameter("ownerId"));
		
		try {

			
			vehicleOwners=vehicleOwnersRepository.findByOwnerId(ownerId);
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehicleOwners;

	}
	
	@RequestMapping(value = "/saveMemoDetails", method = RequestMethod.GET)
	public @ResponseBody Info saveMemoDetails(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/generateMemo");
		Info info=new Info();

		MemoHeader memoHeader=new MemoHeader();
		
		
 		int memoNo=0;
		try {
			MemoHeader memoRes=memoHeaderRepository.findLastRecord();
			
			if(memoRes!=null) {
				memoNo=memoRes.getMemoNo();
				memoNo++;
			}else {
				memoNo=180001;
			}
			String vehicalNo=request.getParameter("ownerId");
			for(int i=0;i<vehicalDetailsList.size();i++) {
			if(vehicalNo.equals(vehicalDetailsList.get(i).getVehNo())) {
				
				memoHeader.setVehId(vehicalDetailsList.get(i).getVehId());
			}
			}
				
			
			memoHeader.setMemoNo(memoNo);
			memoHeader.setDriverId(Integer.parseInt(request.getParameter("driverId")));
			memoHeader.setOfficeId(Integer.parseInt(request.getParameter("officeId")));
			memoHeader.setStaffId(Integer.parseInt(request.getParameter("staffId")));
			memoHeader.setToId(Integer.parseInt(request.getParameter("toId")));
			memoHeader.setUsed(true);
			memoHeader.setStatus(0);
			MemoHeader memoHeaderResult=memoHeaderRepository.save(memoHeader);
			
			
			String getMemoHeaderId=request.getParameter("selectedRowList");
			String getAllMemoHeader=getMemoHeaderId.substring(1, getMemoHeaderId.length()-1);
			
			System.out.println(getAllMemoHeader.toString());
			List<MemoDetails> memoDetailsList=new ArrayList<>();
		
			
			String[] memoHeaderId = getAllMemoHeader.split(",");
			
			for(int i=0;i<memoHeaderId.length;i++) {
			
				
				MemoDetails memoDetails=new MemoDetails();
				memoDetails.setLrHeaderId(Integer.parseInt(memoHeaderId[i]));
				memoDetails.setMemoHeaderId(memoHeaderResult.getMemoHeaderId());
				memoDetails.setLrStatus(0);
				memoDetailsList.add(memoDetails);
					
			}
			System.out.println("memo detail list"+memoDetailsList.toString());
			memoDetailsList=memoDetailsRepository.saveAll(memoDetailsList);
			
			for(MemoDetails memo : memoDetailsList)
			{
				TransactionLrHeader res = transactionLrHeaderRepository.findByLrHeaderId(memo.getLrHeaderId());
				ClientDetails	clientDetails = clientDetailsRepository.findByClientId(res.getConsignor());
				
				SMSSender.send(clientDetails.getClientContactNo(),"Memo has been generated");
			}
			
			if(memoDetailsList.isEmpty()) {
				
				
				info.setMessage("Something Went wrong! Try agin");
			}else {
				for(int i=0;i<memoDetailsList.size();i++) {
					
					int deliveryStatus=transactionLrHeaderRepository.updateLrDeliveryStatusByHeaderId(memoDetailsList.get(i).getLrHeaderId());
					if(deliveryStatus==1) {
						System.out.println("Status Update");
					}
					
					
				}
				
				info.setMessage("Memo created Successfully");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;

	}
	
	@RequestMapping(value = "/showMemo", method = RequestMethod.GET)

	public ModelAndView showMemo(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/showMemoDetails");

		List<GetAllMemo> getAllMemoList=new ArrayList<>();
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		// get staff id through session
		// TODO
		int officeId = officeStaff.getStaffOfficeId();
		try {
			getAllMemoList=getAllMemoRepository.getListOfMemo(officeId);
			
			System.out.println("MemoList"+getAllMemoList);
			
			model.addObject("getAllMemoList", getAllMemoList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/showEditMemoDetails/{memoHeaderId}", method = RequestMethod.GET)

	public ModelAndView showLrPreview(HttpServletRequest request, @PathVariable int memoHeaderId) {
		ModelAndView model = new ModelAndView("memo/editMemo");

		
		try {
			List<GetAllLrDetails> lrDetailsList=new ArrayList<>();
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			int staffId = officeStaff.getStaffId();
			OfficeStaff staffDetails = new OfficeStaff();
			GetAllMemo getMemoDeatails=new GetAllMemo();
			vehicalDetailsList.clear();
			
			List<VehiclesDrivers> vehicleDriverList=new ArrayList<>();
			
			vehicalDetailsList=vehicleDetailsRepository.findByIsUsed(true);
			List<OfficeDetails> officeList = officeDetailsRepository.findByIsUsed(true);
			VehicleOwners vehicleOwners = new VehicleOwners();
			staffDetails = officeStaffRepository.findByStaffId(staffId);
			vehicleDriverList=vehiclesDriversRepository.findByIsUsed(true);
			
			//vehicleOwner=vehicleOwnersRepository.findByIsUsed(true);
			getMemoDeatails=getAllMemoRepository.findByMemoHeaderId(memoHeaderId);
		//	staffDetails = officeStaffRepository.findByStaffId(staffId);
			lrDetailsList=getAllLrDetailsRepository.getMemoLrDetailsByMemoHeaderId(memoHeaderId);
			
			System.out.println("getMemoDeatails"+getMemoDeatails.toString());
			
			for(int i=0;i<vehicalDetailsList.size();i++) {
				if(vehicalDetailsList.get(i).getVehId()==getMemoDeatails.getVehId()) {
					
					int ownerId=vehicalDetailsList.get(i).getOwnerId();
					vehicleOwners=vehicleOwnersRepository.findByOwnerId(ownerId);
				}
				
			}
			
			model.addObject("vehicleOwners", vehicleOwners);
			model.addObject("vehicalDetailsList", vehicalDetailsList);
			model.addObject("officeList", officeList);
			model.addObject("vehicleDriverList", vehicleDriverList);
			model.addObject("lrDetailsList", lrDetailsList);
			model.addObject("getMemoDeatails", getMemoDeatails);
			model.addObject("staffDetails", staffDetails);
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/deleteMemo/{memoHeaderId}", method = RequestMethod.GET)

	public String deleteLr(HttpServletRequest request,@PathVariable int memoHeaderId) {
		ModelAndView model = new ModelAndView("transaction/showLrDetails");

			MemoHeader memoHeader=new MemoHeader();
		
			
		try {
			int isUsed=memoHeaderRepository.updateMemoByMemoHeaderId(memoHeaderId);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/showLrDetails";

	}
	
	
	@RequestMapping(value = "/editMemoDetails", method = RequestMethod.GET)
	public @ResponseBody Info editMemoDetails(HttpServletRequest request) {
		
		Info info=new Info();

		MemoHeader memoHeader=new MemoHeader();
		
		
 		vehicalDetailsList.clear();
		try {
			
			vehicalDetailsList=vehicleDetailsRepository.findByIsUsed(true);
			
			String vehicalNo=request.getParameter("ownerId");
			for(int i=0;i<vehicalDetailsList.size();i++) {
			if(vehicalNo.equals(vehicalDetailsList.get(i).getVehNo())) {
				
				memoHeader.setVehId(vehicalDetailsList.get(i).getVehId());
			}
			}
				
			memoHeader.setMemoHeaderId(Integer.parseInt(request.getParameter("memoHeaderId")));
			memoHeader.setMemoNo(Integer.parseInt(request.getParameter("memoNo")));
			
			memoHeader.setDriverId(Integer.parseInt(request.getParameter("driverId")));
			memoHeader.setOfficeId(Integer.parseInt(request.getParameter("officeId")));
			memoHeader.setStaffId(Integer.parseInt(request.getParameter("staffId")));
			memoHeader.setToId(Integer.parseInt(request.getParameter("toId")));
			memoHeader.setUsed(true);
			memoHeader.setStatus(0);
			MemoHeader memoHeaderResult=memoHeaderRepository.save(memoHeader);
			System.out.println("memoHeaderResult"+memoHeaderResult.toString());
			
			String getLrHeaderId=request.getParameter("unSelectedRowList");
			String getAllLrHeader=getLrHeaderId.substring(1, getLrHeaderId.length()-1);
			
			System.out.println(getAllLrHeader.toString());
			
			String[] memoLrId = getAllLrHeader.split(",");
			int deleteMemoDetails=0;
			
			for(int i=0;i<memoLrId.length;i++) {
				if(memoLrId[i]!=null && memoLrId[i]!="") {
				int lrHeaderId=Integer.parseInt(memoLrId[i]);
				deleteMemoDetails=memoDetailsRepository.deleteMemoDetailsByLrHeaderId(lrHeaderId);
					
			
			
			if(deleteMemoDetails==1) {
				
				info.setMessage("Record Update Successfully");
			}else {
				info.setMessage("something went wrong");
			}
			}
			}
		//	info.setMessage("Record Update Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;

	}
	
	
	@RequestMapping(value = "/showVoucherReg/{memoHeaderId}", method = RequestMethod.GET)

	public ModelAndView generateVoucher(HttpServletRequest request,@PathVariable int memoHeaderId) {
		ModelAndView model = new ModelAndView("memo/createVoucher");

		
		try {
			
			GetAllMemo getMemoDeatails=new GetAllMemo();
			getMemoDeatails=getAllMemoRepository.findByMemoHeaderId(memoHeaderId);
			System.out.println("getMemoDeatails"+getMemoDeatails.toString());
			//VoucherDetails voucherDetails=voucherDetailsRepository.save(voucherDetails);
			model.addObject("getMemoDeatails", getMemoDeatails);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/insertVoucher", method = RequestMethod.POST)

	public String insertVoucher(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/createVoucher");

		String url;
		int voucherNo=0;
		VoucherDetails voucherDetails=new VoucherDetails();
		
		try {
			
			VoucherDetails voucherDetailsResult=voucherDetailsRepository.findLastRecord();
		
		if(voucherDetailsResult!=null) {
			voucherNo=voucherDetailsResult.getVoucherId();
			voucherNo++;
		}else {
			voucherNo=180001;
		}
		
		
		voucherDetails.setDriverId(Integer.parseInt(request.getParameter("driverId")));
		voucherDetails.setMemoHeaderId(Integer.parseInt(request.getParameter("memoHeaderId")));
		voucherDetails.setUsed(true);
		voucherDetails.setVehId(Integer.parseInt(request.getParameter("vehId")));
		voucherDetails.setVoucherAmount(Float.parseFloat(request.getParameter("voucherAmount")));
		voucherDetails.setVoucherNo(voucherNo);

		voucherDetails=voucherDetailsRepository.save(voucherDetails);
		
		if(voucherDetails!=null) {
			
			model.addObject("message", "Voucher Create Successfully");
		}
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
			url = "redirect:/errorMessage";
		}

		return url = "redirect:/showMemo";

	}
	
	
	@RequestMapping(value = "/memoPreview/{memoHeaderId}", method = RequestMethod.GET)

	public ModelAndView memoPreview(HttpServletRequest request, @PathVariable int memoHeaderId) {
		ModelAndView model = new ModelAndView("memo/memo");

		
		try {
			List<GetAllLrDetails> lrDetailsList=new ArrayList<>();
			/*HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			int staffId = officeStaff.getStaffId();*/
		
			lrDetailsList=getAllLrDetailsRepository.getMemoLrDetailsByMemoHeaderId(memoHeaderId);
			
			GetAllMemo getMemoDeatails=new GetAllMemo();
			getMemoDeatails=getAllMemoRepository.findByMemoHeaderId(memoHeaderId);
			
			System.out.println("Memo Details"+getMemoDeatails.toString());
			System.out.println("Lr Details"+lrDetailsList.toString());
			model.addObject("getMemoDeatails", getMemoDeatails);
			model.addObject("lrDetailsList", lrDetailsList);
			
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/showMemoReceived", method = RequestMethod.GET)

	public ModelAndView showMemoReceived(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/memoReceived");

		try {
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/getMemoReceived", method = RequestMethod.POST)

	public ModelAndView getMemoReceived(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/memoReceived");

		
		try {
			int memoNo=Integer.parseInt(request.getParameter("memoNo"));
			GetAllMemo getMemoDeatails=new GetAllMemo();
			List<GetAllLrDetails> lrDetailsList=new ArrayList<>();
			getMemoDeatails=getAllMemoRepository.findByMemoNo(memoNo);
			lrDetailsList=getAllLrDetailsRepository.getMemoLrDetailsByMemoHeaderId(getMemoDeatails.getMemoHeaderId());
			System.out.println("getMemoDeatails"+getMemoDeatails);
			System.out.println("lrDetailsList"+lrDetailsList);
			model.addObject("getMemoDeatails", getMemoDeatails);
			model.addObject("lrDetailsList", lrDetailsList);
			model.addObject("memoNo", memoNo);
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/memoReceived", method = RequestMethod.GET)

	public @ResponseBody Info memoReceived(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/memoReceived");

		Info info=new Info();
		try {
			String getLrHeaderId=request.getParameter("selectedRowList");
			String getAllLrHeader=getLrHeaderId.substring(1, getLrHeaderId.length()-1);
			
			System.out.println(getAllLrHeader.toString());
			int memoHeaderId=Integer.parseInt(request.getParameter("memoHeaderId"));
			int memoDelStatus=memoHeaderRepository.updateMemoDeliveryByMemoHeaderId(memoHeaderId);
			String[] memoLrId = getAllLrHeader.split(",");
		
			int updateLr=0;
			for(int i=0;i<memoLrId.length;i++) {
				System.out.println(memoLrId[i]);
				if(memoLrId[i]!=null && memoLrId[i]!="") {
				int lrHeaderId=Integer.parseInt(memoLrId[i]);
				updateLr=transactionLrHeaderRepository.updateLrRecDeliveryStatusByHeaderId(lrHeaderId);
					
			
			
			if(updateLr==1) {
				
				info.setMessage("Memo Received");
			}else {
				info.setMessage("something went wrong");
			}
			}
			}
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return info;

	}
	@RequestMapping(value = "/showAllReceivedMemo", method = RequestMethod.GET)

	public ModelAndView showAllReceivedMemo(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/showAllReceivedMemo");

		try {
			
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			int officeId = officeStaff.getStaffOfficeId();
			List<GetAllMemo> getReceivedMemoDeatailsList=new ArrayList<>();
			
			getReceivedMemoDeatailsList=getAllMemoRepository.findAllReceivedMemo(officeId);
			
			model.addObject("getAllMemoList", getReceivedMemoDeatailsList);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	@RequestMapping(value = "/showRecievedLrDetails", method = RequestMethod.GET)

	public ModelAndView showRecievedLrDetails(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/showAllReceiveLr");

		
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		// get staff id through session
		// TODO
		int toId = officeStaff.getStaffOfficeId();
		try {
			List<GetAllLrDetails> lrDetailsList=new ArrayList<>();
			lrDetailsList=getAllLrDetailsRepository.findAllReceivedLr(toId);
			
			System.out.println("Received Lr"+lrDetailsList.toString());
			model.addObject("lrDetailsList", lrDetailsList);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/receivedLr", method = RequestMethod.GET)

	public @ResponseBody Info receivedLr(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/memoReceived");

		Info info=new Info();
		try {
			String getLrHeaderId=request.getParameter("selectedRowList");
			String getAllLrHeader=getLrHeaderId.substring(1, getLrHeaderId.length()-1);
			
			String[] memoLrId = getAllLrHeader.split(",");
		
			int updateLr=0;
			for(int i=0;i<memoLrId.length;i++) {
				System.out.println(memoLrId[i]);
				if(memoLrId[i]!=null && memoLrId[i]!="") {
				int lrHeaderId=Integer.parseInt(memoLrId[i]);
				updateLr=transactionLrHeaderRepository.lrReceive(lrHeaderId);
					
			
			
			if(updateLr==1) {
				TransactionLrHeader res = transactionLrHeaderRepository.findByLrHeaderId(lrHeaderId);
				ClientDetails	clientDetails = clientDetailsRepository.findByClientId(res.getConsignor());
				
				SMSSender.send(clientDetails.getClientContactNo(),"Delivered Successfully");
				info.setMessage("Lr Received");
			}else {
				info.setMessage("something went wrong");
			}
			}
			}
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return info;

	}
	
}
