package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.ClientDetails;

public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Integer>{
	
	ClientDetails save(ClientDetails clientDetails);

}
