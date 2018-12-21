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
@Table(name="m_vehicles")
@EntityListeners(AuditingEntityListener.class)
public class VehicleDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="veh_id",length=11)
	private int vehId;
	
	@Column(name="veh_no",length=11)
	private String vehNo;
	
	@Column(name="owner_id",length=11)
	private int ownerId;

	@Column(name="is_used")
	private boolean isUsed;
	
	
	
	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
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

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	@Override
	public String toString() {
		return "VehicleDetails [vehId=" + vehId + ", vehNo=" + vehNo + ", ownerId=" + ownerId + ", isUsed=" + isUsed
				+ "]";
	}

	

}
