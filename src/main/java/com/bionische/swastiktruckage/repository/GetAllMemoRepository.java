package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.model.GetAllMemo;

public interface GetAllMemoRepository extends JpaRepository<GetAllMemo, Integer>{
	
	@Query(value="SELECT m.memo_header_id, o.office_name, m.memo_no, d.driver_name, m.office_id, m.staff_id, m.veh_id, v.veh_no ,m.driver_id " + 
			"FROM t_memo_header m, m_office o, m_vehicles_drivers d, m_vehicles v WHERE m.office_id=o.office_id AND m.driver_id=d.driver_id AND m.veh_id=v.veh_id " + 
			"AND YEAR(m.created_date)=YEAR(CURRENT_DATE()) AND MONTH(m.created_date)=MONTH(CURRENT_DATE())",nativeQuery=true)
			List<GetAllMemo> getListOfMemo();
	
	@Query(value="SELECT m.memo_header_id, o.office_name, m.memo_no, d.driver_name, m.office_id, m.staff_id, m.veh_id, v.veh_no ,m.driver_id " + 
			"FROM t_memo_header m, m_office o, m_vehicles_drivers d, m_vehicles v WHERE m.office_id=o.office_id AND m.driver_id=d.driver_id AND m.veh_id=v.veh_id " + 
			"AND YEAR(m.created_date)=YEAR(CURRENT_DATE()) AND MONTH(m.created_date)=MONTH(CURRENT_DATE()) AND m.memo_header_id=:memoHeaderId",nativeQuery=true)
	GetAllMemo findByMemoHeaderId(@Param("memoHeaderId")int memoHeaderId);
}
