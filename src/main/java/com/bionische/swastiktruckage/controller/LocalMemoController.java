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
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.common.DateConverter;
import com.bionische.swastiktruckage.mastermodel.DeliverMemoDetails;
import com.bionische.swastiktruckage.mastermodel.DeliverMemoHeader;
import com.bionische.swastiktruckage.mastermodel.GetAllLrDetails;
import com.bionische.swastiktruckage.mastermodel.GetDeliverMemoHeader;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.MemoHeader;
import com.bionische.swastiktruckage.mastermodel.OfficeStaff;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.mastermodel.VehicleOwners;
import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.DeliverMemoDetailsRepository;
import com.bionische.swastiktruckage.repository.DeliverMemoHeaderRepository;
import com.bionische.swastiktruckage.repository.GetAllLrDetailsRepository;
import com.bionische.swastiktruckage.repository.GetDeliverMemoHeaderRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
import com.bionische.swastiktruckage.repository.VehicleDetailsRepository;
import com.bionische.swastiktruckage.repository.VehicleOwnersRepository;
import com.bionische.swastiktruckage.repository.VehiclesDriversRepository;

@Controller
@SessionScope
public class LocalMemoController {
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;
	
	@Autowired
	VehicleOwnersRepository vehicleOwnersRepository;
	
	@Autowired
	VehiclesDriversRepository vehiclesDriversRepository;
	
	@Autowired
	GetAllLrDetailsRepository getAllLrDetailsRepository;
	
	@Autowired
	OfficeDetailsRepository officeDetailsRepository;
	
	@Autowired
	OfficeStaffRepository officeStaffRepository;
	
	@Autowired
	ClientDetailsRepository clientDetailsRepository;
	
	@Autowired
	DeliverMemoHeaderRepository deliverMemoHeaderRepository;
	
	@Autowired
	DeliverMemoDetailsRepository deliverMemoDetailsRepository;
	
	@Autowired
	GetDeliverMemoHeaderRepository getDeliverMemoHeaderRepository;
	
	@Autowired
	TransactionLrHeaderRepository transactionLrHeaderRepository;
	
	
	@RequestMapping(value = "/showCreateMemo", method = RequestMethod.GET)

	public ModelAndView showCreateMemo(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("localmemo/createMemo");

		try {
			
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			// get staff id through session
			// TODO
			int staffId = officeStaff.getStaffId();
			OfficeStaff staffDetails = new OfficeStaff();
			List<VehiclesDrivers> vehicleDriverList=new ArrayList<>();
			List<VehicleDetails> vehicalDetailsList=new ArrayList<>();
			vehicalDetailsList=vehicleDetailsRepository.findByIsUsed(true);
			staffDetails = officeStaffRepository.findByStaffId(staffId);
			vehicleDriverList=vehiclesDriversRepository.findByIsUsed(true);
			
			
			model.addObject("vehicleDriverList", vehicleDriverList);
			model.addObject("vehicalDetailsList", vehicalDetailsList);
			model.addObject("staffDetails", staffDetails);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	
	@RequestMapping(value = "/getLrDetails", method = RequestMethod.GET)

	public @ResponseBody GetAllLrDetails getLrDetails(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("localmemo/createMemo");
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		// get staff id through session
		// TODO
		int officeId = officeStaff.getStaffOfficeId();
		
		int lrNo=Integer.parseInt(request.getParameter("lrNo"));
		System.out.println("lrNo ="+lrNo);
		GetAllLrDetails getAllLrDetails=new GetAllLrDetails();
		
		try {
			
			getAllLrDetails=getAllLrDetailsRepository.findReceiveLrBylrNoAndOfficeId(lrNo,officeId);

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return getAllLrDetails;

	}
	
	
	@RequestMapping(value = "/saveDeliverMemoDetails", method = RequestMethod.GET)

	public @ResponseBody Info saveDeliverMemoDetails(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("localmemo/createMemo");
		Info info=new Info();
		
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		// get staff id through session
		// TODO
		int officeId = officeStaff.getStaffOfficeId();
		int satffId=officeStaff.getStaffId();
		
		
		
		
		int localMemoNo=0;
		DeliverMemoHeader deliverMemoHeader=new DeliverMemoHeader();
		try {
			DeliverMemoHeader deliverMemoHeaderLastRec=deliverMemoHeaderRepository.findLastRecord();
			
			
			
			if(deliverMemoHeaderLastRec!=null) {
				localMemoNo=deliverMemoHeaderLastRec.getLocalMemoNo();
				localMemoNo++;
			}else {
				localMemoNo=180001;
			}
			
			String memoDate=DateConverter.convertToYMD(request.getParameter("memoDate"));
			try {
			int deliMemoHeaderId=Integer.parseInt(request.getParameter("deliMemoHeaderId"));
			deliverMemoHeader.setDeliMemoHeaderId(deliMemoHeaderId);
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			deliverMemoHeader.setDeliMemoDate(memoDate);
			deliverMemoHeader.setDriverId(Integer.parseInt(request.getParameter("driverId")));
			deliverMemoHeader.setVehicleId(Integer.parseInt(request.getParameter("vehId")));
			deliverMemoHeader.setOfficeId(officeId);
			deliverMemoHeader.setStaffId(satffId);
			deliverMemoHeader.setLocalMemoNo(localMemoNo);
			
			DeliverMemoHeader deliverMemoHeaderRes=deliverMemoHeaderRepository.save(deliverMemoHeader);
			
			DeliverMemoDetails deliverMemoDetails=new DeliverMemoDetails();
			List<DeliverMemoDetails> deliverMemoDetailsList=new ArrayList<>();
			String lrHeaderNo=request.getParameter("selectedLrHeaderId");
			System.out.println("lrHeaderNo"+lrHeaderNo);
			String lrHeaderId=lrHeaderNo.substring(1, lrHeaderNo.length()-1);
			
			String[] lrHeaderNumbers = lrHeaderId.split(",");
			
			if(deliverMemoHeaderRes!=null) {
				
				for(int i=0;i<lrHeaderNumbers.length;i++) {
				
				deliverMemoDetails.setDeliMemoHeaderId(deliverMemoHeaderRes.getDeliMemoHeaderId());
				deliverMemoDetails.setDeliveryStatus(0);
				deliverMemoDetails.setDeliveryremark(0);
				deliverMemoDetails.setLrHeaderId(Integer.parseInt(lrHeaderNumbers[i]));
				deliverMemoDetailsList.add(deliverMemoDetails);
			}
			}
			deliverMemoDetailsList=deliverMemoDetailsRepository.saveAll(deliverMemoDetailsList);
			
			
			
			if(deliverMemoDetailsList.isEmpty()) {
				info.setMessage("Something Went wrong! Try agin");
			}else {
				for(int i=0;i<lrHeaderNumbers.length;i++) {
					
					
					int deliveryStatus=transactionLrHeaderRepository.updateLrLocalDeliveryStatusByHeaderId(Integer.parseInt(lrHeaderNumbers[i]));
				
				}
				
				info.setMessage(""+deliverMemoHeaderRes.getDeliMemoHeaderId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;

	}
	
	@RequestMapping(value = "/getVehicalOwner", method = RequestMethod.GET)
	public @ResponseBody VehicleOwners getVehicalOwner(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("memo/generateMemo");
		VehicleOwners vehicleOwners = new VehicleOwners();

		int vehId = Integer.parseInt(request.getParameter("vehId"));
		
		try {
		
			vehicleOwners=vehicleOwnersRepository.findByVehId(vehId);
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return vehicleOwners;

	}
	
	
	@RequestMapping(value = "/showAllLocalMemo", method = RequestMethod.GET)

	public ModelAndView showAllLocalMemo(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("localmemo/showCreatedMemo");
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		int officeId=officeStaff.getStaffOfficeId();
		try {
			List<GetDeliverMemoHeader> getDeliverMemoHeaderList=new ArrayList<>();
			
			getDeliverMemoHeaderList=getDeliverMemoHeaderRepository.findAllMemoByOfficeId(officeId);
			
			model.addObject("getDeliverMemoHeaderList", getDeliverMemoHeaderList);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/deleteLocalMemo/{deliMemoHeaderId}", method = RequestMethod.GET)

	public String deleteLocalMemo(HttpServletRequest request,@PathVariable int deliMemoHeaderId) {
		ModelAndView model = new ModelAndView("localmemo/showCreatedMemo");

			MemoHeader memoHeader=new MemoHeader();
		
			
		try {
			int isUsed=deliverMemoHeaderRepository.updateLocalMemoByMemoHeaderId(deliMemoHeaderId);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "redirect:/showAllLocalMemo";

	}
	
	
	@RequestMapping(value = "/showEditLocalMemoDetails/{deliMemoHeaderId}", method = RequestMethod.GET)

	public ModelAndView showEditLocalMemoDetails(HttpServletRequest request,@PathVariable int deliMemoHeaderId) {
		ModelAndView model = new ModelAndView("localmemo/editLocalMemo");

		try {
			
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			int officeId=officeStaff.getStaffOfficeId();
			OfficeStaff staffDetails = new OfficeStaff();
			int staffId=officeStaff.getStaffId();
			List<VehiclesDrivers> vehicleDriverList=new ArrayList<>();
			List<VehicleDetails> vehicalDetailsList=new ArrayList<>();
			vehicalDetailsList=vehicleDetailsRepository.findByIsUsed(true);
			staffDetails = officeStaffRepository.findByStaffId(staffId);
			vehicleDriverList=vehiclesDriversRepository.findByIsUsed(true);
			GetDeliverMemoHeader getDeliverMemoHeader=getDeliverMemoHeaderRepository.findLocalMemoDetailsByOfficeIdAnddeliMemoHeaderId(officeId,deliMemoHeaderId);
			getDeliverMemoHeader.setDeliMemoDate(DateConverter.convertToDMY(getDeliverMemoHeader.getDeliMemoDate())); 
			VehicleOwners vehicleOwners=vehicleOwnersRepository.findByVehId(getDeliverMemoHeader.getVehicleId());
			
			System.out.println("Memo Details"+getDeliverMemoHeader.toString());
			if(getDeliverMemoHeader!=null) {
				
				List<GetAllLrDetails> getAllDeliverLrDetailsList=getAllLrDetailsRepository.getAllLocalMemoLrByDeliMemoHeaderId(getDeliverMemoHeader.getDeliMemoHeaderId());
				model.addObject("getAllDeliverLrDetailsList", getAllDeliverLrDetailsList);
				System.out.println("Lr "+getAllDeliverLrDetailsList.toString());
			}
			model.addObject("getDeliverMemoHeader", getDeliverMemoHeader);
			model.addObject("vehicleDriverList", vehicleDriverList);
			model.addObject("vehicalDetailsList", vehicalDetailsList);
			model.addObject("staffDetails", staffDetails);
			model.addObject("vehicleOwners", vehicleOwners);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	
	@RequestMapping(value = "/updateLrDetails", method = RequestMethod.GET)
	public @ResponseBody Info updateLrDetails(HttpServletRequest request) {
		
		int lrHeaderId = Integer.parseInt(request.getParameter("lrHeaderId"));
		Info info=new Info();
		try {
		
			int updateDeliveryStatus=transactionLrHeaderRepository.updateLrRecDeliveryStatusByHeaderId(lrHeaderId);
		
			if(updateDeliveryStatus==1) {
				info.setMessage("Update Successful");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;

	}
	
	
	@RequestMapping(value = "/showLrReturn", method = RequestMethod.GET)

	public ModelAndView showMemoReceived(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/showReturnLr");

		try {
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	@RequestMapping(value = "/getReturnLrDetails", method = RequestMethod.GET)

	public @ResponseBody GetAllLrDetails getReturnLrDetails(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("localmemo/createMemo");
		HttpSession session = request.getSession();
		OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
		// get staff id through session
		// TODO
		int officeId = officeStaff.getStaffOfficeId();
		
		int lrNo=Integer.parseInt(request.getParameter("lrNo"));
		System.out.println("lrNo ="+lrNo);
		GetAllLrDetails getAllLrDetails=new GetAllLrDetails();
		
		try {
			
			getAllLrDetails=getAllLrDetailsRepository.findReturnLrBylrNoAndOfficeId(lrNo,officeId);
			System.out.println(getAllLrDetails.toString());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return getAllLrDetails;

	}
	
	
	@RequestMapping(value = "/localMemoPreview/{deliMemoHeaderId}", method = RequestMethod.GET)

	public ModelAndView memoPreview(HttpServletRequest request, @PathVariable int deliMemoHeaderId) {
		ModelAndView model = new ModelAndView("localmemo/localMemoPreview");

		
		try {
			HttpSession session = request.getSession();
			OfficeStaff officeStaff=(OfficeStaff) session.getAttribute("staffDetails");
			int officeId=officeStaff.getStaffOfficeId();
			OfficeStaff staffDetails = new OfficeStaff();
			int staffId=officeStaff.getStaffId();
			GetDeliverMemoHeader getDeliverMemoHeader=getDeliverMemoHeaderRepository.findLocalMemoDetailsByOfficeIdAnddeliMemoHeaderId(officeId,deliMemoHeaderId);
			getDeliverMemoHeader.setDeliMemoDate(DateConverter.convertToDMY(getDeliverMemoHeader.getDeliMemoDate())); 
			if(getDeliverMemoHeader!=null) {
				
				List<GetAllLrDetails> getAllDeliverLrDetailsList=getAllLrDetailsRepository.getAllLocalMemoLrByDeliMemoHeaderId(getDeliverMemoHeader.getDeliMemoHeaderId());
				model.addObject("getAllDeliverLrDetailsList", getAllDeliverLrDetailsList);
				System.out.println("Lr "+getAllDeliverLrDetailsList.toString());
			}
			System.out.println("getDeliverMemoHeader"+getDeliverMemoHeader.toString());
			model.addObject("getDeliverMemoHeader", getDeliverMemoHeader);
		
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;

	}
	
	
	@RequestMapping(value = "/updateReturnLrDeliveryStatus", method = RequestMethod.GET)

	public @ResponseBody Info updateReturnLrDeliveryStatus(HttpServletRequest request) {
		ModelAndView model = new ModelAndView("transaction/showReturnLr");
		Info info=new Info();
		
		
		System.out.println("Inside Update LR status");

		try {
			
			String lrHeader=request.getParameter("selectedLrHeaderId");
		
			String str=lrHeader.substring(1, lrHeader.length()-1);
			
			String[] lrHeaderId=str.split(",");
			
			for(int i=0;i<lrHeaderId.length;i++) {
			
				int lrId=Integer.parseInt(lrHeaderId[i]);
				
				int updateDeliveryStatus=transactionLrHeaderRepository.updateLrRecDeliveryStatusByHeaderId(Integer.parseInt(lrHeaderId[i]));
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return info;

	}

}
