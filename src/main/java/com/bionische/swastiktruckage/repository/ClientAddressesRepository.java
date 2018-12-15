package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.ClientAddresses;


public interface ClientAddressesRepository extends JpaRepository<ClientAddresses, Integer>{
	
	ClientAddresses save(ClientAddresses clientAddresses);
	
	ClientAddresses findByClientId(int clientId);

}
