package com.capgemini.paymentwalletapplication.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.paymentwalletapplication.dao.ClientDAO;

import junit.framework.Assert;

public class ClientDAOTest {
	ClientDAO dao=new ClientDAO();
	
	@Test
	public void testCreateAccount() {
	Assert.assertEquals(false,101);	
	}

	@Test
	public void testShowBalance() {
		
		Assert.assertEquals(1, dao.showBalance());
	}

	@Test
	public void testDeposit() {
		Assert.assertEquals(1,dao.deposit(2000));
	}

	@Test
	public void testWithdraw() {
		Assert.assertEquals(1,dao.withdraw(1000));
	}

	@Test
	public void testFundTransfer() {
		Assert.assertNull(dao.fundTransfer(1200001,50000));
	}
}
