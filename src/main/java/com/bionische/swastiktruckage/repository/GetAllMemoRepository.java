package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.model.GetAllMemo;

public interface GetAllMemoRepository extends JpaRepository<GetAllMemo, Integer>{
	
	@Query(value="SELECT m.memo_header_id,d.driver_license_no,m.memo_no,o.owner_name, d.driver_name,m.created_date, m.office_id,m.to_id, m.staff_id, m.veh_id, v.veh_no ,m.driver_id, cl1.office_name AS from_office, cl2.office_name AS to_office, cl1.office_address " + 
			"FROM m_vehicle_owners o, m_vehicles_drivers d, m_vehicles v, t_memo_header m " + 
			"INNER JOIN m_office cl1 ON cl1.office_id = m.office_id " + 
			"INNER JOIN m_office cl2 ON cl2.office_id = m.to_id " + 
			"WHERE m.driver_id=d.driver_id AND m.veh_id=v.veh_id AND v.owner_id=o.owner_id " + 
			"AND YEAR(m.created_date)=YEAR(CURRENT_DATE()) AND MONTH(m.created_date)=MONTH(CURRENT_DATE()) ",nativeQuery=true)
			List<GetAllMemo> getListOfMemo();
	
	@Query(value="SELECT m.memo_header_id,m.memo_no,d.driver_license_no, o.owner_name, d.driver_name,m.created_date, m.office_id,m.to_id, m.staff_id, m.veh_id, v.veh_no ,m.driver_id, cl1.office_name AS from_office, cl2.office_name AS to_office, cl1.office_address " + 
			"FROM m_vehicle_owners o, m_vehicles_drivers d, m_vehicles v, t_memo_header m " + 
			"INNER JOIN m_office cl1 ON cl1.office_id = m.office_id " + 
			"INNER JOIN m_office cl2 ON cl2.office_id = m.to_id " + 
			"WHERE m.driver_id=d.driver_id AND m.veh_id=v.veh_id AND v.owner_id=o.owner_id " + 
			"AND YEAR(m.created_date)=YEAR(CURRENT_DATE()) AND MONTH(m.created_date)=MONTH(CURRENT_DATE()) AND m.memo_header_id=:memoHeaderId",nativeQuery=true)
	GetAllMemo findByMemoHeaderId(@Param("memoHeaderId")int memoHeaderId);
}
