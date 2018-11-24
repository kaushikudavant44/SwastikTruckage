package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.CompanyDetails;

public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer>{

	
	CompanyDetails save(CompanyDetails companyDetails);
	
	CompanyDetails findByCompanyId(int companyId);
	
}
