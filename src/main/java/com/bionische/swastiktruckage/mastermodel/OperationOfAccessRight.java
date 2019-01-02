package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OperationOfAccessRight {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="sub_menu_id",length=11)
	private int subMenuId;
	
	@Column(name="menu_id",length=11)
	private int menuId;
	
	@Column(name="m_add",length=11)
	private int add;
	
	@Column(name="edit",length=11)
	private int edit;
	
	@Column(name="m_delete",length=11)
	private int mdelete;
	
	@Column(name="view",length=11)
	private int view;

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

	public int getMdelete() {
		return mdelete;
	}

	public void setMdelete(int mdelete) {
		this.mdelete = mdelete;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	@Override
	public String toString() {
		return "OperationOfAccessRight [subMenuId=" + subMenuId + ", menuId=" + menuId + ", add=" + add + ", edit="
				+ edit + ", mdelete=" + mdelete + ", view=" + view + "]";
	}
	
	
	
}
