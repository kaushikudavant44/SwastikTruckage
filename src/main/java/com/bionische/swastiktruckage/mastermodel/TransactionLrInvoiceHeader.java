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
@Table(name="t_lr_invoice_header")
@EntityListeners(AuditingEntityListener.class)
public class TransactionLrInvoiceHeader {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="inv_header_id",length=11)
	private int invHeaderId;
	
	@Column(name="is_used")
	private boolean isUsed;

	public int getInvHeaderId() {
		return invHeaderId;
	}

	public void setInvHeaderId(int invHeaderId) {
		this.invHeaderId = invHeaderId;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "TransactionLrInvoiceHeader [invHeaderId=" + invHeaderId + ", isUsed=" + isUsed + "]";
	}
	
	

}
