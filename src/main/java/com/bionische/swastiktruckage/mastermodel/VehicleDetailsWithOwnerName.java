package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleDetailsWithOwnerName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="veh_id")
	private int vehId;
	
	@Column(name="veh_no")
	private String vehNo;
	
	@Column(name="owner_id")
	private int ownerId;

	@Column(name="is_used")
	private boolean isUsed;
	
	@Column(name="owner_name")
	private String ownerName;

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

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "VehicleDetailsWithOwnerName [vehId=" + vehId + ", vehNo=" + vehNo + ", ownerId=" + ownerId + ", isUsed="
				+ isUsed + ", ownerName=" + ownerName + "]";
	}
	
	

}
