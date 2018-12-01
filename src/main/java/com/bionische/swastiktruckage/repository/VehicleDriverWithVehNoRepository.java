package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.VehicleDetailsWithOwnerName;
import com.bionische.swastiktruckage.mastermodel.VehicleDriverWithVehNo;

public interface VehicleDriverWithVehNoRepository extends JpaRepository<VehicleDriverWithVehNo, Integer>{

	@Query(value="SELECT d.driver_id,d.driver_contact_no,d.driver_license_no,d.driver_name,d.veh_id,d.is_used,v.veh_no FROM "
			+ "m_vehicles_drivers d,m_vehicles v WHERE d.is_used=:status AND d.veh_id=v.veh_id" ,nativeQuery=true)
	List<VehicleDriverWithVehNo> getAllVehicleDriverDetails(@Param("status")int status);

}
