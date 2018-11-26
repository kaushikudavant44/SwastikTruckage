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
@Table(name="t_lr_invoice_detail")
@EntityListeners(AuditingEntityListener.class)
public class TransactionLrInvoiceDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="detail_id",length=11)
	private int detailId;
	
	@Column(name="inv_header_id",length=200)
	private int invHeaderId;
	
	@Column(name="inv_no",length=200)
	private int invNo;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getInvHeaderId() {
		return invHeaderId;
	}

	public void setInvHeaderId(int invHeaderId) {
		this.invHeaderId = invHeaderId;
	}

	public int getInvNo() {
		return invNo;
	}

	public void setInvNo(int invNo) {
		this.invNo = invNo;
	}

	@Override
	public String toString() {
		return "TransactionLrInvoiceDetail [detailId=" + detailId + ", invHeaderId=" + invHeaderId + ", invNo=" + invNo
				+ "]";
	}
	
	
	

}
