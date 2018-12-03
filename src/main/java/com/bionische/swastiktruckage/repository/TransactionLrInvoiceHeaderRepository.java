package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceHeader;

public interface TransactionLrInvoiceHeaderRepository extends JpaRepository<TransactionLrInvoiceHeader, Integer>{
	
	TransactionLrInvoiceHeader save(TransactionLrInvoiceHeader transactionLrInvoiceHeader);

}
