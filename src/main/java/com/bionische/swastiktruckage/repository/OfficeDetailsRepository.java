package com.bionische.swastiktruckage.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.OfficeDetails;

public interface OfficeDetailsRepository extends JpaRepository<OfficeDetails, Integer>{
	
	OfficeDetails save(OfficeDetails officeDetails);
	
	OfficeDetails findByOfficeId(int officeId);
	
	List<OfficeDetails> findByIsUsed(boolean isUsed);
	
	@Transactional
	@Modifying
	@Query("UPDATE OfficeDetails o SET o.isUsed=false  WHERE o.officeId=:officeId")
	int removeOfficeByOfficeId(@Param("officeId") int officeId);

}
