package com.capgemini.paymentwalletapplication.exception;

public class NoPayeeFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	private String string;
	public NoPayeeFoundException(String string) {
		// TODO Auto-generated constructor stub
		this.string=string;
	}
	@Override
	public String toString() {
		return "InValidDetailsException [string=" + string + "]";
	}

}
