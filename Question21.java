package com.capgemini.solutions;

import com.capgemini.utils.Keyboard;

class Person
{
	// Attributes
	private String firstName;
	private String lastName;
	private char gender;
	private int age;
	private double weight;

	// Constructor
	public Person (String firstName, String lastName, char gender, int age, double weight)
	{
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

		// print result using toString
		System.out.println ();
		System.out.println (new Person (firstName, lastName, gender, age, weight));
	}
}
