package com.bionische.swastiktruckage.model;

import java.util.List;

import javax.persistence.Column;

public class ShowAllMemo {

private int memoHeaderId;
	
	
	private String officeName;
	
	private int memoNo;
	
	
	private String driverName;
	
	
	private int officeId;
	
	
	private int staffId;
	
	
	private int vehId;
	
	private String vehNo;
	
	private int driverId;
	
	//private int lrHeaderId;
	List<Integer> lrHeaderIdList;

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

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public List<Integer> getLrHeaderIdList() {
		return lrHeaderIdList;
	}

	public void setLrHeaderIdList(List<Integer> lrHeaderIdList) {
		this.lrHeaderIdList = lrHeaderIdList;
	}

	@Override
	public String toString() {
		return "ShowAllMemo [memoHeaderId=" + memoHeaderId + ", officeName=" + officeName + ", memoNo=" + memoNo
				+ ", driverName=" + driverName + ", officeId=" + officeId + ", staffId=" + staffId + ", vehId=" + vehId
				+ ", vehNo=" + vehNo + ", driverId=" + driverId + ", lrHeaderIdList=" + lrHeaderIdList + "]";
	}
	
	
	
}
