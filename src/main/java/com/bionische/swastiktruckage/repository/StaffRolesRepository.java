package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.mastermodel.StaffRoles;

public interface StaffRolesRepository extends JpaRepository<StaffRoles, Integer>{
	
	StaffRoles save(StaffRoles staffRoles);
	
	StaffRoles findByRoleId(int roleId);
	
	StaffRoles findByStaffId(int staffId);
	
	
	List<StaffRoles> findAll();
}
