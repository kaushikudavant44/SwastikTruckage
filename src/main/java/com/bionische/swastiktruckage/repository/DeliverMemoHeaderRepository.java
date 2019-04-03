package com.bionische.swastiktruckage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.DeliverMemoHeader;

public interface DeliverMemoHeaderRepository extends JpaRepository<DeliverMemoHeader, Integer>{
	
	
	DeliverMemoHeader save(DeliverMemoHeader deliverMemoHeader);
	
	@Query(value="SELECT * from t_delivery_memo_header ORDER BY deli_memo_header_id DESC LIMIT 1",nativeQuery=true)
	DeliverMemoHeader findLastRecord();
	
	@Transactional
	@Modifying
	@Query("UPDATE DeliverMemoHeader m SET m.isUsed=1  WHERE m.deliMemoHeaderId=:deliMemoHeaderId")
	int updateLocalMemoByMemoHeaderId(@Param("deliMemoHeaderId")int deliMemoHeaderId);

}
