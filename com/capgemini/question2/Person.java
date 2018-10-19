package com.capgemini.question2;

import com.cg.eis.exception.BlankNameException;

public class Person
{
	// Attributes
	private String firstName;
	private String lastName;
	private char gender;
	private int age;
	private double weight;

	// Constructor
	public Person (String firstName, String lastName, char gender, int age, double weight) throws BlankNameException
	{
		if (firstName.equals ("")) throw new BlankNameException ("*** First name cannot be blank ***");
		if (lastName.equals ("")) throw new BlankNameException ("*** Last name cannot be blank ***");
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.weight = weight;
	}

	// toString function override
	public String toString ()
	{
		StringBuilder sb = new StringBuilder ();

		sb.append ("Person details :\n")
		  .append ("----------------\n")
		  .append ("First name : ").append (firstName).append ('\n')
		  .append ("Last name  : ").append (lastName).append ('\n')
		  .append ("Gender     : ").append (gender).append ('\n')
		  .append ("Age        : ").append (age).append ('\n')
		  .append ("Weight     : ").append (weight);

		return sb.toString ();
	}
}