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
@Table(name="t_bill_payments")
@EntityListeners(AuditingEntityListener.class)
public class TransactionBillPayments {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id",length=11)
	private int paymentId;
	
	@Column(name="bill_header_id",length=11)
	private int billHeaderId;
	
	@Column(name="amount_received",length=11)
	private float amountReceived;
	
	@Column(name="payment_mode",length=200)
	private int paymentMode;
	
	@Column(name="tr_id",length=200)
	private int trId;
	
	@Column(name="staff_id",length=200)
	private int staffId;
	
	@Column(name="payment_date",length=200)
	private String paymentDate;
	
	@Column(name="entry_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date entryDatetime;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public int getBillHeaderId() {
		return billHeaderId;
	}

	public void setBillHeaderId(int billHeaderId) {
		this.billHeaderId = billHeaderId;
	}

	public float getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(float amountReceived) {
		this.amountReceived = amountReceived;
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

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Date getEntryDatetime() {
		return entryDatetime;
	}

	public void setEntryDatetime(Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

	@Override
	public String toString() {
		return "TransactionBillPayments [paymentId=" + paymentId + ", billHeaderId=" + billHeaderId
				+ ", amountReceived=" + amountReceived + ", paymentMode=" + paymentMode + ", trId=" + trId
				+ ", staffId=" + staffId + ", paymentDate=" + paymentDate + ", entryDatetime=" + entryDatetime + "]";
	}

	
}
