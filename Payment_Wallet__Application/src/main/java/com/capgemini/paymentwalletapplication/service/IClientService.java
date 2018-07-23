package com.capgemini.paymentwalletapplication.service;



import com.capgemini.paymentwalletapplication.bean.Account;


public interface IClientService {

	public int createAccount(Account bean);
	
	public double showBalance();
	
	public int deposit(double amount);
	
	public int withdraw(double amount);
	
	public int fundTransfer(long accNo,double amount);
	
	public void printTransaction();
	
	public boolean testLogin(String userName,String password);
	
	public void close();
	
}
