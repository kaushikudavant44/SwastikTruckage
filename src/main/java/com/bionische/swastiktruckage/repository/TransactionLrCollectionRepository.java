package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.TransactionLrCollection;


public interface TransactionLrCollectionRepository extends JpaRepository<TransactionLrCollection, Integer>{
	
	TransactionLrCollection save(TransactionLrCollection transactionLrCollection);

}
