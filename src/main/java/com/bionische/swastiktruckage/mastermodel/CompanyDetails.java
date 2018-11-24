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
@Table(name="m_company")
@EntityListeners(AuditingEntityListener.class)
public class CompanyDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_id",length=11)
	int companyId;
	
	@Column(name="company_name",length=300)
	String companyName;
	
	@Column(name="address",length=500)
	String address;
	
	@Column(name="city_id",length=11)
	int cityId;
	
	@Column(name="state_id",length=11)
	int stateId;
	
	@Column(name="country_no1",length=13)
	String contactNo1;
	
	@Column(name="country_no2",length=13)
	String contactNo2;
	
	@Column(name="country_no3",length=13)
	String contactNo3;
	
	@Column(name="gstin",length=12)
	String gstin;
	
	@Column(name="sac_code",length=12)
	String sacCode;
	
	@Column(name="pan_no",length=12)
	String panNo;
	
	@Column(name="email_id",length=100)
	String email;
	
	@Column(name="helpline_no",length=12)
	String helplineNo;
	
	@Column(name="website",length=200)
	String website;
	
	@Column(name="bank_name",length=500)
	String bankName;
	
	@Column(name="bank_branch",length=100)
	String bankbranch;
	
	@Column(name="acc_no",length=20)
	String accNo;
	
	@Column(name="micr_no",length=20)
	String micrNo;
	
	@Column(name="rtgs_code",length=20)
	String rtgsCode;

	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(String contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public String getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(String contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public String getContactNo3() {
		return contactNo3;
	}

	public void setContactNo3(String contactNo3) {
		this.contactNo3 = contactNo3;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public String getSacCode() {
		return sacCode;
	}

	public void setSacCode(String sacCode) {
		this.sacCode = sacCode;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHelplineNo() {
		return helplineNo;
	}

	public void setHelplineNo(String helplineNo) {
		this.helplineNo = helplineNo;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankbranch() {
		return bankbranch;
	}

	public void setBankbranch(String bankbranch) {
		this.bankbranch = bankbranch;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public String getMicrNo() {
		return micrNo;
	}

	public void setMicrNo(String micrNo) {
		this.micrNo = micrNo;
	}

	public String getRtgsCode() {
		return rtgsCode;
	}

	public void setRtgsCode(String rtgsCode) {
		this.rtgsCode = rtgsCode;
	}

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

	@Override
	public String toString() {
		return "CompanyDetails [companyId=" + companyId + ", companyName=" + companyName + ", address=" + address
				+ ", cityId=" + cityId + ", stateId=" + stateId + ", contactNo1=" + contactNo1 + ", contactNo2="
				+ contactNo2 + ", contactNo3=" + contactNo3 + ", gstin=" + gstin + ", sacCode=" + sacCode + ", panNo="
				+ panNo + ", email=" + email + ", helplineNo=" + helplineNo + ", website=" + website + ", bankName="
				+ bankName + ", bankbranch=" + bankbranch + ", accNo=" + accNo + ", micrNo=" + micrNo + ", rtgsCode="
				+ rtgsCode + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	

}
