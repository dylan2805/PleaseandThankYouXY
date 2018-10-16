package com.capgemini.solutions;

import com.capgemini.utils.Keyboard;

@SuppressWarnings ("serial")
class BlankNameException extends Exception
{
	public BlankNameException (String message)
	{
		super (message);
	}
}

class PersonException
{
	private String firstName;
	private String lastName;
	private char gender;

	public String getFirstName ()
	{
		return firstName;
	}

	public void setFirstName (String firstName) throws BlankNameException
	{
		if (firstName.equals ("")) throw new BlankNameException ("*** First name cannot be blank ***");
		this.firstName = firstName;
	}

	public String getLastName ()
	{
		return lastName;
	}

	public void setLastName (String lastName) throws BlankNameException
	{
		if (lastName.equals ("")) throw new BlankNameException ("*** Last name cannot be blank ***");
		this.lastName = lastName;
	}

	public char getGender ()
	{
		return gender;
	}

	public void setGender (char gender)
	{
		this.gender = gender;
	}
}

public class Question61
{
	public static void main (String [] args)
	{
		PersonException person = new PersonException ();
		
		String firstName = Keyboard.readString ("First Name : ");
		String lastName = Keyboard.readString ("Last Name : ");
		
		try
		{
			person.setFirstName (firstName);
			person.setLastName (lastName);
		}
		catch (BlankNameException e)
		{
			System.out.println (e.getMessage ());
		}
	}
}
