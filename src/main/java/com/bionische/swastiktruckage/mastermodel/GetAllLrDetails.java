package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetAllLrDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lr_header_id")
	private int lrHeaderId;
	
	@Column(name="lr_no")
	private int lrNo;
	
	@Column(name="lr_Date")
	private String lrDate;
	
	@Column(name="particular")
	private String particular;
	
	@Column(name="quantity")
	private float quantity;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="goods_id")
	private int goodsId;
	
	@Column(name="office_name")
	private String officeName;
	
	@Column(name="consignor")
	private String consignor;
	
	@Column(name="consignee")
	private String consignee;

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

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	public String getParticular() {
		return particular;
	}

	public void setParticular(String particular) {
		this.particular = particular;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getConsignor() {
		return consignor;
	}

	public void setConsignor(String consignor) {
		this.consignor = consignor;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	@Override
	public String toString() {
		return "GetAllLrDetails [lrHeaderId=" + lrHeaderId + ", lrNo=" + lrNo + ", lrDate=" + lrDate + ", particular="
				+ particular + ", quantity=" + quantity + ", amount=" + amount + ", goodsId=" + goodsId
				+ ", officeName=" + officeName + ", consignor=" + consignor + ", consignee=" + consignee + "]";
	}

	
	
	
	
	
	

}
