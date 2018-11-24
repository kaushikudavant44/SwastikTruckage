package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.OfficeStaff;

public interface OfficeStaffRepository extends JpaRepository<OfficeStaff, Integer>{
	
	OfficeStaff save(OfficeStaff officeStaff);
	
	OfficeStaff findByStaffId(int staffId);
	
}
