package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.TransactionLrContaintDetails;


public interface TransactionLrContaintDetailsRepository extends JpaRepository<TransactionLrContaintDetails, Integer>{

//	List<TransactionLrContaintDetails> saveAll(List<TransactionLrContaintDetails> transactionLrContaintDetailsList);
 	
	@Transactional
	@Modifying
	@Query("DELETE FROM TransactionLrContaintDetails where detailId=:detailId")
	int deleteByDetailId(@Param("detailId")int detailId);
}
