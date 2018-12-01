package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.ClientDetails;

public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Integer>{
	
	ClientDetails save(ClientDetails clientDetails);
	
	ClientDetails findByClientId(int clientId);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM ClientDetails where clientId=:clientId")
	int deleteClientById(@Param("clientId")int clientId);
	

}
