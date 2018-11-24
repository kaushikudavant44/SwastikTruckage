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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="m_office")
@EntityListeners(AuditingEntityListener.class)
public class OfficeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="office_id",length=11)
	private int officeId;
	
	@Column(name="office_name",length=200)
	private String officeName;
	
	@Column(name="office_state_id",length=11)
	private int officeStateId;
	
	@Column(name="office_city_id",length=11)
	private int officeCityId;
	
	@Column(name="office_address",length=200)
	private String officeAddress;
	
	@Column(name="office_contact_no",length=13)
	private String officeContactNo;
	
	@Column(name="fax_no",length=20)
	private String faxNo;
	
	@Column(name="pincode",length=11)
	private int pincode;
	
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@Column(name="is_used")
	private boolean isUsed;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
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

	public int getOfficeStateId() {
		return officeStateId;
	}

	public void setOfficeStateId(int officeStateId) {
		this.officeStateId = officeStateId;
	}

	public int getOfficeCityId() {
		return officeCityId;
	}

	public void setOfficeCityId(int officeCityId) {
		this.officeCityId = officeCityId;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getOfficeContactNo() {
		return officeContactNo;
	}

	public void setOfficeContactNo(String officeContactNo) {
		this.officeContactNo = officeContactNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "OfficeDetails [officeId=" + officeId + ", officeName=" + officeName + ", officeStateId=" + officeStateId
				+ ", officeCityId=" + officeCityId + ", officeAddress=" + officeAddress + ", officeContactNo="
				+ officeContactNo + ", faxNo=" + faxNo + ", pincode=" + pincode + ", createDate=" + createDate
				+ ", modifiedDate=" + modifiedDate + ", isUsed=" + isUsed + "]";
	}
	
	
	
}
