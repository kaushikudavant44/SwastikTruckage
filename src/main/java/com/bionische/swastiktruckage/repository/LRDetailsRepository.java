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
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date, h.total,h.consignor,h.consignee_id,h.from_id," + 
			"o.office_name, cl1.client_name AS consignor_name, cl2.client_name AS consignee_name,cl2.client_address AS consignee_address, " + 
			"h.payment_by,h.inv_header_id,h.weight,h.freight,h.bharai,h.dd_charges,h.hamali,h.b_c_charge,h.kata,h.local_tempo,h.gst,h.truck_no,h.is_used " + 
			"FROM m_office o,t_lr_header h " + 
			"INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"WHERE o.office_id=h.from_id AND h.lr_header_id=:lrHeaderId AND h.is_used=TRUE" ,nativeQuery=true)
	LRDetails findByLrHeaderId(@Param("lrHeaderId") int lrHeaderId);

}
