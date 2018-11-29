package com.bionische.swastiktruckage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetStaffDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="staff_office_id")
	private int staffOfficeId;
	
	@Column(name="staff_name")
	private String staffName;
	
	@Column(name="staff_contact_no")
	private String staffContactNo;
	
	@Column(name="staff_address")
	private String staffAddress;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role_id")
	private int roleId;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	@Column(name="role_name")
	private String roleName;
	
	@Column(name="office_name")
	private String officeName;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getStaffOfficeId() {
		return staffOfficeId;
	}

	public void setStaffOfficeId(int staffOfficeId) {
		this.staffOfficeId = staffOfficeId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffContactNo() {
		return staffContactNo;
	}

	public void setStaffContactNo(String staffContactNo) {
		this.staffContactNo = staffContactNo;
	}

	public String getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	@Override
	public String toString() {
		return "GetStaffDetails [staffId=" + staffId + ", staffOfficeId=" + staffOfficeId + ", staffName=" + staffName
				+ ", staffContactNo=" + staffContactNo + ", staffAddress=" + staffAddress + ", userName=" + userName
				+ ", password=" + password + ", roleId=" + roleId + ", isUsed=" + isUsed + ", roleName=" + roleName
				+ ", officeName=" + officeName + "]";
	}
	
	
	
}
