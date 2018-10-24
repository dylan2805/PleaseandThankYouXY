package com.cg.exceptions;

public class InsufficientBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -353151774858536714L;

	public InsufficientBalanceException(String message) {
		super(message);
	}
}
