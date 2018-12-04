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
@Table(name="t_bill_logs")
@EntityListeners(AuditingEntityListener.class)
public class TransactionBillLogs {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="log_id",length=11)
	private int logId;
	
	@Column(name="bill_header_id",length=11)
	private int billHeaderId;
	
	@Column(name="modified_by_office",length=11)
	private int modifiedByOffice;
	
	@Column(name="modified_by_id",length=11)
	private int modifiedById;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getModifiedByOffice() {
		return modifiedByOffice;
	}

	public void setModifiedByOffice(int modifiedByOffice) {
		this.modifiedByOffice = modifiedByOffice;
	}

	public int getModifiedById() {
		return modifiedById;
	}

	public void setModifiedById(int modifiedById) {
		this.modifiedById = modifiedById;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getBillHeaderId() {
		return billHeaderId;
	}

	public void setBillHeaderId(int billHeaderId) {
		this.billHeaderId = billHeaderId;
	}

	@Override
	public String toString() {
		return "TransactionBillLogs [logId=" + logId + ", billHeaderId=" + billHeaderId + ", modifiedByOffice="
				+ modifiedByOffice + ", modifiedById=" + modifiedById + ", modifiedDate=" + modifiedDate + "]";
	}

	
}
