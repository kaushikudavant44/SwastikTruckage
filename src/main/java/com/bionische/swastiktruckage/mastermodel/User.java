package com.bionische.swastiktruckage.mastermodel;

public class User {

	
	private String userName;
	private String mobileNo;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Override
	public String toString() {
		return "User [userName=" + userName + ", mobileNo=" + mobileNo + "]";
	}
	
	
}
