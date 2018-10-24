package com.cg.exceptions;

public class InsufficientBalanceException extends Exception
{
    private static final long serialVersionUID = -5791938823954947926L;

	public InsufficientBalanceException (String message)
    {
		super (message);
    }
}
