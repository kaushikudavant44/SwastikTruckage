package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.TransactionBillPayments;

public interface TransactionBillPaymentsRepository  extends JpaRepository<TransactionBillPayments, Integer>{
	
	TransactionBillPayments save(TransactionBillPayments transactionBillPayments);
	
	List<TransactionBillPayments> findByBillHeaderId(int billHeaderId);

}
