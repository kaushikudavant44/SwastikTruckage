package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LrContaintDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="detail_id")
	private int detailId;
	
	@Column(name="lr_header_id")
	private int lrHeaderId;
	
	@Column(name="no_of_containts")
	private float noOfContaints;
	
	@Column(name="goods_id",length=11)
	private int goodsId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="goods_name")
	private String goodsName;

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	public float getNoOfContaints() {
		return noOfContaints;
	}

	public void setNoOfContaints(float noOfContaints) {
		this.noOfContaints = noOfContaints;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	@Override
	public String toString() {
		return "LrContaintDetails [detailId=" + detailId + ", lrHeaderId=" + lrHeaderId + ", noOfContaints="
				+ noOfContaints + ", goodsId=" + goodsId + ", description=" + description + ", goodsName=" + goodsName
				+ "]";
	}
	
	
	
}
