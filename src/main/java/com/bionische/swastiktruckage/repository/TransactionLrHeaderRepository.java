package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;

public interface TransactionLrHeaderRepository extends JpaRepository<TransactionLrHeader, Integer>{
	
	
	@Query(value="SELECT * from t_lr_header ORDER BY lr_header_id DESC LIMIT 1",nativeQuery=true)
	TransactionLrHeader findLastRecord();
	
	TransactionLrHeader save(TransactionLrHeader transactionLrHeader);
	
	@Query(value="SELECT  h.* FROM t_lr_header h  WHERE  ( CASE WHEN h.payment_by = 0 THEN h.consignee_id =:clientId ELSE h.consignor =:clientId END ) AND  h.bill_status=0 AND h.delivery_status =3 " ,nativeQuery=true)
	List<TransactionLrHeader> getLrByClientId(@Param("clientId")int clientId);
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionLrHeader set billStatus=1 where lrHeaderId=:headerId")
	int updatePaymentStatus(@Param("headerId")int headerId);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionLrHeader t SET t.isUsed=false  WHERE t.lrHeaderId=:lrHeaderId")
	int updateLrByHeaderId(@Param("lrHeaderId")int lrHeaderId);
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionLrHeader t SET t.deliveryStatus=1  WHERE t.lrHeaderId=:lrHeaderId")
	int updateLrDeliveryStatusByHeaderId(@Param("lrHeaderId")int lrHeaderId);
	

}
