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
@Table(name="t_memo_details")
@EntityListeners(AuditingEntityListener.class)
public class MemoDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="memo_detail_id",length=11)
	private int memoDetailId;
	
	@Column(name="lr_header_id",length=11)
	private int lrHeaderId;
	
	@Column(name="memo_header_id",length=11)
	private int memoHeaderId;
	
	@Column(name="lr_status",length=11)
	private int lrStatus;

	
	
	public int getMemoHeaderId() {
		return memoHeaderId;
	}

	public void setMemoHeaderId(int memoHeaderId) {
		this.memoHeaderId = memoHeaderId;
	}

	public int getMemoDetailId() {
		return memoDetailId;
	}

	public void setMemoDetailId(int memoDetailId) {
		this.memoDetailId = memoDetailId;
	}

	public int getLrHeaderId() {
		return lrHeaderId;
	}

	public void setLrHeaderId(int lrHeaderId) {
		this.lrHeaderId = lrHeaderId;
	}

	public int getLrStatus() {
		return lrStatus;
	}

	public void setLrStatus(int lrStatus) {
		this.lrStatus = lrStatus;
	}

	@Override
	public String toString() {
		return "MemoDetails [memoDetailId=" + memoDetailId + ", lrHeaderId=" + lrHeaderId + ", memoHeaderId="
				+ memoHeaderId + ", lrStatus=" + lrStatus + "]";
	}

	
	
	

}
