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

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="m_lr_logs")
@EntityListeners(AuditingEntityListener.class)
public class LrLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="log_id",length=11)
	private int logId;
	
	@Column(name="lr_no",length=11)
	private int lrNo;
	
	@Column(name="modified_by_id",length=11)
	private int modifiedById;
	
	@Column(name="modified_by_office",length=11)
	private int modifiedByOffice;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getLrNo() {
		return lrNo;
	}

	public void setLrNo(int lrNo) {
		this.lrNo = lrNo;
	}

	public int getModifiedById() {
		return modifiedById;
	}

	public void setModifiedById(int modifiedById) {
		this.modifiedById = modifiedById;
	}

	public int getModifiedByOffice() {
		return modifiedByOffice;
	}

	public void setModifiedByOffice(int modifiedByOffice) {
		this.modifiedByOffice = modifiedByOffice;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "LrLogs [logId=" + logId + ", lrNo=" + lrNo + ", modifiedById=" + modifiedById + ", modifiedByOffice="
				+ modifiedByOffice + "]";
	}

	
	
	
	
	
}
