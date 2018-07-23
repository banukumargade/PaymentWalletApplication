package com.capgemini.paymentwalletapplication.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.paymentwalletapplication.bean.Account;

import junit.framework.Assert;

public class AccountTest {
	Account account=new Account();
	
	@Test
	public void testGetAccNo() {
		
		Assert.assertNotNull(account.getAccNo());
		Assert.assertEquals(1012235," " );
		Assert.assertNotSame(1234567890,1235689);
	}

	@Test
	public void testGetDate() {
		Assert.assertNotNull(account.getDate());
		Assert.assertEquals(22/8/2005,account.getDate());
		Assert.assertNotSame(10/7/2018," ");
	}

	
}
