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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="t_lr_collection")
@EntityListeners(AuditingEntityListener.class)

public class TransactionLrCollection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="collection_id",length=11)
	private int collectionId;
	
	@Column(name="lr_header_id",length=11)
	private int lrHeaderId;
	
	@Column(name="lr_no",length=11)
	private int lrNo;
	
	@Column(name="total",length=200)
	private float total;
	
	@Column(name="payment_mode",length=11)
	private int paymentMode;
	
	@Column(name="tr_id",length=11)
	private int trId;
	
	@Column(name="staff_id",length=11)
	private int staffId;
	
	@Column(name="office_id",length=11)
	private int officeId;
	
	@Column(name="is_used",length=11)
	private boolean isUsed;
	
	@Column(name="create_date")
	@Temporal(TemporalType.DATE)
	@CreatedDate
	private Date createDate;
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	public int getLrNo() {
		return lrNo;
	}

	public void setLrNo(int lrNo) {
		this.lrNo = lrNo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(int paymentMode) {
		this.paymentMode = paymentMode;
	}

	public int getTrId() {
		return trId;
	}

	public void setTrId(int trId) {
		this.trId = trId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "TransactionLrCollection [collectionId=" + collectionId + ", lrHeaderId=" + lrHeaderId + ", lrNo=" + lrNo
				+ ", total=" + total + ", paymentMode=" + paymentMode + ", trId=" + trId + ", staffId=" + staffId
				+ ", officeId=" + officeId + ", isUsed=" + isUsed + ", createDate=" + createDate + "]";
	}

	
}
