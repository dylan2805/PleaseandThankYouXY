package com.cg.exceptions;
public class AccountNotFoundException extends Exception
{
	private static final long serialVersionUID = -4212896790055413234L;

	public AccountNotFoundException (String message)
	{
		super (message);
	}
}