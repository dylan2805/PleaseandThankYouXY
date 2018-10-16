package com.capgemini.solutions;

import java.util.Arrays;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class Question71a
{
	public static void main (String [] args)
	{
		// Create strArr with size specified by user
		String strArr [] = new String [Keyboard.readInt ("Enter number of products : ")];
		
		for (int i = 0; i < strArr.length; ++ i)	// Get user inputs
			
			strArr [i] = Keyboard.readString ("Enter product " + (i + 1) + " : ");
		
		Arrays.sort (strArr);	// Sort array
		
		Logging.LOG.info ("Result : " + Arrays.toString (strArr)); // Display result
	}
}
