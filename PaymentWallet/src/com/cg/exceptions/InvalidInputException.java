package com.cg.exceptions;

public class InvalidInputException extends Exception
{
    private static final long serialVersionUID = -4157958511075140162L;

	public InvalidInputException (String message)
	{
		super (message);
	}
}
