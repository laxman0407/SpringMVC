package com.tech.model;


import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Customer {

	@Id
	private int addharNo;

	private int accountNumber;

	private String cusName;

	private String cusAddress;

	private long cusMobileNumber;

	private String userName;

	private String password;

	private double totalAmount;

	public int getAddharNo() {
		return addharNo;
	}

	public void setAddharNo(int addharNo) {
		this.addharNo = addharNo;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String cusName) {
		this.cusName = cusName;
	}

	public String getCusAddress() {
		return cusAddress;
	}

	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}

	public long getCusMobileNumber() {
		return cusMobileNumber;
	}

	public void setCusMobileNumber(long cusMobileNumber) {
		this.cusMobileNumber = cusMobileNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
