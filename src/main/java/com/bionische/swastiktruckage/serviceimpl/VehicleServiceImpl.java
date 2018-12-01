package com.bionische.swastiktruckage.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.mastermodel.VehicleDetailsWithOwnerName;
import com.bionische.swastiktruckage.mastermodel.VehicleOwners;
import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;
import com.bionische.swastiktruckage.repository.VehicleDetailsRepository;
import com.bionische.swastiktruckage.repository.VehicleDetailsWithOwnerNameRepository;
import com.bionische.swastiktruckage.repository.VehicleOwnersRepository;
import com.bionische.swastiktruckage.repository.VehiclesDriversRepository;
import com.bionische.swastiktruckage.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService{

	@Autowired
	VehicleOwnersRepository vehicleOwnersRepository;
	
	@Autowired
	VehicleDetailsRepository vehicleDetailsRepository;
	
	@Autowired
	VehiclesDriversRepository vehiclesDriversRepository;
	
	@Autowired
	VehicleDetailsWithOwnerNameRepository vehicleDetailsWithOwnerNameRepository;
	
	@Override
	public Info insertVehicleOwners(VehicleOwners vehicleOwners)
	{
		Info info = new Info();
		try
		{
			VehicleOwners res = vehicleOwnersRepository.save(vehicleOwners);
		
		
		if(res!=null)
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
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return info;
		
	}
	
	@Override
	public List<VehicleOwners> getVehicleOwnersByStatus()
	{
		List<VehicleOwners> res = new ArrayList<VehicleOwners>();
		try
		{
			res = vehicleOwnersRepository.findByIsUsed(true);		
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
	}
	
	@Override
	public Info insertVehicleDetails(VehicleDetails vehicleDetails)
	{
		Info info = new Info();
		try
		{
			VehicleDetails res = vehicleDetailsRepository.save(vehicleDetails);
		
		
		if(res!=null)
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
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return info;
		
	}
	
	@Override
	public List<VehicleDetails> getVehicleDetailsByStatus()
	{
		List<VehicleDetails> res= new ArrayList<VehicleDetails>(); 
		
		try
		{
			 res = vehicleDetailsRepository.findByIsUsed(true);
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
		
	}
	
	@Override
	public VehicleDetails getVehicleDetailsByVehNoAndStatus(int vehNo)
	{
		VehicleDetails res= new VehicleDetails(); 
		
		try
		{
			 res = vehicleDetailsRepository.findByVehNoAndIsUsed(vehNo, true);
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
		
	}
	
	@Override
	public Info insertVehicleDrivers(VehiclesDrivers vehiclesDrivers)
	{
		Info info = new Info();
		try
		{
			VehiclesDrivers res = vehiclesDriversRepository.save(vehiclesDrivers);
		
		
		if(res!=null)
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
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return info;
		
	}
	
	@Override
	public List<VehiclesDrivers> getVehicleDriversByName(String driverName)
	{
		List<VehiclesDrivers> res = new ArrayList<VehiclesDrivers>();
		try
		{
			 res = vehiclesDriversRepository.findByDriverName(driverName);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
		
	}
	@Override
	public VehicleOwners getVehicleOwnerByOwnerId(int ownerId)
	{
	   VehicleOwners res = new VehicleOwners();
		try
		{
			res = vehicleOwnersRepository.findByOwnerId(ownerId);		
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
	}
	
	@Override
	public Info deleteVehicleOwnerById(int ownerId)
	{
		Info info = new Info();
	try
	{
		int res = vehicleOwnersRepository.deleteOwnerById(ownerId);	
	
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
	catch(Exception e)
	{
		System.out.println(e.getMessage());
	}
	
	return info;	
}

	@Override
	public List<VehicleDetailsWithOwnerName> getAllVehicleDetailsByStatus()
	{
		List<VehicleDetailsWithOwnerName> res= new ArrayList<VehicleDetailsWithOwnerName>(); 
		
		try
		{
			 res = vehicleDetailsWithOwnerNameRepository.getAllVehicleDetails(1);
		     System.out.println("alllllll:"+res);
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
		
	}
	
	@Override
	public VehicleDetails getVehicleDetailsById(int vehId)
	{
       VehicleDetails res= new VehicleDetails(); 
		
		try
		{
			 res = vehicleDetailsRepository.findByVehId(vehId);
		
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
	}
	
	@Override
	public Info deleteVehicleById(int vehId)
	{
		Info info = new Info();
		try
		{
			int res = vehicleDetailsRepository.deleteVehicleById(vehId);
		
		
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
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return info;
		
	}
	
}
