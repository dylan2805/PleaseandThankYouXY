package com.capgemini.solutions;

import java.time.LocalDate;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class Question35
{
	public static void main (String [] args)
	{
		LocalDate purchaseDate = Keyboard.readDate ("Enter purchase date : ");					// Get purchase date in DD/MM/YYYY format
		int warranty [] = Question35.readWarranty ("Enter warranty : ");						// Get warranty period
		
		LocalDate expiry = purchaseDate.plusYears (warranty [0]).plusMonths (warranty [1]);		// Calculate expire date
		Logging.LOG.info ("Expiry date : " + expiry);											// Print result
	}
	
	private static int [] readWarranty (String prompt)
	{
		String input = Keyboard.readString (prompt + "[years months] ");	// Get date input as string
		String warranty [] = input.split (" ");								//Split based on blank space
		
		int years = 0;
		int months = 0;
		
		try
		{
			// Try convert years and months to int
			years = Integer.parseInt (warranty [0]);
			months = Integer.parseInt (warranty [1]);
		}
		catch (NumberFormatException nfe)
		{
			// If converstion fails report error and request input again
			Logging.LOG.error ("*** Invalid warranty format ***");
			return readWarranty (prompt);
		}
		
		return new int [] {years, months};
	}
}