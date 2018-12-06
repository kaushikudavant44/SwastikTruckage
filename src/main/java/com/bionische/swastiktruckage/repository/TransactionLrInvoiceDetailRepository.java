package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceDetail;

public interface TransactionLrInvoiceDetailRepository extends JpaRepository<TransactionLrInvoiceDetail, Integer>{
	
	List<TransactionLrInvoiceDetail> findByInvHeaderId(int invId);

}
