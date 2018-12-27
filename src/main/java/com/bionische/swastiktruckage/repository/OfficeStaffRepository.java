package com.bionische.swastiktruckage.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.OfficeStaff;

public interface OfficeStaffRepository extends JpaRepository<OfficeStaff, Integer>{
	
	OfficeStaff save(OfficeStaff officeStaff);
	
	OfficeStaff findByStaffId(int staffId);
	
	@Transactional
	@Modifying
	@Query("UPDATE OfficeStaff s SET s.isUsed=false  WHERE s.staffId=:staffId")
	int removeStaffByStaffId(@Param("staffId") int staffId);
	
	OfficeStaff findByStaffContactNoAndPassword(String contactNo,String password);
	
	OfficeStaff findByStaffContactNo(String contactNo);
	
	List<OfficeStaff> findByIsUsed(boolean isUsed);
	
}
