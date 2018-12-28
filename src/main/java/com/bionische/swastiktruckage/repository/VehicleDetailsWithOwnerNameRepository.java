package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.VehicleDetailsWithOwnerName;

public interface VehicleDetailsWithOwnerNameRepository extends JpaRepository<VehicleDetailsWithOwnerName, Integer>{

	@Query(value="SELECT v.veh_id,v.owner_id,v.veh_no,v.is_used,o.owner_name FROM m_vehicles v,m_vehicle_owners o WHERE v.is_used=:status "
			+ "AND v.owner_id=o.owner_id" ,nativeQuery=true)
	List<VehicleDetailsWithOwnerName> getAllVehicleDetails(@Param("status")int status);
}
