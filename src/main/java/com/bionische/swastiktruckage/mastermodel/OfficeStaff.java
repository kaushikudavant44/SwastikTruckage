package com.bionische.swastiktruckage.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="m_office_staff")
@EntityListeners(AuditingEntityListener.class)
public class OfficeStaff {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="staff_id",length=11)
	private int staffId;
	
	@Column(name="staff_office_id",length=11)
	private int staffOfficeId;
	
	@Column(name="staff_name",length=200)
	private String staffName;
	
	@Column(name="staff_contact_no",length=13)
	private String staffContactNo;
	
	@Column(name="staff_address",length=200)
	private String staffAddress;
	
	@Column(name="user_name",length=200)
	private String userName;
	
	@Column(name="password",length=200)
	private String password;
	
	@Column(name="role_id",length=200)
	private int roleId;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	public Date getCreateDate() {
		return createDate;
	}


	public Date getModifiedDate() {
		return modifiedDate;
	}

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

	@Override
	public String toString() {
		return "OfficeStaff [staffId=" + staffId + ", staffOfficeId=" + staffOfficeId + ", staffName=" + staffName
				+ ", staffContactNo=" + staffContactNo + ", staffAddress=" + staffAddress + ", userName=" + userName
				+ ", password=" + password + ", roleId=" + roleId + ", isUsed=" + isUsed + "]";
	}
	
	
	
	
}
