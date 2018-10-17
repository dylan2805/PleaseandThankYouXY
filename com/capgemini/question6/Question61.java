package com.capgemini.question6;

import com.capgemini.question2.Person;
import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;
import com.cg.eis.exception.BlankNameException;

public class Question61
{
	public static void main (String [] args)
	{
		// Read user inputs
		String firstName = Keyboard.readString ("First name : ");
		String lastName = Keyboard.readString ("Last name : ");
		char gender = Character.toUpperCase (Keyboard.readChar ("Gender : "));
		int age = Keyboard.readInt ("Age : ");
		double weight = Keyboard.readDouble ("Weight : ");
		
		try
		{
			Logging.LOG.info (new Person (firstName, lastName, gender, age, weight));
		}
		catch (BlankNameException e)
		{
			Logging.LOG.error (e.getMessage ());
		}
	}
}
