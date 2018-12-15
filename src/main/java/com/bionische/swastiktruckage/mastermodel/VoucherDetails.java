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
@Table(name="t_voucher")
@EntityListeners(AuditingEntityListener.class)
public class VoucherDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="voucher_id")
	private int voucherId;
	
	@Column(name="voucher_no")
	private int voucherNo;
	
	@Column(name="memo_header_id")
	private int memoHeaderId;
	
	@Column(name="voucher_amount")
	private float voucherAmount;
	
	@Column(name="driver_id")
	private int driverId;
	
	@Column(name="veh_id")
	private int vehId;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	@Column(name="create_date",updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modifiedDate;

	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public int getVoucherNo() {
		return voucherNo;
	}

	public void setVoucherNo(int voucherNo) {
		this.voucherNo = voucherNo;
	}

	public int getMemoHeaderId() {
		return memoHeaderId;
	}

	public void setMemoHeaderId(int memoHeaderId) {
		this.memoHeaderId = memoHeaderId;
	}

	public float getVoucherAmount() {
		return voucherAmount;
	}

	public void setVoucherAmount(float voucherAmount) {
		this.voucherAmount = voucherAmount;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
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

	@Override
	public String toString() {
		return "VoucherDetails [voucherId=" + voucherId + ", voucherNo=" + voucherNo + ", memoHeaderId=" + memoHeaderId
				+ ", voucherAmount=" + voucherAmount + ", driverId=" + driverId + ", vehId=" + vehId + ", isUsed="
				+ isUsed + ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
	

}
