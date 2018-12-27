package com.bionische.swastiktruckage.mastermodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class GetLocalMemoHeaderAndDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="deli_memo_header_id",length=11)
	private int deliMemoHeaderId;
	
	@Column(name="deli_memo_date")
	private String deliMemoDate;
	
	@Column(name="veh_no")
	private String vehNo;
	
	@Column(name="vehicle_id")
	private String vehicleId;
	
	@Column(name="office_id")
	private int officeId;
	
	@Column(name="office_name")
	private String officeName;
	
	@Column(name="staff_id")
	private int staffId;
	
	@Column(name="staff_name")
	private String staffName;
	
	@Column(name="local_memo_no")
	private int localMemoNo;
	
	@Column(name="driver_id")
	private int driverId;
	
	@Column(name="driver_name")
	private String driverName;
	
	@Column(name="lr_header_id")
	private int lrHeaderId;
	
	
}
