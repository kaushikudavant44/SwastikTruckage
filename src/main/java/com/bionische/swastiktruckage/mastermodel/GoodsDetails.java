package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GoodsDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="goods_rate_id")
	private int goodsRateId;
	
	@Column(name="office_id")
	private int officeId;
	
	@Column(name="goods_id")
	private int goodsId;
	
	@Column(name="goods_rate")
	private float goodsRate;
	
	@Column(name="goods_name")
	private String goodsName;
	
	@Column(name="office_name")
	private String officeName;

	public int getGoodsRateId() {
		return goodsRateId;
	}

	public void setGoodsRateId(int goodsRateId) {
		this.goodsRateId = goodsRateId;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public float getGoodsRate() {
		return goodsRate;
	}

	public void setGoodsRate(float goodsRate) {
		this.goodsRate = goodsRate;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	@Override
	public String toString() {
		return "GoodsDetails [goodsRateId=" + goodsRateId + ", officeId=" + officeId + ", goodsId=" + goodsId
				+ ", goodsRate=" + goodsRate + ", goodsName=" + goodsName + ", officeName=" + officeName + "]";
	}
	
	

}
