package com.bionische.swastiktruckage.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.swastiktruckage.controller.Util;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.repository.StatesRepository;
import com.bionische.swastiktruckage.service.StateDetailsService;



@Service
public class StateDetailsServiceImpl implements StateDetailsService{

	@Autowired
	StatesRepository statesRepository;
	
	@Override
	public List<States> getAllStates() {
		try {
			
			if(Util.stateList==null) {
				Util.stateList=statesRepository.findAll();
			}
			
		} catch (Exception e) {
		   e.printStackTrace();
		}
	return Util.stateList;
	}
	
	

}
