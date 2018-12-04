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
@Table(name="t_bill_header")
@EntityListeners(AuditingEntityListener.class)
public class TransactionBillHeader {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_header_id",length=11)
	private int billHeaderId;
	
	@Column(name="bill_no",length=11)
	private int billNo;
	
	@Column(name="bill_date",length=200)
	private String billDate;
	
	@Column(name="bill_to",length=11)
	private int billTo;
	
	@Column(name="bill_total")
	private float billTotal;
	
	@Column(name="gst_payable_by",length=11)
	private int gstPayableBy;
	
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

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
	}

	public int getBillTo() {
		return billTo;
	}

	public void setBillTo(int billTo) {
		this.billTo = billTo;
	}

	public float getBillTotal() {
		return billTotal;
	}

	public void setBillTotal(float billTotal) {
		this.billTotal = billTotal;
	}

	public int getGstPayableBy() {
		return gstPayableBy;
	}

	public void setGstPayableBy(int gstPayableBy) {
		this.gstPayableBy = gstPayableBy;
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

	@Override
	public String toString() {
		return "TransactionBillHeader [billHeaderId=" + billHeaderId + ", billNo=" + billNo + ", billDate=" + billDate
				+ ", billTo=" + billTo + ", billTotal=" + billTotal + ", gstPayableBy=" + gstPayableBy + ", billStatus="
				+ billStatus + ", billPayableBy=" + billPayableBy + ", isUsed=" + isUsed + ", createDate=" + createDate
				+ ", modifiedDate=" + modifiedDate + "]";
	}

	
}
