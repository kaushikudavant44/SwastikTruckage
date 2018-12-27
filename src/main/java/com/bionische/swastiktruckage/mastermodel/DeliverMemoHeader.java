package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="t_delivery_memo_header")
@EntityListeners(AuditingEntityListener.class)
public class DeliverMemoHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="deli_memo_header_id",length=11)
	private int deliMemoHeaderId;
	
	@Column(name="deli_memo_date")
	private String deliMemoDate;
	
	@Column(name="vehicle_id")
	private int vehicleId;
	
	@Column(name="office_id")
	private int officeId;
	
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="local_memo_no")
	private int localMemoNo;

	@Column(name="driver_id")
	private int driverId;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	

	public int getLocalMemoNo() {
		return localMemoNo;
	}

	public void setLocalMemoNo(int localMemoNo) {
		this.localMemoNo = localMemoNo;
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

	

	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
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

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	@Override
	public String toString() {
		return "DeliverMemoHeader [deliMemoHeaderId=" + deliMemoHeaderId + ", deliMemoDate=" + deliMemoDate
				+ ", vehicleId=" + vehicleId + ", officeId=" + officeId + ", staffId=" + staffId + ", localMemoNo="
				+ localMemoNo + ", driverId=" + driverId + "]";
	}

	

	

	


	
	
	
	

}
