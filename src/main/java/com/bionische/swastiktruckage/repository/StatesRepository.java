package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.States;

public interface StatesRepository extends JpaRepository<States, Integer>{

	List<States> findAll();
}
