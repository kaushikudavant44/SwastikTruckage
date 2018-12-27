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
@Table(name="t_delivery_memo_details")
@EntityListeners(AuditingEntityListener.class)
public class DeliverMemoDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="deli_memo_detail_id",length=11)
	private int deliMemoDetailId;
	
	@Column(name="deli_memo_header_id",length=11)
	private int deliMemoHeaderId;
	
	@Column(name="lr_header_id",length=11)
	private int lrHeaderId;

	@Column(name="delivery_status",length=11)
	private int deliveryStatus;
	
	@Column(name="delivery_remark",length=11)
	private int deliveryremark;

	public int getDeliMemoDetailId() {
		return deliMemoDetailId;
	}

	public void setDeliMemoDetailId(int deliMemoDetailId) {
		this.deliMemoDetailId = deliMemoDetailId;
	}

	public int getDeliMemoHeaderId() {
		return deliMemoHeaderId;
	}

	public void setDeliMemoHeaderId(int deliMemoHeaderId) {
		this.deliMemoHeaderId = deliMemoHeaderId;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	public int getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public int getDeliveryremark() {
		return deliveryremark;
	}

	public void setDeliveryremark(int deliveryremark) {
		this.deliveryremark = deliveryremark;
	}

	@Override
	public String toString() {
		return "DeliverMemoDetails [deliMemoDetailId=" + deliMemoDetailId + ", deliMemoHeaderId=" + deliMemoHeaderId
				+ ", lrHeaderId=" + lrHeaderId + ", deliveryStatus=" + deliveryStatus + ", deliveryremark="
				+ deliveryremark + "]";
	}
	
	
}
