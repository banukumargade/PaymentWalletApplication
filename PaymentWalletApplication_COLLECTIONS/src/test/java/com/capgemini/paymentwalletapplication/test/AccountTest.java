package com.capgemini.paymentwalletapplication.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.paymentwalletapplication.bean.Account;

import junit.framework.Assert;

public class AccountTest {
	Account account=new Account();

	@Test
	public void testGetPassword() {
		account.setPassword("bk123645@");
	
		Assert.assertEquals("Banukumar@",account.getPassword());
		Assert.assertTrue("bk".equalsIgnoreCase(account.getPassword()));
		Assert.assertFalse("bk123645@".equalsIgnoreCase(account.getPassword()));
	}
	
	@Test
	public void testGetAccNo() {
		
		Assert.assertNotNull(account.getAccNo());
		
		Assert.assertEquals(1012235," " );
		Assert.assertNotSame(1234567890,1235689);
	}


	@Test
	public void testGetTransactionId() {
		
		Assert.assertNotNull(account.getTransactionId());

		account.setTransactionId(null);
		Assert.assertNull(account.getTransactionId());
		Assert.assertEquals(122334421,account.getTransactionId());
	}

	
	
	@Test
	public void testGetUserName() {
		account.setUserName("");
		Assert.assertEquals("banugade",account.getUserName());
		Assert.assertNotSame("banugade","  ");
	}

	@Test
	public void testGetDate() {
		Assert.assertNotNull(account.getDate());
		Assert.assertEquals(22/8/2005,account.getDate());
		Assert.assertNotSame(10/7/2018," ");
	}

	

	@Test
	public void testGetAmount() {
		Assert.assertNotNull(account.getAmount());
		account.setAmount(2500);
		Assert.assertEquals(10500,account.getAmount());
		Assert.assertNotSame(22500," ");
	}

}
