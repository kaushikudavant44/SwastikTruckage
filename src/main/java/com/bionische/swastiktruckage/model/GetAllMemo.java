package com.bionische.swastiktruckage.model;

import java.util.List;

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
	
	@Column(name="office_name")
	private String officeName;
	
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

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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
		return "GetAllMemo [memoHeaderId=" + memoHeaderId + ", officeName=" + officeName + ", memoNo=" + memoNo
				+ ", driverName=" + driverName + ", officeId=" + officeId + ", staffId=" + staffId + ", vehId=" + vehId
				+ ", vehNo=" + vehNo + ", driverId=" + driverId + "]";
	}

	

	

	

	
	
	
}
