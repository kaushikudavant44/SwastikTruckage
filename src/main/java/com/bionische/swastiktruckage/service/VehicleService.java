package com.bionische.swastiktruckage.service;

import java.util.List;

import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.mastermodel.VehicleDetails;
import com.bionische.swastiktruckage.mastermodel.VehicleOwners;
import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;

public interface VehicleService {
	
	Info insertVehicleOwners(VehicleOwners vehicleOwners);
	
	List<VehicleOwners> getVehicleOwnersByStatus();
	
	Info insertVehicleDetails(VehicleDetails vehicleDetails);
	
	List<VehicleDetails> getVehicleDetailsByStatus();
	
	VehicleDetails getVehicleDetailsByVehNoAndStatus(int vehNo);
	
	Info insertVehicleDrivers(VehiclesDrivers vehiclesDrivers);
	
	List<VehiclesDrivers> getVehicleDriversByName(String driverName);

}
