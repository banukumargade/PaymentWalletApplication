package com.capgemini.paymentwalletapplication.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.paymentwalletapplication.service.ClientDataValidate;

import junit.framework.Assert;

public class ClientDataValidateTest {
public ClientDataValidate validate=new ClientDataValidate(); {
	// TODO Auto-generated constructor stub
}
	@Test
	public void testValidateGender() {
		Assert.assertEquals(true, validate.validateGender("male"));
		Assert.assertEquals(false, validate.validateGender("m"));
	}

	@Test
	public void testValidatePhoneNumber() {
		Assert.assertEquals(true,validate.validatePhoneNumber("1234567890"));
		Assert.assertEquals(false,validate.validatePhoneNumber("1234567"));
	}

	@Test
	public void testValidateEmail() {
		Assert.assertEquals(true,validate.validateEmail("banu@capgemini.com"));
		Assert.assertEquals(false,validate.validateEmail("banu@yahoo.com"));
	}

	@Test
	public void testValidateUserName() {
		Assert.assertEquals(true,validate.validateUserName("banu"));
		Assert.assertEquals(false,validate.validateUserName("ban"));
		
	}

	@Test
	public void testValidatePassword() {
		Assert.assertEquals(true,validate.validatePassword("123456@"));
		Assert.assertEquals(false,validate.validatePassword("12345678"));
	}

	@Test
	public void testValidateAge() {
		Assert.assertEquals(true,validate.validateAge(21));
		Assert.assertEquals(false,validate.validateAge(15));
	}

}
