package com.capgemini.paymentwalletapplication.bean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
	private long accNo;
	//private List<String> transactionId=new ArrayList<String>();
	private LocalDate date;
	private double balance;
	private ClientDetails cust;
	private long aadharNum;
	
	
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public ClientDetails getCust() {
		return cust;
	}
	public void setCust(ClientDetails cust) {
		this.cust = cust;
	}
	
	public long getAadharNum() {
		return aadharNum;
	}
	public void setAadharNum(long aadharNum) {
		this.aadharNum = aadharNum;
	}
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", date=" + date + ", balance=" + balance + ", cust=" + cust + ", aadharNum="
				+ aadharNum + "]";
	}
	
	
	
}
