package com.capgemini.paymentwalletapplication.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.capgemini.paymentwalletapplication.bean.Account;
import com.capgemini.paymentwalletapplication.bean.ClientDetails;


public class ClientDAO implements IClientDAO {
	
	static Boolean flag;
	static double blnc;
	static long tid;
	static Account temp=new Account();
	
	
	static List<Account> List=new ArrayList<Account>();
	
	Map<String,Double> transactions=new HashMap<String,Double>();
	
	public int createAccount(Account details,ClientDetails cdetails) {
	/*	flag =List.add(details);
		if(flag)
		{
			
			return 1;
		}	
		else{
			return 0;
	}*/
		
		
		return 0;
	}
	
	
	public double showBalance() {
			blnc=temp.getAmount();
				return blnc;
	}
	
	public int deposit(double amount) {
		Iterator<Account> it=List.iterator();
		while(it.hasNext()) {
			Account acc=it.next();
			if(temp.getUserName().equals(acc.getUserName())) {
				tid = (long) (Math.random()*12345+999);
				blnc=acc.getAmount()+amount;
				acc.setAmount(blnc);
			
			LocalDateTime date=LocalDateTime.now();
			String s="Transaction id"+Long.toString(tid)+"at"+date.toString()+"and deposited amount"+Double.toString(amount);
			acc.getTransactionId().add(s);
			System.out.println("Amount in your account after deposit  is: "+acc.getAmount());
			return 1;
			}
		}
		return 0;
		}
		
	
	
	public int withdraw(double amount) {
		
		Iterator<Account> it=List.iterator();
		while(it.hasNext()) {
			Account acc= it.next();
			if(temp.getUserName().equals(acc.getUserName())) {
				if(acc.getAmount()>=amount+1000) {
				tid = (long) (Math.random()*12345+999);
				blnc=acc.getAmount()-amount;
				acc.setAmount(blnc);
				LocalDateTime date=LocalDateTime.now();
				
				String s="Transaction id"+Long.toString(tid)+"at"+date.toString()+"and withdraw amount"+Double.toString(amount);
				acc.getTransactionId().add(s);
				System.out.println("Amount in your account after withdrwal  is: "+acc.getAmount());
				return 1;
			}
			}
		}

				return 0;
				
				
			}
			
	
	public int fundTransfer(long accNo,double amount) {
		Iterator<Account> it=List.iterator();
		Iterator<Account> it2=List.iterator();
		
		while(it.hasNext()) {
			Account acc= it.next();
			if(temp.getUserName().equals(acc.getUserName())) {
				tid = (long) (Math.random()*12345+999);
				blnc=acc.getAmount()-amount;
				acc.setAmount(blnc);
				LocalDateTime date=LocalDateTime.now();
		
		while(it2.hasNext()) {
			Account acc2= it2.next();
			if(acc2.getAccNo()==accNo) {
				acc2.setAmount(acc2.getAmount()+amount);
				String s="Transaction id"+Long.toString(tid)+"at"+date.toString()+"and recieved amount"+Double.toString(amount);
				acc2.getTransactionId().add(s);
			}
		}
		String s="Transaction id"+Long.toString(tid)+"at"+date.toString()+"and Transferred amount"+Double.toString(amount);
		acc.getTransactionId().add(s);
		System.out.println("Fund amount "+amount+"is transfferd to"+accNo);
		return 1;
			}
		}
		
		return 0;
	}
	
	
	
	public List printTransaction() {
		Iterator<Account> it=List.iterator();
		while(it.hasNext()) {
			Account acc=it.next();
			if(temp.getUserName().equals(acc.getUserName())) {
				return acc.getTransactionId();
			}
			
		}
		return null;
		
	}
	

	
	public boolean testLogin(String userName, String password) {
		
		
		Iterator<Account> it=List.iterator();
		

		while(it.hasNext()) {
			Account acc=it.next();
			if(userName.equals(acc.getUserName())&&password.equals(acc.getPassword())) {
			
					temp = acc;
					return true;
				
				}
		}
		return false;
	
	}
	
}


