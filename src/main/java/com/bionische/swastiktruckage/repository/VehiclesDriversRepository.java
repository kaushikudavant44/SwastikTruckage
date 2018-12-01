package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;

public interface VehiclesDriversRepository extends JpaRepository<VehiclesDrivers, Integer>{
	
	VehiclesDrivers save(VehiclesDrivers vehiclesDrivers);
	
	List<VehiclesDrivers> findByDriverName(String driverName);

	VehiclesDrivers findByDriverId(int driverId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM VehiclesDrivers where driverId=:driverId")
	int deleteDriverById(@Param("driverId")int driverId);
}
