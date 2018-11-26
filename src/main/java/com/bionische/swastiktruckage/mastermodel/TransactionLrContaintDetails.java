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
@Table(name="t_lr_containt_details")
@EntityListeners(AuditingEntityListener.class)
public class TransactionLrContaintDetails {
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="detail_id",length=11)
	private int detailId;
	
	@Column(name="lr_header_id",length=200)
	private int lrHeaderId;
	
	@Column(name="no_of_containts",length=200)
	private float noOfContaints;
	
	@Column(name="goods",length=11)
	private String goods;
	
	@Column(name="description",length=11)
	private String description;

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

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TransactionLrContaintDetails [detailId=" + detailId + ", lrHeaderId=" + lrHeaderId + ", noOfContaints="
				+ noOfContaints + ", goods=" + goods + ", description=" + description + "]";
	}
	
	

}
