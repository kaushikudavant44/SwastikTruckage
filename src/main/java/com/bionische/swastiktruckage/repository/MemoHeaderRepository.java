package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.MemoHeader;
import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;

public interface MemoHeaderRepository extends JpaRepository<MemoHeader, Integer>{

	
	MemoHeader save(MemoHeader memoHeader);
	
	@Query(value="SELECT * from t_memo_header ORDER BY memo_header_id DESC LIMIT 1",nativeQuery=true)
	MemoHeader findLastRecord();
	
	@Transactional
	@Modifying
	@Query("UPDATE MemoHeader m SET m.isUsed=false  WHERE m.memoHeaderId=:memoHeaderId")
	int updateMemoByMemoHeaderId(@Param("memoHeaderId")int memoHeaderId);
}
