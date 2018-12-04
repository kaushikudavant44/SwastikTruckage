package com.bionische.swastiktruckage.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class LrBilling {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lr_header_id")
	private int lrHeaderId;
	
	@Column(name="lr_id")
	private int lrId;
	
	@Column(name="inv_header_id")
	private int invHeaderId;
	
	@Column(name="from_id")
	private int fromId;
	
	@Column(name="to_id")
	private int toId;
	
	@Column(name="lr_date")
	private String lrDate;
	
	@Column(name="truck_no")
	private String truckNo;
	
	@Column(name="weight")
	private float weight;
	
	@Column(name="freight")
	private float freight;
	
	@Column(name="gst")
	private float gst;
	
	@Column(name="hamali")
	private float hamali;
	
	@Column(name="local_tempo")
	private float localTempo;
	
	@Column(name="total")
	private float total;
	
	@Column(name="payment_by")
	private int paymentBy;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="status",length=11)
	private int status;

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	public int getLrId() {
		return lrId;
	}

	public void setLrId(int lrId) {
		this.lrId = lrId;
	}

	public int getInvHeaderId() {
		return invHeaderId;
	}

	public void setInvHeaderId(int invHeaderId) {
		this.invHeaderId = invHeaderId;
	}

	public int getFromId() {
		return fromId;
	}

	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	public int getToId() {
		return toId;
	}

	public void setToId(int toId) {
		this.toId = toId;
	}

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getTruckNo() {
		return truckNo;
	}

	public void setTruckNo(String truckNo) {
		this.truckNo = truckNo;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getFreight() {
		return freight;
	}

	public void setFreight(float freight) {
		this.freight = freight;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	public float getHamali() {
		return hamali;
	}

	public void setHamali(float hamali) {
		this.hamali = hamali;
	}

	public float getLocalTempo() {
		return localTempo;
	}

	public void setLocalTempo(float localTempo) {
		this.localTempo = localTempo;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getPaymentBy() {
		return paymentBy;
	}

	public void setPaymentBy(int paymentBy) {
		this.paymentBy = paymentBy;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "LrBilling [lrHeaderId=" + lrHeaderId + ", lrId=" + lrId + ", invHeaderId=" + invHeaderId + ", fromId="
				+ fromId + ", toId=" + toId + ", lrDate=" + lrDate + ", truckNo=" + truckNo + ", weight=" + weight
				+ ", freight=" + freight + ", gst=" + gst + ", hamali=" + hamali + ", localTempo=" + localTempo
				+ ", total=" + total + ", paymentBy=" + paymentBy + ", quantity=" + quantity + ", status=" + status
				+ "]";
	}
	
	

}
