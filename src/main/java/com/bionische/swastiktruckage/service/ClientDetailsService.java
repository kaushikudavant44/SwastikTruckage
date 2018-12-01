package com.bionische.swastiktruckage.service;

import java.util.List;

import com.bionische.swastiktruckage.mastermodel.ClientAddresses;
import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.Info;

public interface ClientDetailsService {
	
	Info insertClientDetails(ClientDetails clientDetails);
	
	List<ClientFullDetails> getClientDetailsByName(String name);
	
	List<ClientFullDetails> getAllClientDetailsByStatus(int status);
	
	Info insertClientAddresses(ClientAddresses clientAddresses);
	
	ClientAddresses getClientAddressByClientId(int clientId);
	
	ClientDetails getClientDetailsById(int clientId);
	
	Info deleteClientById(int clientId);

}
