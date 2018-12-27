package com.bionische.swastiktruckage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class GetPaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="bill_header_id",length=11)
	private int billHeaderId;
	
	@Column(name="bill_no",length=11)
	private int billNo;
	
	@Column(name="bill_to",length=11)
	private int billTo;
	
	@Column(name="bill_date",length=200)
	private String billDate;
	
	@Column(name="bill_total")
	private float billTotal;
	
	@Column(name="bill_status",length=11)
	private int billStatus;
	
	@Column(name="bill_payable_by",length=11)
	private int billPayableBy;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
	@Column(name="amount_received",length=11)
	private float amountReceived;
	
	@Column(name="client_name",length=200)
	private String clientName;

	public int getBillHeaderId() {
		return billHeaderId;
	}

	public void setBillHeaderId(int billHeaderId) {
		this.billHeaderId = billHeaderId;
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public int getBillTo() {
		return billTo;
	}

	public void setBillTo(int billTo) {
		this.billTo = billTo;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	public int getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(int billStatus) {
		this.billStatus = billStatus;
	}

	public int getBillPayableBy() {
		return billPayableBy;
	}

	public void setBillPayableBy(int billPayableBy) {
		this.billPayableBy = billPayableBy;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
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

	public float getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(float amountReceived) {
		this.amountReceived = amountReceived;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "GetPaymentDetails [billHeaderId=" + billHeaderId + ", billNo=" + billNo + ", billTo=" + billTo
				+ ", billDate=" + billDate + ", billTotal=" + billTotal + ", billStatus=" + billStatus
				+ ", billPayableBy=" + billPayableBy + ", isUsed=" + isUsed + ", createDate=" + createDate
				+ ", modifiedDate=" + modifiedDate + ", amountReceived=" + amountReceived + ", clientName=" + clientName
				+ "]";
	}
	
	
	
}
