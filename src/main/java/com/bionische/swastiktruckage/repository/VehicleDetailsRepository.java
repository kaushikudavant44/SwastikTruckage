package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.VehicleDetails;


public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer>{
	
	VehicleDetails save(VehicleDetails vehicleDetails);
	
	List<VehicleDetails> findByIsUsed(int status);
	
	VehicleDetails findByVehNoAndIsUsed(int vehNo,int status);
	
}
