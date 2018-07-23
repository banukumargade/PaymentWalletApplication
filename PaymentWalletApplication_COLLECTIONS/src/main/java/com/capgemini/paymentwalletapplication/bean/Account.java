package com.capgemini.paymentwalletapplication.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	private long accNo;
	private List<String> transactionId=new ArrayList<String>();
	private Date date;
	private double amount;
	private ClientDetails cd;
	private String password;
	private String userName;
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public List<String> getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(List<String> transactionId) {
		this.transactionId = transactionId;
	}
	public Date getDate() {
		return date;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public ClientDetails getCd() {
		return cd;
	}
	public void setCd(ClientDetails cd) {
		this.cd = cd;
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", transactionId=" + transactionId + ", date=" + date + ", amount=" + amount
				+ ", cd=" + cd + ", password=" + password + ", userName=" + userName + "]";
	}
	
}
