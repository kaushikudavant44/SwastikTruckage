package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.swastiktruckage.model.GetStaffDetails;

public interface GetStaffDetailsRepository extends JpaRepository<GetStaffDetails,Integer>{
	
	@Query(value="SELECT s.staff_id,s.is_used,s.password,s.role_id,s.staff_address,s.staff_contact_no,s.staff_name,s.staff_office_id, " + 
			"s.user_name, o.office_name FROM m_office_staff s,m_office o WHERE s.staff_office_id=o.office_id  " + 
			"AND s.is_used=TRUE",nativeQuery=true)
	List<GetStaffDetails> findAllStaff();
	
}
