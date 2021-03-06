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
@Table(name="t_lr_header")
@EntityListeners(AuditingEntityListener.class)
public class TransactionLrHeader {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lr_header_id",length=11)
	private int lrHeaderId;
	
	@Column(name="lr_no",length=11)
	private int lrNo;
	
	@Column(name="inv_header_id",length=11)
	private int invHeaderId;
	
	@Column(name="from_id",length=11)
	private int fromId;
	
	
	@Column(name="consignor",length=200)
	private int consignor;	
	
	@Column(name="consigneeId",length=200)
	private int consigneeId;
	
	@Column(name="lr_date",length=50)
	private String lrDate;
	
	@Column(name="truck_no",length=200)
	private String truckNo;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name="freight")
	private float freight;
	
	@Column(name="gst")
	private float gst;
	
	@Column(name="hamali")
	private float hamali;

	@Column(name="b_c_charge")
	private float b_c_charge;
	
	@Column(name="kata")
	private float kata;
	
	@Column(name="local_tempo")
	private float localTempo;
	
	@Column(name="bharai")
	private float bharai;
	
	@Column(name="dd_charges")
	private float dd_charges;
	
	@Column(name="total")
	private float total;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	@Column(name="payment_by",length=11)
	private int paymentBy;
	
	/**
	 *  0 - not bill yet
		1- billed
		2 - LR collection
		3 - collected
	 */
	@Column(name="bill_status",length=11)
	private int billStatus;
	
	
	@Column(name="delivery_status",length=11)
	private int deliveryStatus;
	
	
	@Column(name="create_date",updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	private Date modifiedDate;

	
	
	public int getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(int consigneeId) {
		this.consigneeId = consigneeId;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	public int getInvHeaderId() {
		return invHeaderId;
	}

	public void setInvHeaderId(int invHeaderId) {
		this.invHeaderId = invHeaderId;
	}

	public int getPaymentBy() {
		return paymentBy;
	}

	public void setPaymentBy(int paymentBy) {
		this.paymentBy = paymentBy;
	}

	public int getFromId() {
		return fromId;
	}

	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	
	public int getConsignor() {
		return consignor;
	}

	public void setConsignor(int consignor) {
		this.consignor = consignor;
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

	public float getB_c_charge() {
		return b_c_charge;
	}

	public void setB_c_charge(float b_c_charge) {
		this.b_c_charge = b_c_charge;
	}

	public float getKata() {
		return kata;
	}

	public void setKata(float kata) {
		this.kata = kata;
	}

	public float getLocalTempo() {
		return localTempo;
	}

	public void setLocalTempo(float localTempo) {
		this.localTempo = localTempo;
	}

	public float getBharai() {
		return bharai;
	}

	public void setBharai(float bharai) {
		this.bharai = bharai;
	}

	public float getDd_charges() {
		return dd_charges;
	}

	public void setDd_charges(float dd_charges) {
		this.dd_charges = dd_charges;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	public int getLrNo() {
		return lrNo;
	}

	public void setLrNo(int lrNo) {
		this.lrNo = lrNo;
	}

	public int getBillStatus() {
		return billStatus;
	}

	public void setBillStatus(int billStatus) {
		this.billStatus = billStatus;
	}

	public int getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(int deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	
	

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "TransactionLrHeader [lrHeaderId=" + lrHeaderId + ", lrNo=" + lrNo + ", invHeaderId=" + invHeaderId
				+ ", fromId=" + fromId + ", consignor=" + consignor + ", consigneeId=" + consigneeId + ", lrDate="
				+ lrDate + ", truckNo=" + truckNo + ", weight=" + weight + ", freight=" + freight + ", gst=" + gst
				+ ", hamali=" + hamali + ", b_c_charge=" + b_c_charge + ", kata=" + kata + ", localTempo=" + localTempo
				+ ", bharai=" + bharai + ", dd_charges=" + dd_charges + ", total=" + total + ", isUsed=" + isUsed
				+ ", paymentBy=" + paymentBy + ", billStatus=" + billStatus + ", deliveryStatus=" + deliveryStatus
				+ ", createDate=" + createDate + ", modifiedDate=" + modifiedDate + "]";
	}

	

	




	

	
	}
