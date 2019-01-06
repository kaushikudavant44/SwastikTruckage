package com.bionische.swastiktruckage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetVoucherReport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="voucher_id")
	private int voucherId;
	
	@Column(name="memo_header_id")
	private int memoHeaderId;
	
	@Column(name="memo_no")	
	private int memoNo;
	
	@Column(name="veh_id")
	private int vehId;
	
	@Column(name="driver_id")
	private int driverId;
	
	@Column(name="office_id")
	private int officeId;
	
	@Column(name="to_id")
	private int toId;
	
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="veh_no")
	private String vehNo;
	
	@Column(name="office_address")
	private String officeAddress;
	
	@Column(name="to_address")
	private String toAddress;

	@Column(name="create_date")
	private String createDate;	
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public int getMemoHeaderId() {
		return memoHeaderId;
	}

	public void setMemoHeaderId(int memoHeaderId) {
		this.memoHeaderId = memoHeaderId;
	}

	public int getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	@Override
	public String toString() {
		return "GetVoucherReport [voucherId=" + voucherId + ", memoHeaderId=" + memoHeaderId + ", memoNo=" + memoNo
				+ ", vehId=" + vehId + ", driverId=" + driverId + ", officeId=" + officeId + ", toId=" + toId
				+ ", staffId=" + staffId + ", vehNo=" + vehNo + ", officeAddress=" + officeAddress + ", toAddress="
				+ toAddress + ", createDate=" + createDate + "]";
	}

	

}
