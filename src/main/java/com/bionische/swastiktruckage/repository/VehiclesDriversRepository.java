package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.VehiclesDrivers;

public interface VehiclesDriversRepository extends JpaRepository<VehiclesDrivers, Integer>{
	
	VehiclesDrivers save(VehiclesDrivers vehiclesDrivers);
	
	List<VehiclesDrivers> findByDriverName(String driverName);

}
