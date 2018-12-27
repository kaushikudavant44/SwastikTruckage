package com.bionische.swastiktruckage.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="m_main_menu")
public class NavBarMainMenu {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="menu_id",length=11)
	private int menuId;
	
	@Column(name="menu_name",length=200)
	private String menuName;
	
	@Column(name="order_by",length=11)
	private int orderBy;
	
	@Transient
	List<NavBarSubMainMenu> navBarSubMainMenuList;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public List<NavBarSubMainMenu> getNavBarSubMainMenuList() {
		return navBarSubMainMenuList;
	}

	public void setNavBarSubMainMenuList(List<NavBarSubMainMenu> navBarSubMainMenuList) {
		this.navBarSubMainMenuList = navBarSubMainMenuList;
	}

	@Override
	public String toString() {
		return "NavBarMainMenu [menuId=" + menuId + ", menuName=" + menuName + ", orderBy=" + orderBy
				+ ", navBarSubMainMenuList=" + navBarSubMainMenuList + "]";
	}
	
	
}
