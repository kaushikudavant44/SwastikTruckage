package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetDeliverMemoHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="deli_memo_header_id",length=11)
	private int deliMemoHeaderId;
	
	@Column(name="deli_memo_date")
	private String deliMemoDate;
	
	@Column(name="veh_no")
	private String vehNo;
	
	@Column(name="vehicle_id")
	private int vehicleId;
	
	@Column(name="office_id")
	private int officeId;
	
	@Column(name="office_name")
	private String officeName;
	
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="staff_name")
	private String staffName;
	
	@Column(name="local_memo_no")
	private int localMemoNo;
	
	@Column(name="driver_id")
	private int driverId;
	
	@Column(name="driver_name")
	private String driverName;
	
	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getDeliMemoHeaderId() {
		return deliMemoHeaderId;
	}

	public void setDeliMemoHeaderId(int deliMemoHeaderId) {
		this.deliMemoHeaderId = deliMemoHeaderId;
	}

	public String getDeliMemoDate() {
		return deliMemoDate;
	}

	public void setDeliMemoDate(String deliMemoDate) {
		this.deliMemoDate = deliMemoDate;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getLocalMemoNo() {
		return localMemoNo;
	}

	public void setLocalMemoNo(int localMemoNo) {
		this.localMemoNo = localMemoNo;
	}

	@Override
	public String toString() {
		return "GetDeliverMemoHeader [deliMemoHeaderId=" + deliMemoHeaderId + ", deliMemoDate=" + deliMemoDate
				+ ", vehNo=" + vehNo + ", vehicleId=" + vehicleId + ", officeId=" + officeId + ", officeName="
				+ officeName + ", staffId=" + staffId + ", staffName=" + staffName + ", localMemoNo=" + localMemoNo
				+ ", driverId=" + driverId + ", driverName=" + driverName + "]";
	}

	
	
	
	

}
