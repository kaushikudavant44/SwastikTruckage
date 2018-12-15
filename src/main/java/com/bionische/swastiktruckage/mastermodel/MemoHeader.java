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
@Table(name="t_memo_header")
@EntityListeners(AuditingEntityListener.class)
public class MemoHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="memo_header_id",length=11)
	private int memoHeaderId;
	
	@Column(name="memo_no",length=11)
	private int memoNo;
	
	@Column(name="veh_id",length=11)
	private int vehId;
	
	@Column(name="driver_id",length=11)
	private int driverId;
	
	@Column(name="office_id",length=11)
	private int officeId;
	
	@Column(name="staff_id",length=11)
	private int staffId;
	
	@Column(name="is_used",length=11)
	private boolean isUsed;
	
	@Column(name="created_date",updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdDate;
	
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modifiedDate;

	public int getMemoHeaderId() {
		return memoHeaderId;
	}

	public void setMemoHeaderId(int memoHeaderId) {
		this.memoHeaderId = memoHeaderId;
	}

	public int getMemoNo() {
		return memoNo;
	}

	public void setMemoNo(int memoNo) {
		this.memoNo = memoNo;
	}

	public int getVehId() {
		return vehId;
	}

	public void setVehId(int vehId) {
		this.vehId = vehId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "MemoHeader [memoHeaderId=" + memoHeaderId + ", memoNo=" + memoNo + ", vehId=" + vehId + ", driverId="
				+ driverId + ", officeId=" + officeId + ", staffId=" + staffId + ", isUsed=" + isUsed + ", createdDate="
				+ createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
	
	
}
