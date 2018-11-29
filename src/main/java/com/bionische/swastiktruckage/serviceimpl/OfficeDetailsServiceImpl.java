package com.bionische.swastiktruckage.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bionische.swastiktruckage.mastermodel.OfficeDetails;
import com.bionische.swastiktruckage.repository.OfficeDetailsRepository;
import com.bionische.swastiktruckage.service.OfficeDetailsService;

public class OfficeDetailsServiceImpl implements OfficeDetailsService{

	@Autowired
	OfficeDetailsRepository officeDetailsRepository;
	
	@Override
	public List<OfficeDetails> getOfficeDetailsIsUsed() {
		// TODO Auto-generated method stub
		List<OfficeDetails> officeDetailsList=officeDetailsRepository.findByIsUsed(true);
		
		return officeDetailsList;
	}

}
