package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleDriverWithVehNo {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="driver_id",length=11)
	private int driverId;
	
	@Column(name="veh_id",length=200)
	private int vehId;
	
	@Column(name="driver_name",length=200)
	private String driverName;
	
	@Column(name="driver_license_no",length=200)
	private String driverLicenseNo;
	
	@Column(name="driver_contact_no",length=200)
	private String driverContactNo;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	@Column(name="veh_no",length=11)
	private String vehNo;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	

	public String getDriverLicenseNo() {
		return driverLicenseNo;
	}

	public void setDriverLicenseNo(String driverLicenseNo) {
		this.driverLicenseNo = driverLicenseNo;
	}

	public String getDriverContactNo() {
		return driverContactNo;
	}

	public void setDriverContactNo(String driverContactNo) {
		this.driverContactNo = driverContactNo;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getVehNo() {
		return vehNo;
	}

	public void setVehNo(String vehNo) {
		this.vehNo = vehNo;
	}

	@Override
	public String toString() {
		return "VehicleDriverWithVehNo [driverId=" + driverId + ", vehId=" + vehId + ", driverName=" + driverName
				+ ", driverLicenseNo=" + driverLicenseNo + ", driverContactNo=" + driverContactNo + ", isUsed=" + isUsed
				+ ", vehNo=" + vehNo + "]";
	}

	
	
	

}
