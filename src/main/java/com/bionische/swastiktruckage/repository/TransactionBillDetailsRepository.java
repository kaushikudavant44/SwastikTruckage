package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.StaffRoles;
import com.bionische.swastiktruckage.mastermodel.TransactionBillDetails;

public interface TransactionBillDetailsRepository extends JpaRepository<TransactionBillDetails, Integer>{
	
	TransactionBillDetails save(TransactionBillDetails transactionBillDetails);

}
