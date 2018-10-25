package com.capgemini.paymentwallet.exceptions;

/**
 * @author arulnr
 *
 */
public class AccountNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AccountNotFoundException(String msg){
		super(msg);
	}

}
