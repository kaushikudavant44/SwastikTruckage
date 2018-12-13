package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.GetAllLrDetails;

public interface GetAllLrDetailsRepository extends JpaRepository<GetAllLrDetails, Integer>{
	
	
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,g.goods_name AS particular,cl2.client_address,h.payment_by,SUM(c.no_of_containts) AS quantity, h.total AS amount," + 
			"c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee " + 
			"FROM t_lr_containt_details c, m_goods g, m_office o, t_lr_header h " + 
			"INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND h.is_used=true AND MONTH(h.lr_date)=MONTH(CURRENT_DATE()) AND YEAR(h.lr_date)=YEAR(CURRENT_DATE()) GROUP BY h.lr_header_id order by h.lr_header_id desc" ,nativeQuery=true)
	List<GetAllLrDetails> findAllLr();

	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,g.goods_name AS particular,cl2.client_address,h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"h.total AS amount,c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee " + 
			"FROM t_lr_containt_details c, m_goods g, m_office o, t_lr_header h INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND h.is_used=TRUE AND h.delivery_status=0 GROUP BY h.lr_header_id" ,nativeQuery=true)
	List<GetAllLrDetails> findLrForMakeMemo();
	
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,g.goods_name AS particular,cl2.client_address,h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"	h.total AS amount,c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee " + 
			"	FROM t_lr_containt_details c, m_goods g, m_office o, t_lr_header h INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"	INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"	WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND " + 
			"	h.lr_header_id IN (SELECT lr_header_id FROM t_memo_details WHERE t_memo_details.memo_header_id=:memoHeaderId) AND h.is_used=TRUE GROUP BY h.lr_header_id" ,nativeQuery=true)
	List<GetAllLrDetails> getMemoLrDetailsByMemoHeaderId(@Param("memoHeaderId")int memoHeaderId);
	
	
	
}
