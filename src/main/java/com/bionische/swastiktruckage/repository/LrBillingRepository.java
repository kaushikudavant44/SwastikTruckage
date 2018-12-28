package com.bionische.swastiktruckage.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.LrBilling;
import com.bionische.swastiktruckage.model.GetStaffDetails;

public interface LrBillingRepository extends JpaRepository<LrBilling,Integer>{
	
	/*@Query(value="SELECT h.lr_header_id,h.consignee_id,h.consignor,h.lr_No,h.inv_header_id,h.from_id,h.to_id,h.lr_date,h.truck_no,h.weight,h.freight,h.gst,h.hamali,h.local_tempo,h.total,h.payment_by,\r\n" + 
			"SUM(c.no_of_containts) AS quantity FROM t_lr_header h,t_lr_containt_details c WHERE h.lr_header_id=:headerId AND h.lr_header_id=c.lr_header_id GROUP BY h.lr_header_id " ,nativeQuery=true)
	List<LrBilling> getBillDetailByLrId(@Param("headerId") int[] headerId);*/
	
	@Query(value="SELECT m.client_name AS consignee_name,(SELECT client_name FROM m_clients WHERE client_id=h.consignor) AS consignor_name,(SELECT goods_name FROM m_goods WHERE goods_id = (SELECT goods_id FROM t_lr_containt_details WHERE lr_header_id=:headerId ORDER BY no_of_containts DESC LIMIT 1))AS goods, h.lr_header_id,h.consignee_id,h.consignor,h.lr_No,h.inv_header_id,h.from_id,h.lr_date,h.truck_no,h.weight,h.freight,h.gst,h.hamali,h.local_tempo,h.total,h.payment_by, \r\n" + 
			"SUM(c.no_of_containts) AS quantity FROM t_lr_header h,t_lr_containt_details c,m_clients m WHERE h.lr_header_id=:headerId AND h.consignee_id = m.client_id AND h.lr_header_id=c.lr_header_id GROUP BY h.lr_header_id " ,nativeQuery=true)
	LrBilling getBillDetailByLrId(@Param("headerId") int headerId);
	
	@Query(value="SELECT m.client_name AS consignee_name,(SELECT client_name FROM m_clients WHERE client_id=h.consignor) AS consignor_name,(SELECT goods_name FROM m_goods WHERE goods_id = (SELECT goods_id FROM t_lr_containt_details WHERE lr_header_id=h.lr_header_id ORDER BY no_of_containts DESC LIMIT 1))AS goods, h.lr_header_id,h.consignee_id,h.consignor,h.lr_No,h.inv_header_id,h.from_id,h.lr_date,h.truck_no,h.weight,h.freight,h.gst,h.hamali,h.local_tempo,h.total,h.payment_by, \r\n" + 
			"SUM(c.no_of_containts) AS quantity FROM t_lr_header h,t_lr_containt_details c,m_clients m WHERE h.bill_status=0 AND payment_by!=2 AND h.consignee_id = m.client_id AND h.lr_header_id=c.lr_header_id GROUP BY h.lr_header_id " ,nativeQuery=true)
	List<LrBilling> getAllUnPaidLr();
	
	@Query(value="SELECT l.lr_header_id,l.lr_No,l.inv_header_id,l.from_id,l.lr_date,l.truck_no,l.weight,l.freight,l.gst,l.hamali,l.local_tempo,l.total,l.payment_by,SUM(c.no_of_containts) AS quantity,l.consignor,l.consignee_id,m.client_name AS consignee_name,(SELECT client_name FROM m_clients WHERE client_id=l.consignor) AS consignor_name,\r\n" + 
			"(SELECT goods_name FROM m_goods WHERE goods_id = (SELECT goods_id FROM t_lr_containt_details WHERE lr_header_id=l.lr_header_id ORDER BY no_of_containts DESC LIMIT 1))AS goods from t_lr_header l,t_bill_header b,t_bill_details d,t_lr_containt_details c,m_clients m WHERE b.bill_status=0 AND b.bill_header_id=d.bill_header_id AND d.lr_header_id=l.lr_header_id \r\n" + 
			" AND l.consignee_id = m.client_id AND l.lr_header_id=c.lr_header_id GROUP BY l.lr_header_id " ,nativeQuery=true)
	List<LrBilling> paymentPendingLrList();
	
	

}
