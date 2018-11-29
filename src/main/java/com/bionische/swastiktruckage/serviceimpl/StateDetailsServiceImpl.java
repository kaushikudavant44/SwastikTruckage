package com.bionische.swastiktruckage.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bionische.swastiktruckage.controller.Util;
import com.bionische.swastiktruckage.mastermodel.City;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.repository.CityRepository;
import com.bionische.swastiktruckage.repository.StatesRepository;
import com.bionische.swastiktruckage.service.StateDetailsService;



@Service
public class StateDetailsServiceImpl implements StateDetailsService{

	@Autowired
	StatesRepository statesRepository;
	
	@Autowired
	CityRepository cityRepository;
	
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

	@Override
	public List<City> getAllCity() {
		// TODO Auto-generated method stub
		try {
			if(Util.cityList==null) {
				Util.cityList=cityRepository.findAll();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return Util.cityList;
	}
	
	

}
