package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.swastiktruckage.model.GetVoucherReport;

public interface GetVoucherReportRepository extends JpaRepository<GetVoucherReport,Integer>{
	
	@Query(value="SELECT v.voucher_id,v.create_date,m.memo_header_id,m.memo_no,m.veh_id,m.driver_id,m.office_id,m.to_id,m.staff_id,o.office_address,o1.office_address AS to_address,h.veh_no FROM t_voucher v,\r\n" + 
			"m_vehicles h,t_memo_header m INNER JOIN m_office o ON o.office_id = m.office_id INNER JOIN m_office o1 ON o1.office_id = m.to_id  WHERE v.create_date between :fromDate AND :toDate AND  v.veh_id =:vehId AND v.memo_header_id=m.memo_header_id AND m.veh_id = h.veh_id",nativeQuery=true)
	List<GetVoucherReport> getVoucherReport(@Param("vehId")int vehId,@Param("fromDate")String fromDate,@Param("toDate")String toDate);

}
