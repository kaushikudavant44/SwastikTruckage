package com.bionische.swastiktruckage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="m_sub_menu")
public class NavBarSubMainMenu {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sub_menu_id",length=11)
	private int subMenuId;
	
	@Column(name="menu_id",length=11)
	private int menuId;
	
	@Column(name="sub_menu_name",length=200)
	private String subMenuName;
	
	@Column(name="sub_menu_url",length=200)
	private String subMenuUrl;
	
	@Column(name="m_add",length=11)
	private int add;
	
	@Column(name="edit",length=11)
	private int edit;
	
	@Column(name="m_delete",length=11)
	private int mdelete;
	
	@Column(name="view",length=11)
	private int view;
	
	@Column(name="order_by",length=11)
	private int orderBy;
	
	@Column(name="is_used")
	private boolean isUsed;

	public int getSubMenuId() {
		return subMenuId;
	}

	public void setSubMenuId(int subMenuId) {
		this.subMenuId = subMenuId;
	}

	public int getMenuId() {
		return menuId;
	}
 
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public String getSubMenuUrl() {
		return subMenuUrl;
	}

	public void setSubMenuUrl(String subMenuUrl) {
		this.subMenuUrl = subMenuUrl;
	}

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}

	public int getEdit() {
		return edit;
	}

	public void setEdit(int edit) {
		this.edit = edit;
	}

 

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getMdelete() {
		return mdelete;
	}

	public void setMdelete(int mdelete) {
		this.mdelete = mdelete;
	}

	@Override
	public String toString() {
		return "NavBarSubMainMenu [subMenuId=" + subMenuId + ", menuId=" + menuId + ", subMenuName=" + subMenuName
				+ ", subMenuUrl=" + subMenuUrl + ", add=" + add + ", edit=" + edit + ", mdelete=" + mdelete + ", view="
				+ view + ", orderBy=" + orderBy + ", isUsed=" + isUsed + "]";
	}

	 
	
	
}
