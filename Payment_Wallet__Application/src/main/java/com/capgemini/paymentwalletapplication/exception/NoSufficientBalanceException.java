package com.capgemini.paymentwalletapplication.exception;

public class NoSufficientBalanceException extends Exception{
	private static final long serialVersionUID = 1L;
	private String string;
	public NoSufficientBalanceException(String string) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "InValidDetailsException [string=" + string + "]";
	}

}
