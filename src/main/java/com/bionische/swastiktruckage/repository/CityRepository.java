package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	List<City> findByStateId(int stateId);

}
