package com.capgemini.solutions;

import java.util.LinkedHashSet;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class Question31
{
	// Create menu
	private static final String menu [] = {"Add String to itself",
							  			   "Replace odd positions with #",
							  			   "Remove duplicate characters in the String",
							  			   "Change odd characters to upper case"};
	private String string;
	
	public void run ()
	{
		string = Keyboard.readString ("Enter a string : ");	// Get string from user
		int choice = -1;
		
		while (choice != 0)
		{
			choice = Keyboard.menuInput ("Select an option", menu); // User menu to ask user choice
			
			switch (choice)
			{
				case 1:
					addString ();
					break;
				
				case 2:
					replaceOdd ();
					break;
					
				case 3:
					removeDuplicate ();
					break;
				
				case 4:
					changeOdd ();
			}
			
			if (choice != 0)
			{
				Logging.LOG.info (string);
				Logging.LOG.info ("");
			}
		}
	}
	
	public void addString ()	// Function to concatenate string with itself
	{
		string += string;
	}
	
	public void replaceOdd ()
	{
		char charArr [] = string.toCharArray ();		// Convert string to char array
		
		for (int i = 1; i < charArr.length; i += 2)		// Loop through odd chars and replace with #
			
			charArr [i] = '#';
		
		string = new String (charArr);					// Convert charArray to string
	}
	
	public void removeDuplicate ()
	{
		char charArray [] = string.toCharArray ();							// Convert string to char array
		LinkedHashSet <Character> set = new LinkedHashSet <Character> ();
		
		for (char c : charArray) set.add (c);								// Add all char into set to remove duplicates
		
		StringBuilder sb = new StringBuilder ();							// Append all chars using string builder
		for (Character c : set)
			
			sb.append (c);
		
		string = sb.toString ();											// Convert back to string
	}
	
	public void changeOdd ()
	{
		char charArr [] = string.toCharArray ();				// Convert string to char array
		
		for (int i = 1; i < charArr.length; i += 2)				// Use Character class to turn odd char to uppercase
		
			charArr [i] = Character.toUpperCase (charArr [i]);
		
		string = new String (charArr);							// Convert char array back to string
	}
	
	public static void main (String [] args)
	{
		new Question31 ().run ();
	}
}
