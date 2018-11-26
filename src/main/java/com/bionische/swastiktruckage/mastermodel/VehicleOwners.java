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
@Table(name="m_vehicle_owners")
@EntityListeners(AuditingEntityListener.class)
public class VehicleOwners {
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="owner_id",length=11)
	private int ownerId;
	
	@Column(name="owner_name",length=200)
	private String ownerName;
	
	@Column(name="owner_contact_no",length=200)
	private String ownerContactNo;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerContactNo() {
		return ownerContactNo;
	}

	public void setOwnerContactNo(String ownerContactNo) {
		this.ownerContactNo = ownerContactNo;
	}

	@Override
	public String toString() {
		return "VehicleOwners [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerContactNo=" + ownerContactNo
				+ ", isUsed=" + isUsed + "]";
	}

	
	

}
