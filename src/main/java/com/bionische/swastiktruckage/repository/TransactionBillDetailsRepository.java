package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.StaffRoles;
import com.bionische.swastiktruckage.mastermodel.TransactionBillDetails;

public interface TransactionBillDetailsRepository extends JpaRepository<TransactionBillDetails, Integer>{
	
	TransactionBillDetails save(TransactionBillDetails transactionBillDetails);
	
	List<TransactionBillDetails> findByBillHeaderId(int billHeaderId);

}
