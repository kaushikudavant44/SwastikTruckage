package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="t_bill_details")
@EntityListeners(AuditingEntityListener.class)
public class TransactionBillDetails {
		

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bill_detail_id",length=11)
	private int billDetailId;
	
	@Column(name="bill_header_id",length=11)
	private int billHeaderId;
	
	@Column(name="lr_header_id",length=11)
	private int lrHeaderId;

	public int getBillDetailId() {
		return billDetailId;
	}

	public void setBillDetailId(int billDetailId) {
		this.billDetailId = billDetailId;
	}

	public int getBillHeaderId() {
		return billHeaderId;
	}

	public void setBillHeaderId(int billHeaderId) {
		this.billHeaderId = billHeaderId;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	@Override
	public String toString() {
		return "TransactionBillDetails [billDetailId=" + billDetailId + ", billHeaderId=" + billHeaderId
				+ ", lrHeaderId=" + lrHeaderId + "]";
	}

	
	
}
