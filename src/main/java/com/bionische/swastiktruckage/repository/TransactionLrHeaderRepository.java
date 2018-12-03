package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;

public interface TransactionLrHeaderRepository extends JpaRepository<TransactionLrHeader, Integer>{
	
	
	@Query(value="SELECT lr_id FROM t_lr_header ORDER BY lr_header_id DESC LIMIT 1",nativeQuery=true)
	int findLastRecord();
	
	TransactionLrHeader save(TransactionLrHeader transactionLrHeader);

}
