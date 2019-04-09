package com.bionische.swastiktruckage.mastermodel;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
public class LrBilling {

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
	
	@Column(name="goods")
	private String goods;
	
	@Column(name="truck_no")
	private String truckNo;
	
	@Column(name="quantity")
	private int quantity;
	
	@Column(name="freight")
	private float freight;
	
	@Column(name="weight")
	private String weight;	
	
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
	
	@Column(name="consignee_address")
	private String consigneeAddress;
	
	@Column(name="consignor_address")
	private String consignorAddress;
	
	@Transient
	List<TransactionLrInvoiceDetail> invoiceDetailList;
	
	
	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public int getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(int consigneeId) {
		this.consigneeId = consigneeId;
	}


	public List<TransactionLrInvoiceDetail> getInvoiceDetailList() {
		return invoiceDetailList;
	}

	public void setInvoiceDetailList(List<TransactionLrInvoiceDetail> invoiceDetailList) {
		this.invoiceDetailList = invoiceDetailList;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	

	public int getConsignor() {
		return consignor;
	}

	public void setConsignor(int consignor) {
		this.consignor = consignor;
	}

	public int getLrNo() {
		return lrNo;
	}

	public void setLrNo(int lrNo) {
		this.lrNo = lrNo;
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



	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
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
	
	

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsignorAddress() {
		return consignorAddress;
	}

	public void setConsignorAddress(String consignorAddress) {
		this.consignorAddress = consignorAddress;
	}

	@Override
	public String toString() {
		return "LrBilling [lrHeaderId=" + lrHeaderId + ", invHeaderId=" + invHeaderId + ", consignor=" + consignor
				+ ", consigneeId=" + consigneeId + ", fromId=" + fromId + ", lrNo=" + lrNo + ", consigneeName="
				+ consigneeName + ", consignorName=" + consignorName + ", lrDate=" + lrDate + ", goods=" + goods
				+ ", truckNo=" + truckNo + ", quantity=" + quantity + ", freight=" + freight + ", weight=" + weight
				+ ", gst=" + gst + ", localTempo=" + localTempo + ", hamali=" + hamali + ", paymentBy=" + paymentBy
				+ ", total=" + total + ", consigneeAddress=" + consigneeAddress + ", consignorAddress="
				+ consignorAddress + ", invoiceDetailList=" + invoiceDetailList + "]";
	}



	

	
	
		
}
