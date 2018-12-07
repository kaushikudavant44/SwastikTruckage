package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.swastiktruckage.mastermodel.ClientDetails;
import com.bionische.swastiktruckage.mastermodel.LrBilling;

public interface ClientDetailsRepository extends JpaRepository<ClientDetails, Integer>{
	
	ClientDetails save(ClientDetails clientDetails);
	
	ClientDetails findByClientId(int clientId);
	
	ClientDetails findByClientName(String clientName);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM ClientDetails where clientId=:clientId")
	int deleteClientById(@Param("clientId")int clientId);
	
	@Query(value="SELECT c.* FROM m_clients AS c WHERE c.client_id IN(SELECT  ( CASE WHEN h.payment_by = 0 THEN h.consignee_id \r\n" + 
			"ELSE h.consignor \r\n" + 
			"END ) AS client_id   FROM t_lr_header h  WHERE  h.bill_status=0 AND h.delivery_status =3 ) " ,nativeQuery=true)
	List<ClientDetails> getUnPaidClients();
	

}
