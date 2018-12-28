package com.bionische.swastiktruckage.mastermodel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LrGraph {

	
	
	
	@Column(name="lr_count")
	private int lrCount;
	
	@Id
	@Column(name="lr_date")
	private String lrDate;



	public int getLrCount() {
		return lrCount;
	}

	public void setLrCount(int lrCount) {
		this.lrCount = lrCount;
	}

	

	public String getLrDate() {
		return lrDate;
	}

	public void setLrDate(String lrDate) {
		this.lrDate = lrDate;
	}

	@Override
	public String toString() {
		return "LrGraph [lrCount=" + lrCount + ", lrDate=" + lrDate + "]";
	}

	

	
	
	
	
}
