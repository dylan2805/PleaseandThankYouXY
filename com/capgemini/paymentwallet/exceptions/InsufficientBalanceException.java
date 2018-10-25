package com.capgemini.paymentwallet.exceptions;

/**
 * @author arulnr
 *
 */
public class InsufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientBalanceException(String msg) {

		super(msg);

	}

}
