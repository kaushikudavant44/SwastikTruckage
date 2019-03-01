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
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND h.from_id=:officeId AND h.is_used=true AND MONTH(h.lr_date)=MONTH(CURRENT_DATE()) AND YEAR(h.lr_date)=YEAR(CURRENT_DATE()) GROUP BY h.lr_header_id order by h.lr_header_id desc" ,nativeQuery=true)
	List<GetAllLrDetails> findAllLr(@Param("officeId")int officeId);

	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,g.goods_name AS particular,cl2.client_address,h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"h.total AS amount,c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee " + 
			"FROM t_lr_containt_details c, m_goods g, m_office o, t_lr_header h INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND h.from_id=:officeId AND h.is_used=TRUE AND h.delivery_status=0 GROUP BY h.lr_header_id" ,nativeQuery=true)
	List<GetAllLrDetails> findLrForMakeMemo(@Param("officeId")int officeId);
	
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,g.goods_name AS particular,cl2.client_address,h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"	h.total AS amount,c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee " + 
			"	FROM t_lr_containt_details c, m_goods g, m_office o, t_lr_header h INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"	INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"	WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND " + 
			"	h.lr_header_id IN (SELECT lr_header_id FROM t_memo_details WHERE t_memo_details.memo_header_id=:memoHeaderId) AND h.is_used=TRUE GROUP BY h.lr_header_id" ,nativeQuery=true)
	List<GetAllLrDetails> getMemoLrDetailsByMemoHeaderId(@Param("memoHeaderId")int memoHeaderId);
	
	//Temprory commented
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,mh.to_id,g.goods_name AS particular,cl2.client_address,h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"h.total AS amount,c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee \r\n" + 
			"FROM t_lr_containt_details c, m_goods g, m_office o,t_memo_header mh, t_lr_header h INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id  " + 
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND  " + 
			"h.lr_header_id IN (SELECT lr_header_id FROM t_memo_details WHERE t_memo_details.memo_header_id=mh.memo_header_id) AND h.delivery_status=4 AND mh.to_id=:toId AND h.is_used=TRUE GROUP BY h.lr_header_id" ,nativeQuery=true)
	List<GetAllLrDetails> findAllReceivedLr(@Param("toId")int toId);
	
	
	/**
	 * Temprory query for show delivered Lr
	 * @param lrNo
	 * @param officeId
	 * @return
	 */
/*	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,mh.to_id,g.goods_name AS particular,cl2.client_address,h.payment_by, SUM(c.no_of_containts) AS quantity,  " + 
			"h.total AS amount,c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee  " + 
			"FROM t_lr_containt_details c, m_goods g, m_office o,t_memo_header mh, t_lr_header h INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND " + 
			"h.delivery_status=4 AND mh.to_id=:toId AND h.is_used=TRUE GROUP BY h.lr_header_id" ,nativeQuery=true)
	List<GetAllLrDetails> findAllReceivedLr(@Param("toId")int toId);*/
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,mh.to_id,g.goods_name AS particular, cl2.client_address, h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"h.total AS amount, c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee  " + 
			"FROM  t_memo_details md,t_lr_containt_details c, m_goods g, m_office o,t_memo_header mh, t_lr_header h " + 
			"INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id   " + 
			"WHERE h.lr_no=:lrNo AND mh.to_id=:officeId  AND mh.to_id=o.office_id AND c.goods_id=g.goods_id AND md.lr_header_id=c.lr_header_id AND h.delivery_status=3 AND h.lr_header_id=md.lr_header_id" ,nativeQuery=true)
	GetAllLrDetails findReceiveLrBylrNoAndOfficeId(@Param("lrNo")int lrNo,@Param("officeId")int officeId);
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,g.goods_name AS particular,h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"h.total AS amount,c.goods_id, o.office_name, cl2.client_address, cl1.client_name AS consignor, cl2.client_name AS consignee " + 
			"FROM t_lr_containt_details c, m_goods g, m_office o, t_delivery_memo_header mh, m_vehicles_drivers d, m_vehicles v, m_office_staff s,t_lr_header h  " + 
			"INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor  " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND d.driver_id=mh.driver_id AND v.veh_id=mh.vehicle_id AND s.staff_id=mh.staff_id AND " + 
			"h.lr_header_id IN (SELECT lr_header_id FROM t_delivery_memo_details WHERE t_delivery_memo_details.deli_memo_header_id=mh.deli_memo_header_id) AND mh.deli_memo_header_id=:deliMemoHeaderId AND h.delivery_status=4 AND h.is_used=TRUE GROUP BY h.lr_header_id" ,nativeQuery=true)
	List<GetAllLrDetails> getAllLocalMemoLrByDeliMemoHeaderId(@Param("deliMemoHeaderId")int deliMemoHeaderId);
	
	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,mh.to_id,g.goods_name AS particular, cl2.client_address, h.payment_by, SUM(c.no_of_containts) AS quantity, " + 
			"h.total AS amount, c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee  " + 
			"FROM  t_memo_details md,t_lr_containt_details c, m_goods g, m_office o,t_memo_header mh, t_lr_header h " + 
			"INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id   " + 
			"WHERE h.lr_no=:lrNo AND mh.to_id=:officeId  AND mh.to_id=o.office_id AND c.goods_id=g.goods_id AND md.lr_header_id=c.lr_header_id AND h.delivery_status=4 AND h.lr_header_id=md.lr_header_id" ,nativeQuery=true)
	GetAllLrDetails findReturnLrBylrNoAndOfficeId(@Param("lrNo")int lrNo,@Param("officeId")int officeId);
	
/*	@Query(value="SELECT h.lr_header_id,h.lr_no,h.lr_date,g.goods_name AS particular,cl2.client_address,h.payment_by,SUM(c.no_of_containts) AS quantity, h.total AS amount," + 
			"c.goods_id, o.office_name, cl1.client_name AS consignor, cl2.client_name AS consignee " + 
			"FROM t_lr_containt_details c, m_goods g, m_office o, t_lr_header h " + 
			"INNER JOIN m_clients cl1 ON cl1.client_id = h.consignor " + 
			"INNER JOIN m_clients cl2 ON cl2.client_id = h.consignee_id " + 
			"WHERE h.lr_header_id=c.lr_header_id AND c.goods_id=g.goods_id AND o.office_id=h.from_id AND h.from_id=:officeId GROUP BY h.lr_header_id order by h.lr_header_id desc" ,nativeQuery=true)
	List<GetAllLrDetails> findAllLr(@Param("officeId")int officeId);*/

	
	
	
}
