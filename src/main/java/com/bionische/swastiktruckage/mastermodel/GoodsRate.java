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
@Table(name="m_goods_rate")
@EntityListeners(AuditingEntityListener.class)
public class GoodsRate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="goods_rate_id",length=11)
	private int goodsRateId;
	
	@Column(name="office_id",length=11)
	private int officeId;
	
	@Column(name="goods_id",length=11)
	private int goodsId;
	
	@Column(name="goods_rate",length=11)
	private float goodsRate;

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

	@Override
	public String toString() {
		return "GoodsRate [goodsRateId=" + goodsRateId + ", officeId=" + officeId + ", goodsId=" + goodsId
				+ ", goodsRate=" + goodsRate + "]";
	}
	
	

}
