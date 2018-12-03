package com.bionische.swastiktruckage.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.TransactionLrContaintDetails;


public interface TransactionLrContaintDetailsRepository extends JpaRepository<TransactionLrContaintDetails, Integer>{

//	List<TransactionLrContaintDetails> saveAll(List<TransactionLrContaintDetails> transactionLrContaintDetailsList);
 	
}
