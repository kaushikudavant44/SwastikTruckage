package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.MemoDetails;

public interface MemoDetailsRepository extends JpaRepository<MemoDetails, Integer>{
	
	
	@Transactional
	@Modifying
	@Query("DELETE FROM MemoDetails WHERE lrHeaderId=:lrHeaderId")
	int deleteMemoDetailsByLrHeaderId(@Param("lrHeaderId")int lrHeaderId);

}
