package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.TransactionLrInvoiceDetail;

public interface TransactionLrInvoiceDetailRepository extends JpaRepository<TransactionLrInvoiceDetail, Integer>{
	
	List<TransactionLrInvoiceDetail> findByInvHeaderId(int invId);
	
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM TransactionLrInvoiceDetail WHERE detailId=:detailId")
	int deleteByDetailId(@Param("detailId")int detailId);

}
