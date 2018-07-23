package com.capgemini.paymentwalletapplication.service;

import java.util.List;

import com.capgemini.paymentwalletapplication.bean.Account;
import com.capgemini.paymentwalletapplication.bean.ClientDetails;
import com.capgemini.paymentwalletapplication.dao.ClientDAO;
import com.capgemini.paymentwalletapplication.ui.Client;

public class ClientService implements IClientService{
	
	ClientDAO dao =new ClientDAO();
	
	
	
	public int createAccount(Account bean) {
		
		return dao.createAccount(bean);
	}
	
	public double showBalance() {
		
	
		return dao.showBalance();
	}
	
	public int deposit(double amount) {
		
		return dao.deposit(amount);
		
	}
	
	public int withdraw(double amount) {
		
		return dao.withdraw(amount);
		
	}
	
	public int fundTransfer(long accNo,double amount) {
		
		return dao.fundTransfer(accNo, amount);
		
	}
	
	public void printTransaction() {
		
		 dao.printTransaction();
		
	}


	public boolean testLogin(String userName, String password) {
		return dao.testLogin(userName, password);
	}

	public void close() {
	
	}
	
	

	

}
