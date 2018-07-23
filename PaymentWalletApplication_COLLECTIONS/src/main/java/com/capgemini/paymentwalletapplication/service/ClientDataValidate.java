package com.capgemini.paymentwalletapplication.service;

public class ClientDataValidate {
	
	public boolean validateGender(String gender) {
		if(gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female"))
			return true;
		else
			return false;
	}
	
	public boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber.length()==10)
			return true;
		else
			return false;
	}
	
	public boolean validateEmail(String email) {
		if(email.endsWith("@capgemini.com")||email.endsWith("@gmail.com"))
			return true;
		else
			return false;
	}
	
	public boolean validateUserName(String userName) {
		if(userName.length()>=4)
			return true;
		else
			return false;
	}
	
	public boolean validatePassword(String password) {
		if((password.length()>=6)&&((password.contains("@")||password.contains("#")||password.contains("$"))))
			return true;
		else
			return false;
	}
	
	public boolean validateAge(int age) {
		if(age>=18 && age<=100)
			return true;
		else
			return false;
	}
	
	
	
}
