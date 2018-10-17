package com.capgemini.other;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class PositiveNegative
{
	public static void main (String [] args)
	{
		int number = Keyboard.readInt ("Enter an int : ");
		
		if (number > 0)			// If greater than 0
			
			Logging.LOG.info ("Positive");
		
		else if (number < 0)	// If less than 0
			
			Logging.LOG.info ("Negative");
		
		else					// If 0
			
			Logging.LOG.info (0);
	}
}
