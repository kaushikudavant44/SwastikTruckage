package com.bionische.swastiktruckage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.mastermodel.VehicleOwners;
import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;
import com.bionische.swastiktruckage.repository.VehicleDetailsRepository;
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
			res = vehicleOwnersRepository.findByIsUsed(1);		
			
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
			 res = vehicleDetailsRepository.findByIsUsed(1);
		
		
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
			 res = vehicleDetailsRepository.findByVehNoAndIsUsed(vehNo, 1);
		
		
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

}
