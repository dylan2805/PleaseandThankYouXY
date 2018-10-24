package com.capgemini.paymentwallet.exceptions;

/**
 * @author arulnr
 *
 */
public class CustomerExistException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CustomerExistException(String msg){
		super(msg);
	}

}
