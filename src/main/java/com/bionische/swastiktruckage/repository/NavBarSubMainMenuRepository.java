package com.bionische.swastiktruckage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.swastiktruckage.model.NavBarSubMainMenu;

public interface NavBarSubMainMenuRepository extends JpaRepository<NavBarSubMainMenu, Integer>{

	
	List<NavBarSubMainMenu> findByIsUsed(boolean isUsed);
	List<NavBarSubMainMenu> findByIsUsedAndMenuId(boolean isUsed, int menuId);
}
