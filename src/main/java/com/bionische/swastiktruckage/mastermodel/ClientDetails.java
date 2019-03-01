package com.bionische.swastiktruckage.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="m_clients")
@EntityListeners(AuditingEntityListener.class)
public class ClientDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="client_id",length=11)
	private int clientId;
	
	@Column(name="client_name",length=200)
	private String clientName;
	
	@Column(name="billing_name",length=200)
	private String billingName;
	
	@Column(name="client_address",length=200)
	private String clientAddress;
	
	@Column(name="state_id",length=11)
	private int stateId;
	
	@Column(name="city_id",length=11)
	private int cityId;
	
	@Column(name="pincode",length=11)
	private int pincode;
	
	@Column(name="client_contact_no",length=200)
	private String clientContactNo;
	
	@Column(name="gstin",length=15)
	private String gstin;
	
	@Column(name="is_used")
	private boolean isUsed;


/*	@Column(name="create_date",updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modifiedDate;*/
	
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


	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	
	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	@Override
	public String toString() {
		return "ClientDetails [clientId=" + clientId + ", clientName=" + clientName + ", billingName=" + billingName
				+ ", clientAddress=" + clientAddress + ", stateId=" + stateId + ", cityId=" + cityId + ", pincode="
				+ pincode + ", clientContactNo=" + clientContactNo + ", gstin=" + gstin + ", isUsed=" + isUsed + "]";
	}

	
}
