package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.VehicleOwners;

public interface VehicleOwnersRepository extends JpaRepository<VehicleOwners, Integer>{
	
	VehicleOwners save(VehicleOwners vehicleOwners);
	
	List<VehicleOwners> findByIsUsed(int status);

}
