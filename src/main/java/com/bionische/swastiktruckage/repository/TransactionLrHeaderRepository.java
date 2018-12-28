package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.TransactionLrHeader;

public interface TransactionLrHeaderRepository extends JpaRepository<TransactionLrHeader, Integer>{
	
	TransactionLrHeader findByLrHeaderId(int lrHeaderId);
	
	@Query(value="SELECT * from t_lr_header ORDER BY lr_header_id DESC LIMIT 1",nativeQuery=true)
	TransactionLrHeader findLastRecord();
	
	TransactionLrHeader findByLrNoAndBillStatus(int lrNo,int billStatus);
	
	TransactionLrHeader save(TransactionLrHeader transactionLrHeader);
	
	@Query(value="SELECT  h.* FROM t_lr_header h  WHERE  ( CASE WHEN h.payment_by = 0 THEN h.consignee_id =:clientId ELSE h.consignor =:clientId END ) AND  h.bill_status=0 AND h.delivery_status =3 " ,nativeQuery=true)
	List<TransactionLrHeader> getLrByClientId(@Param("clientId")int clientId);
	

	@Query(value="SELECT * from t_lr_header where lr_date between :fromDate AND :toDate ORDER BY lr_no ASC",nativeQuery=true)
	List<TransactionLrHeader> lrListByDate(@Param("fromDate")String fromDate,@Param("toDate")String toDate);
	
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
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionLrHeader t SET t.deliveryStatus=3  WHERE t.lrHeaderId=:lrHeaderId")
	int updateLrRecDeliveryStatusByHeaderId(@Param("lrHeaderId")int lrHeaderId);
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionLrHeader t SET t.deliveryStatus=5  WHERE t.lrHeaderId=:lrHeaderId")
	int lrReceive(@Param("lrHeaderId")int lrHeaderId);
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionLrHeader t SET t.deliveryStatus=4  WHERE t.lrHeaderId=:lrHeaderId")
	int updateLrLocalDeliveryStatusByHeaderId(@Param("lrHeaderId")int lrHeaderId);
	
	
	@Query(value="SELECT COUNT(l.lr_header_id) FROM t_lr_header l WHERE l.from_id=:officeId AND lr_date=CURDATE() AND l.delivery_status=0 AND l.is_used=true",nativeQuery=true)
	int getLrCountByOfficeId(@Param("officeId")int officeId);
	
	@Query(value="SELECT COUNT(h.lr_header_id) FROM t_memo_header mh, t_lr_header h " + 
			"WHERE h.lr_header_id IN (SELECT lr_header_id FROM t_memo_details WHERE t_memo_details.memo_header_id=mh.memo_header_id) " + 
			"AND h.delivery_status=4 AND h.is_used=TRUE ",nativeQuery=true)
	int getPendingLrDeliveryCount();
	

}
