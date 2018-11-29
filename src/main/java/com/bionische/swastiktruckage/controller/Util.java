package com.bionische.swastiktruckage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bionische.swastiktruckage.mastermodel.City;
import com.bionische.swastiktruckage.mastermodel.States;
import com.bionische.swastiktruckage.service.StateDetailsService;

public class Util {
	
	public static List<States> stateList;
	
	public static List<City> cityList;
	
	@Autowired
	StateDetailsService stateDetailsService;

	
	
}
