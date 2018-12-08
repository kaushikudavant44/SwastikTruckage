package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LRDetails {
	
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
	
	@Column(name="from_office_name")
	private String fromOfficeName;
		
	@Column(name="consignor")
	private int consignor;
	
	@Column(name="consignee_Id")
	private int consigneeId;
		
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
	
	@Column(name="status")
	private int status;
	
	@Column(name="office_address")
	private String officeAddress;
	
	@Column(name="office_contact_no")
	private String officeContactNo;
	
	@Column(name="fax_no")
	private String faxNo;
	
	@Column(name="client_pincode")
	private int clientPincode;
	
	
	@Column(name="client_id",length=11)
	private int clientId;
	
	@Column(name="client_name",length=200)
	private String clientName;
	
	@Column(name="client_address",length=200)
	private String clientAddress;
	
	@Column(name="state_id",length=11)
	private int stateId;
	
	@Column(name="city_id",length=11)
	private int cityId;
	
	@Column(name="pincode",length=11)
	private int pincode;
	
	@Column(name="client_contact_no",length=200)
	private String clientContactNo;
	
	@Column(name="gstin",length=11)
	private String gstin;
	
	@Column(name="is_used")
	private boolean isUsed;
	
	
	

	public int getClientPincode() {
		return clientPincode;
	}

	public void setClientPincode(int clientPincode) {
		this.clientPincode = clientPincode;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getClientContactNo() {
		return clientContactNo;
	}

	public void setClientContactNo(String clientContactNo) {
		this.clientContactNo = clientContactNo;
	}

	public String getGstin() {
		return gstin;
	}

	public void setGstin(String gstin) {
		this.gstin = gstin;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

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

	public String getFromOfficeName() {
		return fromOfficeName;
	}

	public void setFromOfficeName(String fromOfficeName) {
		this.fromOfficeName = fromOfficeName;
	}

	public int getConsignor() {
		return consignor;
	}

	public void setConsignor(int consignor) {
		this.consignor = consignor;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getConsigneeId() {
		return consigneeId;
	}

	public void setConsigneeId(int consigneeId) {
		this.consigneeId = consigneeId;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public String getOfficeContactNo() {
		return officeContactNo;
	}

	public void setOfficeContactNo(String officeContactNo) {
		this.officeContactNo = officeContactNo;
	}

	public String getFaxNo() {
		return faxNo;
	}

	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "LRDetails [lrHeaderId=" + lrHeaderId + ", lrId=" + lrId + ", invHeaderId=" + invHeaderId + ", fromId="
				+ fromId + ", fromOfficeName=" + fromOfficeName + ", consignor=" + consignor + ", consigneeId="
				+ consigneeId + ", lrDate=" + lrDate + ", truckNo=" + truckNo + ", weight=" + weight + ", freight="
				+ freight + ", gst=" + gst + ", hamali=" + hamali + ", localTempo=" + localTempo + ", total=" + total
				+ ", paymentBy=" + paymentBy + ", quantity=" + quantity + ", status=" + status + ", officeAddress="
				+ officeAddress + ", officeContactNo=" + officeContactNo + ", faxNo=" + faxNo + ", clientPincode="
				+ clientPincode + ", clientId=" + clientId + ", clientName=" + clientName + ", clientAddress="
				+ clientAddress + ", stateId=" + stateId + ", cityId=" + cityId + ", pincode=" + pincode
				+ ", clientContactNo=" + clientContactNo + ", gstin=" + gstin + ", isUsed=" + isUsed + "]";
	}

	
	
	

}
