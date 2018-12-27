package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.VehicleOwners;

public interface VehicleOwnersRepository extends JpaRepository<VehicleOwners, Integer>{
	
	VehicleOwners save(VehicleOwners vehicleOwners);
	
	List<VehicleOwners> findByIsUsed(boolean status);

	VehicleOwners findByOwnerId(int ownerId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM VehicleOwners where ownerId=:ownerId")
	int deleteOwnerById(@Param("ownerId")int ownerId);
	
	@Query(value="SELECT o.* FROM m_vehicle_owners o, m_vehicles v WHERE v.veh_id=:vehId AND v.owner_id=o.owner_id AND o.is_used=TRUE" ,nativeQuery=true)
	VehicleOwners findByVehId(@Param("vehId")int vehId);
}
