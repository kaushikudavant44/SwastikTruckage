package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.VehicleDetails;


public interface VehicleDetailsRepository extends JpaRepository<VehicleDetails, Integer>{
	
	VehicleDetails save(VehicleDetails vehicleDetails);
	
	List<VehicleDetails> findByIsUsed(boolean status);
	
	VehicleDetails findByVehNoAndIsUsed(int vehNo,boolean status);
	
	VehicleDetails findByVehId(int vehId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM VehicleOwners where vehId=:vehId")
	int deleteVehicleById(@Param("vehId")int vehId);
}
