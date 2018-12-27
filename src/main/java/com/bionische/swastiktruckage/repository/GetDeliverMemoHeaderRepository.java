package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.mastermodel.GetDeliverMemoHeader;

public interface GetDeliverMemoHeaderRepository extends JpaRepository<GetDeliverMemoHeader, Integer>{
	
	@Query(value="SELECT dh.deli_memo_header_id,dh.driver_id,d.driver_name,dh.deli_memo_date,v.veh_no,dh.vehicle_id,dh.office_id,o.office_name,dh.staff_id,s.staff_name,dh.local_memo_no\r\n" + 
			"FROM m_office_staff s, m_vehicles v, t_delivery_memo_header dh, m_office o, m_vehicles_drivers d WHERE dh.vehicle_id=v.veh_id AND dh.office_id=:officeId AND dh.office_id=o.office_id\r\n" + 
			"AND s.staff_id=dh.staff_id",nativeQuery=true)
	List<GetDeliverMemoHeader> findAllMemoByOfficeId(@Param("officeId")int officeId);
	
	
	@Query(value="SELECT dh.deli_memo_header_id,dh.driver_id,d.driver_name,dh.deli_memo_date,v.veh_no,dh.vehicle_id,dh.office_id,o.office_name,dh.staff_id,s.staff_name,dh.local_memo_no\r\n" + 
			"FROM m_office_staff s, m_vehicles v, t_delivery_memo_header dh, m_office o, m_vehicles_drivers d WHERE dh.vehicle_id=v.veh_id AND dh.office_id=3 AND dh.office_id=o.office_id\r\n" + 
			"AND s.staff_id=dh.staff_id AND dh.driver_id=d.driver_id AND dh.deli_memo_header_id=:deliMemoHeaderId AND dh.office_id=:officeId",nativeQuery=true)
	GetDeliverMemoHeader findLocalMemoDetailsByOfficeIdAnddeliMemoHeaderId(@Param("officeId")int officeId,@Param("deliMemoHeaderId")int deliMemoHeaderId);
	

}
