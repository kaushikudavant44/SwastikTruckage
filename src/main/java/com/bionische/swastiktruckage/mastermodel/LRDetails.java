package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LRDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="lr_header_id")
	private int lrHeaderId;
	
	@Column(name="lr_no")
	private int lrNo;
	
	@Column(name="inv_header_id")
	private int invHeaderId;
	
	@Column(name="from_id")
	private int fromId;
	
	@Column(name="office_name")
	private String officeName;
		
	@Column(name="consignor")
	private int consignor;
	
	@Column(name="consignee_Id")
	private int consigneeId;
	
	@Column(name="consignor_name")
	private String consignorName;

	@Column(name="consignee_name")
	private String consigneeName;
	
	@Column(name="lr_date")
	private String lrDate;
	
	@Column(name="truck_no")
	private String truckNo;
	
	@Column(name="weight")
	private String weight;
	
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
				
	@Column(name="bharai")
	private float bharai;
	
	@Column(name="dd_charges")
	private float ddCharges;
	
	@Column(name="b_c_charge")
	private float bcCharge;
	
	@Column(name="kata")
	private float kata;
	
	@Column(name="consignee_address")
	private String consigneeAddress;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	@Column(name="office_address")
	private String officeAddress;

	
	
	
	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
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

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
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

	public String getConsignorName() {
		return consignorName;
	}

	public void setConsignorName(String consignorName) {
		this.consignorName = consignorName;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
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

	public float getBharai() {
		return bharai;
	}

	public void setBharai(float bharai) {
		this.bharai = bharai;
	}

	public float getDdCharges() {
		return ddCharges;
	}

	public void setDdCharges(float ddCharges) {
		this.ddCharges = ddCharges;
	}

	public float getBcCharge() {
		return bcCharge;
	}

	public void setBcCharge(float bcCharge) {
		this.bcCharge = bcCharge;
	}

	public float getKata() {
		return kata;
	}

	public void setKata(float kata) {
		this.kata = kata;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "LRDetails [lrHeaderId=" + lrHeaderId + ", lrNo=" + lrNo + ", invHeaderId=" + invHeaderId + ", fromId="
				+ fromId + ", officeName=" + officeName + ", consignor=" + consignor + ", consigneeId=" + consigneeId
				+ ", consignorName=" + consignorName + ", consigneeName=" + consigneeName + ", lrDate=" + lrDate
				+ ", truckNo=" + truckNo + ", weight=" + weight + ", freight=" + freight + ", gst=" + gst + ", hamali="
				+ hamali + ", localTempo=" + localTempo + ", total=" + total + ", paymentBy=" + paymentBy + ", bharai="
				+ bharai + ", ddCharges=" + ddCharges + ", bcCharge=" + bcCharge + ", kata=" + kata
				+ ", consigneeAddress=" + consigneeAddress + ", isUsed=" + isUsed + ", officeAddress=" + officeAddress
				+ "]";
	}

	

	
	
	
	
	
	

}
