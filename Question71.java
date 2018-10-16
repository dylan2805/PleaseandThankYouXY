package com.capgemini.solutions;

import java.util.Arrays;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class Question71
{
	public static void main (String [] args)
	{
		String input = Keyboard.readString ("Enter product names (separated by <space>) : ");	// Get product names
		String strArr [] = input.split (" ");													// Split by blank space
		
		Arrays.sort (strArr);	// Sort array
		
		Logging.LOG.info ("Result : " + Arrays.toString (strArr));	// Print result
	}
}
