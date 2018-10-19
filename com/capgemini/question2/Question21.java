package com.capgemini.question2;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;
import com.cg.eis.exception.BlankNameException;

public class Question21
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
			// print result using toString
			System.out.println ();
			System.out.println (new Person (firstName, lastName, gender, age, weight));
		}
		catch (BlankNameException e)
		{
			Logging.LOG.error (e.getMessage ());
		}
	}
}
