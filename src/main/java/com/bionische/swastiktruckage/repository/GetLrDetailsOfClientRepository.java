package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bionische.swastiktruckage.model.GetLrDetailsOfClient;

public interface GetLrDetailsOfClientRepository extends JpaRepository<GetLrDetailsOfClient,Integer> {
	
	@Query(value="SELECT c.client_name AS consignee_name,(SELECT client_name FROM m_clients WHERE client_id=l.consignor) AS consignor_name,l.lr_header_id,l.consignee_id,l.consignor,l.lr_No,l.inv_header_id,l.from_id,l.lr_date,l.truck_no,l.weight,l.freight,l.gst,l.hamali,l.local_tempo,l.total,l.payment_by ,l.delivery_status,l.bill_status\r\n" + 
			"FROM t_lr_header l,m_clients c WHERE l.lr_date BETWEEN :fromDate AND :toDate AND (l.payment_by=0 AND l.consignee_id=:clientId) OR (l.payment_by=1 AND l.consignor=:clientId) AND l.consignee_id = c.client_id GROUP BY l.lr_header_id " ,nativeQuery=true)
	List<GetLrDetailsOfClient> getLrByClientId(@Param("clientId") int clientId,@Param("fromDate") String fromDate,@Param("toDate") String toDate);

}
