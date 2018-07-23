package com.capgemini.paymentwalletapplication.service;

import java.util.List;

import com.capgemini.paymentwalletapplication.bean.Account;
import com.capgemini.paymentwalletapplication.bean.ClientDetails;
import com.capgemini.paymentwalletapplication.ui.Client;

public interface IClientService {

	public int createAccount(Account details,ClientDetails cdetails);
	
	public double showBalance();
	
	public int deposit(double amount);
	
	public int withdraw(double amount);
	
	public int fundTransfer(long accNo,double amount);
	
	public List printTransaction();
	
	public boolean testLogin(String userName,String password);
	
}
