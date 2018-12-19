package com.bionische.swastiktruckage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetAllMemo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="memo_header_id")
	private int memoHeaderId;
	
	@Column(name="from_office")
	private String fromOffice;
	
	@Column(name="to_office")
	private String toOffice;
	
	@Column(name="to_id")
	private int toId;
	
	@Column(name="memo_no")
	private int memoNo;
	
	@Column(name="driverName")
	private String driverName;
	
	@Column(name="office_id")
	private int officeId;
	
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="veh_id")
	private int vehId;
	
	@Column(name="veh_no")
	private String vehNo;
	
	@Column(name="driver_id")
	private int driverId;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="office_address")
	private String officeAddress;
	
	@Column(name="owner_name")
	private String ownerName;
	
	@Column(name="driver_license_no")
	private String licenseNo;
	
	
	
	
	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getToOffice() {
		return toOffice;
	}

	public void setToOffice(String toOffice) {
		this.toOffice = toOffice;
	}

	
	

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	
	public int getMemoHeaderId() {
		return memoHeaderId;
	}

	public void setMemoHeaderId(int memoHeaderId) {
		this.memoHeaderId = memoHeaderId;
	}

	
	public String getFromOffice() {
		return fromOffice;
	}

	public void setFromOffice(String fromOffice) {
		this.fromOffice = fromOffice;
	}

	public int getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	@Override
	public String toString() {
		return "GetAllMemo [memoHeaderId=" + memoHeaderId + ", fromOffice=" + fromOffice + ", toOffice=" + toOffice
				+ ", toId=" + toId + ", memoNo=" + memoNo + ", driverName=" + driverName + ", officeId=" + officeId
				+ ", staffId=" + staffId + ", vehId=" + vehId + ", vehNo=" + vehNo + ", driverId=" + driverId
				+ ", createdDate=" + createdDate + ", officeAddress=" + officeAddress + ", ownerName=" + ownerName
				+ ", licenseNo=" + licenseNo + "]";
	}

	
	
}
