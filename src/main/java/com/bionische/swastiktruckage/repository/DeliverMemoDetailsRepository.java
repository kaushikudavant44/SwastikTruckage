package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.DeliverMemoDetails;

public interface DeliverMemoDetailsRepository extends JpaRepository<DeliverMemoDetails, Integer>{

	DeliverMemoDetails save(DeliverMemoDetails deliverMemoDetails);
	
}
