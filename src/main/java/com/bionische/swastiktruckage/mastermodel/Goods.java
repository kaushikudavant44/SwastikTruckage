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
@Table(name="m_goods")
@EntityListeners(AuditingEntityListener.class)
public class Goods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="goods_id",length=11)
	private int goodsId;
	
	@Column(name="goods_name",length=11)
	private String goodsName;
	
	@Column(name="is_used",length=11)
	private boolean isUsed;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", isUsed=" + isUsed + "]";
	}
	
	

}
