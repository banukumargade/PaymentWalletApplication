package com.capgemini.paymentwalletapplication.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.List;
import com.capgemini.paymentwalletapplication.bean.Account;
import com.capgemini.paymentwalletapplication.bean.ClientDetails;
import com.capgemini.paymentwalletapplication.exception.InValidDetailsException;
import com.capgemini.paymentwalletapplication.exception.InvalidUserException;
import com.capgemini.paymentwalletapplication.exception.NoPayeeFoundException;
import com.capgemini.paymentwalletapplication.exception.NoSufficientBalanceException;
import com.capgemini.paymentwalletapplication.service.ClientDataValidate;
import com.capgemini.paymentwalletapplication.service.ClientService;

public class Client {

	public static void main(String[] args) {
		int choice=0;
		
		do {
			
		System.out.println("**********welcome to paymentwallet application********************");
			System.out.println("SELECT ONE OF THE FOLLOWING OPTIONS TO PROCEED:");
			System.out.println("1. Create Account \n");
			System.out.println("2. login \n");
			System.out.println("3. Exit \n");
			
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("enter your choice:");
			
			try {
				choice=Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			catch(NumberFormatException e) {
				e.printStackTrace();
				}
			
			switch(choice)
			{
			case(1):{
				createAccount();
			break;
			}
			case(2):{
				login();
			break;
			}
			
			case(3):{
				System.out.println("thank you for using Payment wallet application");
				System.exit(0);
			break;
			}
		
	}
		}while(choice!=3);
}

	private static void createAccount() {
		
		ClientService service=new ClientService();
		ClientDataValidate validate=new ClientDataValidate();
		List<String> trans =new ArrayList<String>();
		ClientDetails cdetails = new ClientDetails();
		try { 
			
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
				System.out.println("Enter Fullname: \n");
				String fullName=br.readLine();
				System.out.println("Gender(male/female): \n");
				String gender =br.readLine();
				System.out.println("Age(18-100 only): \n");
				int age =Integer.parseInt(br.readLine());
				System.out.println("Email(@gmail.com or @capgemini.com only): \n");
				String email =br.readLine();
				System.out.println("phone number(10 digit): \n");
				String phoneNumber =br.readLine();
				System.out.println("Enter Username(Atleast 4 charcters): \n");
				String userName=br.readLine();
				System.out.println("Enter password(should contain atleast 8 charcters(including one special charcter)) :\n");
				String password=br.readLine();
				System.out.println("enter amount:(min of 1000 required to create an account)");
				double amount=Double.parseDouble(br.readLine());
				
				
				long accNo = (long) (Math.random()*112345+999);
				ClientDetails data=new ClientDetails();
				Account details=new Account();
				data.setFullName(fullName);
				data.setAge(age);
				data.setEmail(email);
				data.setGender(gender);
				data.setPhoneNumber(phoneNumber);
				details.setUserName(userName);
				details.setPassword(password);
				details.setAccNo(accNo);
				details.setAmount(amount);
				details.setCd(data);
				
				boolean isValidEmail=validate.validateEmail(email);
				boolean isValidGender=validate.validateGender(gender);
				boolean isValidPassword=validate.validatePassword(password);
				boolean isValidPhoneNumber=validate.validatePhoneNumber(phoneNumber);
				boolean isValidAge=validate.validateAge(age);
				boolean isValidUserName=validate.validateUserName(userName);
				
				if(isValidEmail&&isValidGender&&isValidPassword&&isValidPhoneNumber&&isValidAge&&isValidUserName) {
					int a=service.createAccount(details,cdetails);
					
					if(a==1) {
					System.out.println("Your account successfully created with account number:"+ accNo);
					}
					else {
						try {
							throw new InValidDetailsException("Enter valid details");
						}

						catch (InValidDetailsException e) {
							e.printStackTrace();
						}
					}
				}
				else {
					System.out.println("Account creation is failed due to:");
					if(isValidEmail==false)
					{
						System.out.println("Enter valid email");
					}
					if(isValidGender==false)
					{
						System.out.println("Enter valid gender");
					}
					if(isValidPassword==false)
					{
						System.out.println("Enter valid password");
					}
					if(isValidPhoneNumber==false)
					{
						System.out.println("Enter valid phonenumber");
					}
				}
				
		}
		catch(NumberFormatException e)
		{
			System.err.println("Enter correct characters");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	private static void login() {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int choice=0;
		System.out.println("enter username");
		
		try {
			String userName=br.readLine();
			System.out.println("Enter password");
			String password=br.readLine();
			ClientService service=new ClientService();
			if(service.testLogin(userName,password)) {
				do {
					
					System.out.println("1. Show Balance \n");
					System.out.println("2. Deposit \n");
					System.out.println("3. withdraw \n");
					System.out.println("4. Fund Transfer \n");
					System.out.println("5. Print Transactions \n");
					System.out.println("6. Logout \n");
					
					System.out.println("enter your choice:");
					try {
					choice=Integer.parseInt(br.readLine());
					}
					
					catch(NumberFormatException e) {
						e.printStackTrace();
					}
				
					switch(choice) {
					case(1):
					{
						System.out.println("Balance in your account is:"+service.showBalance());
						break;
					}
					case(2):
					
						try {
						System.out.println("enter the amount to deposit");
						double amount = Double.parseDouble(br.readLine());
						service.deposit(amount);
							
						}
						catch(NumberFormatException e) {
							e.printStackTrace();
						}
						
						
						break;
					
					case(3):
						try {
						System.out.println("enter amount to withdraw");
						double amount=Double.parseDouble(br.readLine());
						int b=service.withdraw(amount);
						if(b==0) {
							try {
								throw new NoSufficientBalanceException("insufficient balance....cannot withdraw");
							}
							catch(NoSufficientBalanceException e) {
								e.printStackTrace();
							}
						}
						}
						catch(NumberFormatException e) {
							e.printStackTrace();
						}
						catch(IOException e){
							e.printStackTrace();
						}
					break;
	
					case(4):
						
					System.out.println("enter payee account number:");
					long AccNo =Long.parseLong(br.readLine());
					System.out.println("enter amount to be transfer:");
					double amount=Double.parseDouble(br.readLine());
					service.fundTransfer(AccNo, amount);
					if(service.fundTransfer(AccNo, amount)==0) {
						try {
							throw new NoPayeeFoundException("No payee found to transfer.....fundtransfer failed");
						}
						catch(NoPayeeFoundException e) {
							e.printStackTrace();
						}
					}
					break;
					
					case(5):
						System.out.println(service.printTransaction());
						break;
						
					case(6):
					
						break;
					
					}
				
					
				}
				while(choice!=6);
			}
			
			else {
				try {
				throw new InvalidUserException("Login failed");
				}
				catch(InvalidUserException e) {
					e.printStackTrace();
				}
			}
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


