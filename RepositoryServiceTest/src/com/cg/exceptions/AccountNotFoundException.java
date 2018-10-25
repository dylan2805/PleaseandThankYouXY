package com.cg.exceptions;

public class AccountNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -536228654252594650L;

	public AccountNotFoundException(String message){
		super(message);
	}
}
