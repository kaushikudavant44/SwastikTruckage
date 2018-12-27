package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.model.GetPaymentDetails;

public interface GetPaymentDetailsRepository extends JpaRepository<GetPaymentDetails, Integer>{

	@Query(value="SELECT h.* ,c.client_name, COALESCE((SELECT SUM(p.amount_received) FROM t_bill_payments p WHERE  p.bill_header_id = h.bill_header_id), 0) AS amount_received FROM t_bill_header h,m_clients c WHERE bill_status=:status AND h.bill_date BETWEEN :fromDate AND :toDate AND h.bill_to=c.client_id" ,nativeQuery=true)
	List<GetPaymentDetails> paymentDetailsByDate(@Param("status") int status,@Param("fromDate") String fromDate,@Param("toDate") String toDate);
}
