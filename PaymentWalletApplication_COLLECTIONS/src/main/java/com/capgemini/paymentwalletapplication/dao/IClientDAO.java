package com.capgemini.paymentwalletapplication.dao;

import java.util.List;

import com.capgemini.paymentwalletapplication.bean.Account;
import com.capgemini.paymentwalletapplication.bean.ClientDetails;

public interface IClientDAO {
	
	public int createAccount(Account details,ClientDetails cdetails);
	
	public double showBalance();
	
	public int deposit(double amount);
	
	public int withdraw(double amount);
	
	public int fundTransfer(long accNo,double amount);
	
	public List printTransaction();
	
	public boolean testLogin(String userName,String password);
	
	
}
