package com.bionische.swastiktruckage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetLrDetailsOfClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lr_header_id")
	private int lrHeaderId;
	
	@Column(name="inv_header_id")
	private int invHeaderId;
	
	@Column(name="consignor")
	private int consignor;	
	
	@Column(name="consignee_id")
	private int consigneeId;
	
	@Column(name="from_id")
	private int fromId;
	
	@Column(name="lr_No")
	private int lrNo;
	
	@Column(name="consignee_name")
	private String consigneeName;
	
	@Column(name="consignor_name")
	private String consignorName;
	
	@Column(name="lr_date")
	private String lrDate;
	
	@Column(name="truck_no")
	private String truckNo;
	
	@Column(name="freight")
	private float freight;
	
	@Column(name="weight")
	private float weight;	
	
	@Column(name="gst")
	private float gst;

	@Column(name="local_tempo")
	private float localTempo;
	
	@Column(name="hamali")
	private float hamali;
	
	@Column(name="payment_by")
	private int paymentBy;
	
	@Column(name="total")
	private float total;
	
	@Column(name="bill_status",length=11)
	private int billStatus;
	
	@Column(name="delivery_status",length=11)
	private int deliveryStatus;

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

	public int getConsignor() {
		return consignor;
	}

	public void setConsignor(int consignor) {
		this.consignor = consignor;
	}

	public int getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(int consigneeId) {
		this.consigneeId = consigneeId;
	}

	public int getFromId() {
		return fromId;
	}

	public void setFromId(int fromId) {
		this.fromId = fromId;
	}

	public int getLrNo() {
		return lrNo;
	}

	public void setLrNo(int lrNo) {
		this.lrNo = lrNo;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getGst() {
		return gst;
	}

	public void setGst(float gst) {
		this.gst = gst;
	}

	public float getLocalTempo() {
		return localTempo;
	}

	public void setLocalTempo(float localTempo) {
		this.localTempo = localTempo;
	}

	public float getHamali() {
		return hamali;
	}

	public void setHamali(float hamali) {
		this.hamali = hamali;
	}

	public int getPaymentBy() {
		return paymentBy;
	}

	public void setPaymentBy(int paymentBy) {
		this.paymentBy = paymentBy;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	@Override
	public String toString() {
		return "GetLrDetailsOfClient [lrHeaderId=" + lrHeaderId + ", invHeaderId=" + invHeaderId + ", consignor="
				+ consignor + ", consigneeId=" + consigneeId + ", fromId=" + fromId + ", lrNo=" + lrNo
				+ ", consigneeName=" + consigneeName + ", consignorName=" + consignorName + ", lrDate=" + lrDate
				+ ", truckNo=" + truckNo + ", freight=" + freight + ", weight=" + weight + ", gst=" + gst
				+ ", localTempo=" + localTempo + ", hamali=" + hamali + ", paymentBy=" + paymentBy + ", total=" + total
				+ ", billStatus=" + billStatus + ", deliveryStatus=" + deliveryStatus + "]";
	}
	
	
}
