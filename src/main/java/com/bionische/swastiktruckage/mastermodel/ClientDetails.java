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
@Table(name="m_clients")
@EntityListeners(AuditingEntityListener.class)
public class ClientDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="client_id",length=11)
	private int clientId;
	
	@Column(name="client_name",length=200)
	private String clientName;
	
	@Column(name="client_address",length=200)
	private String clientAddress;
	
	@Column(name="state_id",length=11)
	private int stateId;
	
	@Column(name="city_id",length=11)
	private int cityId;
	
	@Column(name="pincode",length=11)
	private int pincode;
	
	@Column(name="client_contact_no",length=50)
	private String clientContactNo;
	
	@Column(name="gstin",length=11)
	private float gstin;
	
	@Column(name="is_used")
	private boolean isUsed;


	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
		 
		
	}

	
	public String getClientContactNo() {
		return clientContactNo;
	}

	public void setClientContactNo(String clientContactNo) {
		this.clientContactNo = clientContactNo;
	}


	public float getGstin() {
		return gstin;
	}

	public void setGstin(float gstin) {
		this.gstin = gstin;
	}

	@Override
	public String toString() {
		return "ClientDetails [clientId=" + clientId + ", clientName=" + clientName + ", clientAddress=" + clientAddress
				+ ", stateId=" + stateId + ", cityId=" + cityId + ", pincode=" + pincode + ", clientContactNo="
				+ clientContactNo + ", gstin=" + gstin + ", isUsed=" + isUsed + "]";
	}

	


}
