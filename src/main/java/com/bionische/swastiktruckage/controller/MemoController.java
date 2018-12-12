package com.bionische.swastiktruckage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
import com.bionische.swastiktruckage.repository.GetAllLrDetailsRepository;
import com.bionische.swastiktruckage.repository.MemoDetailsRepository;
import com.bionische.swastiktruckage.repository.MemoHeaderRepository;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.repository.OfficeStaffRepository;
import com.bionische.swastiktruckage.repository.TransactionLrHeaderRepository;
import com.bionische.swastiktruckage.repository.VehicleDetailsRepository;
import com.bionische.swastiktruckage.repository.VehicleOwnersRepository;
import com.bionische.swastiktruckage.repository.VehiclesDriversRepository;

@Controller
public class MemoController {

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
			
			memoHeader.setUsed(true);
			MemoHeader memoHeaderResult=memoHeaderRepository.save(memoHeader);
			
			
			String getMemoHeaderId=request.getParameter("selectedRowList");
			String getAllMemoHeader=getMemoHeaderId.substring(1, getMemoHeaderId.length()-1);
			
			System.out.println(getAllMemoHeader.toString());
			List<MemoDetails> memoDetailsList=new ArrayList<>();
		
			
			String[] memoHeaderId = getAllMemoHeader.split(",");;
			
			for(int i=0;i<memoHeaderId.length;i++) {
			
				
				MemoDetails memoDetails=new MemoDetails();
				memoDetails.setLrHeaderId(Integer.parseInt(memoHeaderId[i]));
				memoDetails.setMemoHeaderId(memoHeaderResult.getMemoHeaderId());
				memoDetails.setLrStatus(0);
				memoDetailsList.add(memoDetails);
					
			}
			System.out.println("memo detail list"+memoDetailsList.toString());
			memoDetailsList=memoDetailsRepository.saveAll(memoDetailsList);
			
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
	
}
