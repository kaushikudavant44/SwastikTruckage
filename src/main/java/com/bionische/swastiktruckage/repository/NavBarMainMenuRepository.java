package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.model.NavBarMainMenu;

public interface NavBarMainMenuRepository extends JpaRepository<NavBarMainMenu, Integer>{

	NavBarMainMenu findByMenuId(int menuId);
	
	List<NavBarMainMenu> findAll();
	
}
