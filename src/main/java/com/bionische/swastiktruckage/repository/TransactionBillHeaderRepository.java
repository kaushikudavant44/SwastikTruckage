package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.bionische.swastiktruckage.mastermodel.TransactionBillHeader;

public interface TransactionBillHeaderRepository extends JpaRepository<TransactionBillHeader, Integer>{
	
	TransactionBillHeader save(TransactionBillHeader transactionBillHeader);
	
	List<TransactionBillHeader> findAll();
	
	@Query(value="SELECT * from t_bill_header ORDER BY bill_header_id DESC LIMIT 1",nativeQuery=true)
	TransactionBillHeader getLastEntry();
	
	TransactionBillHeader findByBillHeaderId(int billHeaderId);
	
	@Query(value="select * from t_bill_header where bill_status=:status AND bill_date between :fromDate and :toDate" ,nativeQuery=true)
	List<TransactionBillHeader> billByDate(@Param("status") int status,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionBillHeader set trId=:trId,paymentMode=:paymentMode  where billHeaderId=:billHeaderId")
	int updatePaymentMode(@Param("trId")int trId,@Param("paymentMode")int paymentMode,@Param("billHeaderId")int billHeaderId);	
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionBillHeader set billStatus=:billStatus  where billHeaderId=:billHeaderId")
	int updateBillStatus(@Param("billStatus")int billStatus,@Param("billHeaderId")int billHeaderId);
	
	@Query(value="SELECT COUNT(bill_header_id) FROM t_bill_header b WHERE b.bill_status=0" ,nativeQuery=true)
	int getPendingBillCount();

	@Query(value="select * from t_bill_header where bill_to=:clientId AND bill_date between :fromDate and :toDate" ,nativeQuery=true)
	List<TransactionBillHeader> getBillByClientId(@Param("clientId") int clientId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
	
	@Transactional
	@Modifying
	@Query("UPDATE TransactionBillHeader set isUsed=1 where billHeaderId=:billHeaderId")
	int updateIsUsedStatus(@Param("billHeaderId")int billHeaderId);
}
