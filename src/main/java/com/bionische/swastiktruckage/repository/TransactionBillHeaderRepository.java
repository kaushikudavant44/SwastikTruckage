package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;

public interface TransactionBillHeaderRepository extends JpaRepository<TransactionBillHeader, Integer>{
	
	TransactionBillHeader save(TransactionBillHeader transactionBillHeader);
	
	List<TransactionBillHeader> findAll();

}
