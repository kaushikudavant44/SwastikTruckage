package com.bionische.swastiktruckage.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.model.GetStaffDetails;

public interface LrBillingRepository extends JpaRepository<LrBilling,Integer>{
	
	@Query(value="SELECT h.lr_header_id,h.consignee_id,h.consignor,h.lr_No,h.inv_header_id,h.from_id,h.to_id,h.lr_date,h.truck_no,h.weight,h.freight,h.gst,h.hamali,h.local_tempo,h.total,h.payment_by,\r\n" + 
			"SUM(c.no_of_containts) AS quantity FROM t_lr_header h,t_lr_containt_details c WHERE h.lr_header_id=:headerId AND h.lr_header_id=c.lr_header_id GROUP BY h.lr_header_id " ,nativeQuery=true)
	List<LrBilling> getBillDetailByLrId(@Param("headerId") int[] headerId);
	
	@Query(value="SELECT (SELECT goods FROM t_lr_containt_details WHERE (lr_header_id,no_of_containts) IN (SELECT lr_header_id,MAX(no_of_containts) FROM t_lr_containt_details WHERE lr_header_id=:headerId ))as goods, h.lr_header_id,h.consignee_id,h.consignor,h.lr_No,h.inv_header_id,h.from_id,h.lr_date,h.truck_no,h.weight,h.freight,h.gst,h.hamali,h.local_tempo,h.total,h.payment_by,\r\n" + 
			"SUM(c.no_of_containts) AS quantity FROM t_lr_header h,t_lr_containt_details c WHERE h.lr_header_id=:headerId AND h.lr_header_id=c.lr_header_id GROUP BY h.lr_header_id " ,nativeQuery=true)
	LrBilling getBillDetailByLrId(@Param("headerId") int headerId);
	

}
