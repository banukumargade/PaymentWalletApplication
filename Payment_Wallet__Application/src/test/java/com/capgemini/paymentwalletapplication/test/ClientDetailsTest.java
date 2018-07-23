package com.capgemini.paymentwalletapplication.test;

import org.junit.Test;
import com.capgemini.paymentwalletapplication.bean.ClientDetails;
import com.capgemini.paymentwalletapplication.service.ClientService;

import junit.framework.Assert;

public class ClientDetailsTest {
	ClientDetails details;
	ClientService service =new ClientService();

	@Test
	public void testGetFullName() {
		details.setFullName("banukumargade");
		Assert.assertEquals("banukumar",details.getFullName());
		Assert.assertNotSame("banukumargade", details.getFullName() );
		details.getPassword();
	}

	@Test
	public void testGetGender() {
		details.setGender("male");
		Assert.assertNotSame("male",details.getGender());
		Assert.assertEquals("m",details.getGender());
		Assert.assertFalse(" ".equals(details.getGender()));
	}


	@Test
	public void testGetAge() {
		
		details.setAge(22);
		Assert.assertNotNull(getClass());
		Assert.assertEquals("21",details.getAge());
		Assert.assertNotSame("21",details.getAge());
	}

	

	@Test
	public void testGetPhoneNumber() {
		
		details.setPhoneNumber("9502518489");
		Assert.assertEquals("8919759512",details.getPhoneNumber());
		Assert.assertNotSame("9502518489","  ");
		
	}


	@Test
	public void testGetEmail() {
		details.setEmail("xyz@capgemini.com");
		Assert.assertEquals("xyz@capgemini.com",details.getEmail());
		Assert.assertNotSame("xyz@gmail.com","  ");
	}

	




}
