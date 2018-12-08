package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.LrLogs;

public interface LrLogsRepository extends JpaRepository<LrLogs, Integer>{

	LrLogs save(LrLogs lrLogs);	
}
