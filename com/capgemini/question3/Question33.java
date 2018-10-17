package com.capgemini.question3;

import java.time.LocalDate;
import java.time.Period;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

public class Question33
{	
	public static void main (String [] args)
	{
		LocalDate date = Keyboard.readDate ("Enter a date : ");	// Read date in DD/MM/YYYY format
		LocalDate now = LocalDate.now ();						// Get current date
		Logging.LOG.info (Period.between (now, date));			// Print duration
	}
}