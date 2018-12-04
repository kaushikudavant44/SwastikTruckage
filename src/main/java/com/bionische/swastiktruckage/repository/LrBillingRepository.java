package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.model.GetStaffDetails;

public interface LrBillingRepository extends JpaRepository<LrBilling,Integer>{
	
	@Query(value="SELECT h.lr_header_id,h.consignor,h.lr_id,h.inv_header_id,h.from_id,h.to_id,h.lr_date,h.truck_no,h.weight,h.freight,h.gst,h.hamali,h.local_tempo,h.total,h.payment_by,\r\n" + 
			"h.status,SUM(c.no_of_containts) AS quantity FROM t_lr_header h,t_lr_containt_details c WHERE h.lr_header_id=c.lr_header_id AND h.consignor=:clientId AND \r\n" + 
			"h.status=0 GROUP BY h.lr_header_id " ,nativeQuery=true)
	List<LrBilling> getBillDetailByClientId(@Param("clientId") int clientId);
	

}
