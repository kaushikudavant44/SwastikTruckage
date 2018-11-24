package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.OfficeDetails;

public interface OfficeDetailsRepository extends JpaRepository<OfficeDetails, Integer>{
	
	OfficeDetails save(OfficeDetails officeDetails);
	
	OfficeDetails findByOfficeId(int officeId);
	
	

}
