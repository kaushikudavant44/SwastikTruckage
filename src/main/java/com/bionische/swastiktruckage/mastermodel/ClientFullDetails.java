package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClientFullDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="client_id")
	private int clientId;
	
	@Column(name="client_name")
	private String clientName;
	
	@Column(name="client_address")
	private String clientAddress;
	
	@Column(name="state_id")
	private int stateId;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="client_contact_no")
	private String clientContactNo;
	
	@Column(name="gstin")
	private String gstin;	

	@Column(name="city_name")
	private String cityName;
	
	@Column(name="state_name")
	private String stateName;

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

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "ClientFullDetails [clientId=" + clientId + ", clientName=" + clientName + ", clientAddress="
				+ clientAddress + ", stateId=" + stateId + ", cityId=" + cityId + ", pincode=" + pincode
				+ ", clientContactNo=" + clientContactNo + ", gstin=" + gstin + ", cityName=" + cityName
				+ ", stateName=" + stateName + "]";
	}
	
	


}
