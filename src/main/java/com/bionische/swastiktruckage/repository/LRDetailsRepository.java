package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.LRDetails;

public interface LRDetailsRepository extends JpaRepository<LRDetails, Integer>{
	
	@Query(value="SELECT h.lr_header_id,h.consignor,h.lr_id,h.inv_header_id,h.from_id,h.to_id,h.lr_date,h.truck_no,h.weight,h.freight,h.gst,h.hamali,h.local_tempo,h.total,h.payment_by," + 
			"h.status,SUM(c.no_of_containts) AS quantity FROM t_lr_header h,t_lr_containt_details c WHERE h.lr_header_id=c.lr_header_id AND" + 
			"h.status=0 GROUP BY h.lr_header_id " ,nativeQuery=true)
	List<LRDetails> findAllLr();
	
	@Query(value="SELECT *,h1.lr_header_id, h1.consignor, h1.consignee_id, h1.lr_id, h1.inv_header_id, h1.from_id, h1.to_id, h1.lr_date, h1.truck_no, h1.weight, h1.freight," + 
			"h1.gst, h1.hamali, h1.local_tempo, h1.total, h1.payment_by, h1.consignor," + 
			"o.office_address, o.office_contact_no, o.fax_no, o.pincode,o.office_name," + 
			"SUM(c.no_of_containts) AS quantity FROM t_lr_header h1,t_lr_containt_details c,m_office o,m_clients cl," + 
			"(SELECT c.client_name FROM m_clients c , t_lr_header h2 WHERE h2.consignor=c.client_id  AND h2.lr_id=180002) consignor," + 
			"(SELECT CASE WHEN h.consignee_Id=0 THEN h.consignee ELSE c.client_name END AS consignee FROM m_clients c , t_lr_header h" + 
			"WHERE c.client_id=h.consignee_id OR h.consignee_id=0 AND h.lr_id=180002) consignee" + 
			"WHERE h1.lr_header_id=c.lr_header_id AND h1.status=0 AND h1.lr_id=180002 AND o.office_id=h1.from_id GROUP BY h1.lr_header_id" ,nativeQuery=true)
	LRDetails findByLrId(@Param("lrId") int lrId);

}
