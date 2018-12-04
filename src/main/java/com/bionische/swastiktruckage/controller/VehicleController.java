package com.bionische.swastiktruckage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.mastermodel.VehicleDetailsWithOwnerName;
import com.bionische.swastiktruckage.mastermodel.VehicleDriverWithVehNo;
import com.bionische.swastiktruckage.mastermodel.VehicleOwners;
import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;
import com.bionische.swastiktruckage.repository.VehicleDriverWithVehNoRepository;
import com.bionische.swastiktruckage.repository.VehiclesDriversRepository;
import com.bionische.swastiktruckage.service.VehicleService;

@Controller
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleDriverWithVehNoRepository vehicleDriverWithVehNoRepository;
	
	@Autowired
	VehiclesDriversRepository vehiclesDriversRepository;

	private static final Logger logger = LoggerFactory.getLogger(MasterController.class);
	public String message;	

	@RequestMapping(value="/showVehicleOwnerReg", method=RequestMethod.GET)

	public ModelAndView showVehicleOwnerReg(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/vehicleOwnerRegistration");
			

		model.addObject("message",message);
		message="";
		return model;
		
	}	
	
	@RequestMapping(value = "/insertVehicleOwnerInfo", method = RequestMethod.POST)
	public String insertVehicleOwnerInfo(HttpServletRequest request, HttpServletResponse response) {
		
		
		String url ="redirect:/showVehicleOwnerReg";
		
		VehicleOwners vehicleOwners = new VehicleOwners();
		
		String ownerId = request.getParameter("ownerId");
	    if(ownerId!=null)	
	    {
	    	vehicleOwners.setOwnerId(Integer.parseInt(ownerId));
	    	url ="redirect:/showAllVehicleOwnerDetails";
	    }
	    
	    vehicleOwners.setOwnerName(request.getParameter("ownerName"));
	  
	    vehicleOwners.setOwnerContactNo(request.getParameter("contactNo"));
	    
		vehicleOwners.setUsed(true);
		
		Info info = vehicleService.insertVehicleOwners(vehicleOwners);
		
		if(info.isError())
		{
			message = "Failed";
		}
		else
		{
			message = "Successfull";
		}

		return url;

	}
	
	@RequestMapping(value="/showAllVehicleOwnerDetails", method=RequestMethod.GET)

	public ModelAndView showAllVehicleOwnerDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/showAllVehicleOwners");
		List<VehicleOwners> vehicleOwners = vehicleService.getVehicleOwnersByStatus();
		
		model.addObject("message",message);
		model.addObject("vehicleOwners",vehicleOwners);
		message="";
		return model;
		
	}	
	
	@RequestMapping(value="/showEditVehicleOwnertDetails/{ownerId}", method=RequestMethod.GET)

	public ModelAndView showEditVehicleOwnertDetails(@PathVariable("ownerId") int ownerId,HttpServletRequest request)   
	{
			
		ModelAndView model=new ModelAndView("vehicle/editVehicleOwnerDetails");
		
		VehicleOwners vehicleOwner = vehicleService.getVehicleOwnerByOwnerId(ownerId);
		
		model.addObject("vehicleOwner",vehicleOwner);
		return model;
		
	}	
	
	@RequestMapping(value="/deleteVehicleOwnerById", method=RequestMethod.GET)

	public @ResponseBody Info deleteVehicleOwnerById(HttpServletRequest request)   
	{
	    int ownerId = Integer.parseInt(request.getParameter("ownerId")); 		
		Info info = vehicleService.deleteVehicleOwnerById(ownerId);
			
		return info;
		
	}	
	
	@RequestMapping(value="/showVehicleReg", method=RequestMethod.GET)

	public ModelAndView showVehicleReg(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/vehicleRegistration");
		List<VehicleOwners> vehicleOwners = vehicleService.getVehicleOwnersByStatus();
		
		model.addObject("message",message);
		model.addObject("vehicleOwners",vehicleOwners);
		message="";
		return model;
		
	}	
	
	@RequestMapping(value = "/insertVehicleInfo", method = RequestMethod.POST)
	public String insertVehicleInfo(HttpServletRequest request, HttpServletResponse response) {
		
		
		String url ="redirect:/showVehicleReg";
		
		VehicleDetails vehicleDetails = new VehicleDetails();
		
		String vehicleId = request.getParameter("vehicleId");
	    if(vehicleId!=null)	
	    {
	    	vehicleDetails.setVehId(Integer.parseInt(vehicleId));
	    	url ="redirect:/showAllVehicleDetails";
	    }
	    
	    vehicleDetails.setVehNo(request.getParameter("vehicleNo"));
	  
	    vehicleDetails.setOwnerId(Integer.parseInt(request.getParameter("ownerId")));
	    
	    vehicleDetails.setUsed(true);
		
		Info info = vehicleService.insertVehicleDetails(vehicleDetails);
		
		if(info.isError())
		{
			message = "Failed";
		}
		else
		{
			message = "Successfull";
		}

		return url;

	}
	
	@RequestMapping(value="/showAllVehicleDetails", method=RequestMethod.GET)

	public ModelAndView showAllVehicleDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/showAllVehicles");
		List<VehicleDetailsWithOwnerName> vehiclsList = vehicleService.getAllVehicleDetailsByStatus();
		System.out.println("alll:"+vehiclsList.toString());
		
		model.addObject("message",message);
		model.addObject("vehiclsList",vehiclsList);
		message="";
		return model;
		
	}	
	
	@RequestMapping(value="/showEditVehicleDetails/{vehId}", method=RequestMethod.GET)

	public ModelAndView showEditVehicleDetails(@PathVariable("vehId") int vehId,HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/editVehicleDetails");
		
		List<VehicleOwners> vehicleOwners = vehicleService.getVehicleOwnersByStatus();
		VehicleDetails vehicleDetails = vehicleService.getVehicleDetailsById(vehId);
		
		model.addObject("vehicleOwners",vehicleOwners);
		model.addObject("vehicleDetails",vehicleDetails);
		
		return model;

	}
	
	@RequestMapping(value="/deleteVehicleById", method=RequestMethod.POST)

	public @ResponseBody Info deleteVehicleById(HttpServletRequest request)   
	{
			
		int vehId = Integer.parseInt(request.getParameter("vehId"));
	
		System.out.println("vehId:"+vehId);
		Info info = vehicleService.deleteVehicleById(vehId);
		
		
		return info;
		
	}
	
	@RequestMapping(value="/showVehicleDriverReg", method=RequestMethod.GET)

	public ModelAndView showVehicleDriverReg(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/vehicleDriverRegistration");
		List<VehicleDetails> vehiclsList = vehicleService.getVehicleDetailsByStatus();
		
		model.addObject("vehiclsList",vehiclsList);
		model.addObject("message",message);
		message="";
		
		return model;
		
	}	
	
	@RequestMapping(value = "/insertVehicleDriverInfo", method = RequestMethod.POST)
	public String insertVehicleDriverInfo(HttpServletRequest request, HttpServletResponse response) {
		
		
		String url ="redirect:/showVehicleDriverReg";
		
		VehiclesDrivers vehiclesDrivers = new VehiclesDrivers();
		
		String driverId = request.getParameter("driverId");
	    if(driverId!=null)	
	    {
	    	vehiclesDrivers.setDriverId(Integer.parseInt(driverId));
	    	url ="redirect:/showAllVehicleDriverDetails";
	    }
	    
	    vehiclesDrivers.setDriverName(request.getParameter("name"));
	  
	    vehiclesDrivers.setDriverContactNo(request.getParameter("contactNo"));
	    vehiclesDrivers.setVehId(Integer.parseInt(request.getParameter("vehId")));
	    vehiclesDrivers.setDriverLicenseNo(Integer.parseInt(request.getParameter("licenseNo")));
	    
	    vehiclesDrivers.setUsed(true);
		
		Info info = vehicleService.insertVehicleDrivers(vehiclesDrivers);
		
		if(info.isError())
		{
			message = "Failed";
		}
		else
		{
			message = "Successfull";
		}

		return url;

	}
	
	@RequestMapping(value="/showAllVehicleDriverDetails", method=RequestMethod.GET)

	public ModelAndView showAllVehicleDriverDetails(HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/showAllVehicleDrivers");
		List<VehicleDriverWithVehNo> vehicleDricerList = vehicleDriverWithVehNoRepository.getAllVehicleDriverDetails(1);
			
		model.addObject("message",message);
		model.addObject("vehicleDricerList",vehicleDricerList);
		message="";
		return model;
		
	}	
	
	@RequestMapping(value="/showEditDriverDetails/{driverId}", method=RequestMethod.GET)

	public ModelAndView showEditDriverDetails(@PathVariable("driverId") int driverId,HttpServletRequest request)   
	{
		ModelAndView model=new ModelAndView("vehicle/editVehicleDriverDetails");
		
		VehiclesDrivers vehiclesDrivers = vehiclesDriversRepository.findByDriverId(driverId);
		List<VehicleDetails> vehicleDetails = vehicleService.getVehicleDetailsByStatus();
		
		model.addObject("vehiclesDrivers",vehiclesDrivers);
		model.addObject("vehicleDetails",vehicleDetails);
		
		return model;

	}
	
	@RequestMapping(value="/deleteDriverById", method=RequestMethod.GET)

	public @ResponseBody Info deleteDriverById(HttpServletRequest request)   
	{
		int driverId = Integer.parseInt(request.getParameter("driverId")); 	
		System.out.println("driverId:"+driverId);
		Info info = new Info();
		try
		{
		int  res = vehiclesDriversRepository.deleteDriverById(driverId);
		 
		 if(res>0)
			{
				info.setError(false);
				info.setMessage("success");
				
			}
			else
			{
				info.setError(true);
				info.setMessage("failed");
				
			}

		}
       catch (Exception e) {
			
    	   logger.error("Error while deleteDriverById.",e);
			throw new RuntimeException("Error while deleteDriverById.",e);
		}
				
		return info;

	}
}