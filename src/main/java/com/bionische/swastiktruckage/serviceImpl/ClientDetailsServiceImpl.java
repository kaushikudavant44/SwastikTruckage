package com.bionische.swastiktruckage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.swastiktruckage.mastermodel.ClientAddresses;
import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;
import com.bionische.swastiktruckage.mastermodel.Info;
import com.bionische.swastiktruckage.repository.ClientAddressesRepository;
import com.bionische.swastiktruckage.repository.ClientDetailsRepository;
import com.bionische.swastiktruckage.repository.ClientFullDetailsRepository;
import com.bionische.swastiktruckage.service.ClientDetailsService;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService{
	
	@Autowired
	ClientDetailsRepository clientDetailsRepository;
	
	@Autowired
	ClientFullDetailsRepository clientFullDetailsRepository;
	
	@Autowired
	ClientAddressesRepository clientAddressesRepository;
	
	
	@Override
	public Info insertClientDetails(ClientDetails clientDetails)
	{
		Info info = new Info();
		try
		{
		ClientDetails res = clientDetailsRepository.save(clientDetails);
		
		
		if(res!=null)
		{
			info.setError(false);
			info.setMessage("success");
			
		}
		else
		{
			info.setError(true);
			info.setMessage("failed");
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return info;
		
	}

	@Override
	public List<ClientFullDetails> getClientDetailsByName(String name)
	{
		List<ClientFullDetails> res = new ArrayList<ClientFullDetails>();
		try
		{
			res = clientFullDetailsRepository.getClientDetailsByName(name,1);		
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
	}
    
	@Override
	public List<ClientFullDetails> getAllClientDetailsByStatus(int status)
	{
		List<ClientFullDetails> res = new ArrayList<ClientFullDetails>();
		try
		{
			res = clientFullDetailsRepository.getAllClientDetailsByStatus(status);		
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
		
	}
	
	@Override
	public Info insertClientAddresses(ClientAddresses clientAddresses)
	{
		Info info = new Info();
		try
		{
			ClientAddresses res = clientAddressesRepository.save(clientAddresses);
		
		
		if(res!=null)
		{
			info.setError(false);
			info.setMessage("success");
			
		}
		else
		{
			info.setError(true);
			info.setMessage("failed");
			
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return info;
		
	}

	@Override
	public ClientAddresses getClientAddressByClientId(int clientId)
	{
		ClientAddresses res = new ClientAddresses();
		try
		{
			res = clientAddressesRepository.findByClientId(clientId);		
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return res;
		
	}


}
