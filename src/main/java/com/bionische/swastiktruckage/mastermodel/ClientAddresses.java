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
@Table(name="m_clients_addresses")
@EntityListeners(AuditingEntityListener.class)
public class ClientAddresses {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="address_id",length=11)
	private int addressId;
	
	@Column(name="client_id",length=200)
	private int clientId;
	
	@Column(name="state_id",length=11)
	private int stateId;
	
	@Column(name="city_id",length=11)
	private int cityId;
	
	@Column(name="address",length=50)
	private String address;
	
	@Column(name="contact_no",length=50)
	private String contactNo;
	
	@Column(name="pincode",length=11)
	private int pincode;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "ClientAddresses [addressId=" + addressId + ", clientId=" + clientId + ", stateId=" + stateId
				+ ", cityId=" + cityId + ", address=" + address + ", contactNo=" + contactNo + ", pincode=" + pincode
				+ ", isUsed=" + isUsed + "]";
	}

	
}
