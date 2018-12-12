package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.swastiktruckage.mastermodel.MemoHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;

public interface MemoHeaderRepository extends JpaRepository<MemoHeader, Integer>{

	
	MemoHeader save(MemoHeader memoHeader);
	
	@Query(value="SELECT * from t_memo_header ORDER BY memo_header_id DESC LIMIT 1",nativeQuery=true)
	MemoHeader findLastRecord();
	
}
