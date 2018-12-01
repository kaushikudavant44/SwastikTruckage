package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.ClientFullDetails;

public interface ClientFullDetailsRepository extends JpaRepository<ClientFullDetails, Integer>{
	

	@Query(value="SELECT c.client_id,c.client_name,c.client_address,c.state_id,c.city_id,c.pincode,c.client_contact_no,c.gstin,y.city_name,s.state_name"
			+ " FROM m_clients c,m_city Y,m_states s WHERE c.client_name=:name AND c.is_used=:status AND c.city_id=y.city_id AND c.state_id=s.state_id" ,nativeQuery=true)
	List<ClientFullDetails> getClientDetailsByName(@Param("name")String name, @Param("status")int status);
	
	@Query(value="SELECT c.client_id,c.client_name,c.client_address,c.state_id,c.city_id,c.pincode,c.client_contact_no,c.gstin,t.city_name,s.state_name"
			+ " FROM m_clients c,m_city t,m_states s WHERE c.is_used=:status AND c.city_id=t.city_id AND c.state_id=s.state_id" ,nativeQuery=true)
	List<ClientFullDetails> getAllClientDetailsByStatus(@Param("status")int status);

}
