package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;

public interface TransactionLrHeaderRepository extends JpaRepository<TransactionLrHeader, Integer>{
	
	
	@Query(value="SELECT lr_id FROM t_lr_header ORDER BY lr_header_id DESC LIMIT 1",nativeQuery=true)
	int findLastRecord();
	
	TransactionLrHeader save(TransactionLrHeader transactionLrHeader);

	@Query(value="SELECT  h.* FROM t_lr_header h  WHERE  ( CASE WHEN h.payment_by = 0 THEN h.consignee_id =:clientId ELSE h.consignor =:clientId END ) AND  h.bill_status=0 AND h.delivery_status =3 " ,nativeQuery=true)
	List<TransactionLrHeader> getLrByClientId(@Param("clientId")int clientId);
}
