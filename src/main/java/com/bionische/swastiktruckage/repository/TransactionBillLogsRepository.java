package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.TransactionBillLogs;

public interface TransactionBillLogsRepository  extends JpaRepository<TransactionBillLogs, Integer>{
	
	TransactionBillLogs save(TransactionBillLogs transactionBillLogs);
	

}
