package com.cg.utils;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Keyboard
{
	@SuppressWarnings ("resource")
	public static String readString (String prompt)
	{
		// Print prompt and read user input using scanner
		System.out.print (prompt);
		return new java.util.Scanner (System.in).nextLine ();
	}

	public static char readChar (String prompt)
	{
		String input = readString (prompt);	// Get user input as string

		if (input.length () == 0)			// If input length is 0 log error
		{
			System.err.println (ERROR.CHAR);
			return readChar (prompt);		// Ask for user input again
		}

		return input.charAt (0);			// Return first char in user input
	}

	public static int readInt (String prompt)
	{
		int input;

		try
		{
			input = Integer.parseInt (readString (prompt));	// Read user input as string and convert to int
		}
		catch (NumberFormatException nfe)
		{
			System.err.println (ERROR.INTEGER);				// Conversion fails log error
			return readInt (prompt);						// Ask for input again
		}

		return input;										// Return results
	}

	public static float readFloat (String prompt)
	{
		float input;

		try
		{
			input = Float.parseFloat (readString (prompt));	// Read user input as string and convert to float
		}
		catch (NumberFormatException nfe)
		{
			System.err.println (ERROR.FLOAT);				// Conversion fails log error
			return readFloat (prompt);						// Ask for input again
		}

		return input;										// Return results
	}

	public static double readDouble (String prompt)
	{
		double input;

		try
		{
			input = Double.parseDouble (readString (prompt));	// Read user input as string and convert to int
		}
		catch (NumberFormatException nfe)
		{
			System.err.println (ERROR.DOUBLE);					// Conversion fails log error
			return readDouble (prompt);							// Ask for input again
		}

		return input;											// Return results
	}

	public static LocalDate readDate (String prompt)
	{
		LocalDate date = null;

		try
		{
			String input [] = Keyboard.readString (prompt + "[DD/MM/YYYY] ").split ("/");	// Get input and split by "/"
			int day = Integer.parseInt (input [0]);											// Try converting values to int
			int month = Integer.parseInt (input [1]);
			int year = Integer.parseInt (input [2]);

			date = LocalDate.of (year, month, day);											// Try converting values to date
		}
		catch (NumberFormatException nfe)
		{
			System.err.println (ERROR.DATE_FORMAT);	// Conversion fails, log error
			return readDate (prompt);				// Ask for input again
		}
		catch (DateTimeException dte)
		{
			System.err.println (ERROR.DATE);			// Invalid date, log error
			return readDate (prompt);				// Ask for input again
		}

		return date;	// Return result
	}

	public static int menuInput (String title, String menu [])
	{
		printLine ('=', 50);
		System.out.println (title.toUpperCase ());					// Print menu title in uppercase
		printLine ('-', 50);

		for (int i = 0; i < menu.length; ++ i)						// Show all menu items base on menu array

			System.out.println ("[" + (i + 1) + "] " + menu [i]);

		System.out.println ("[0] Quit");							// Value 0 means quit
		printLine ('-', 50);

		int choice = readInt ("Your Choice : ");					// Ask for user's choice as int

		while (choice < 0 || choice > menu.length)
		{
			System.err.println (ERROR.OPTION);						// If user input out of range log error
			choice = readInt ("Your Choice : ");					// Ask for user input again
		}

		return choice;												// Return result
	}

	private static void printLine (char symbol, int length)
	{
		// Prints a line of symbol with the size of length
		for (int i = 0; i < length; ++ i)

			System.out.print (symbol);

		System.out.println ();
	}

	private static enum ERROR
	{
		CHAR, INTEGER, FLOAT, DOUBLE, DATE_FORMAT, DATE, OPTION;

		public String toString ()	// Returns string of error message based on enum
		{
			switch (this)
			{
				case CHAR:
					return "*** Please enter a char ***";

				case INTEGER:
					return "*** Please enter an integer ***";

				case FLOAT:
					return "*** Please enter a float ***";

				case DOUBLE:
					return "*** Please enter a double ***";

				case DATE_FORMAT:
					return "*** Invalid date format ***";

				case DATE:
					return "*** Invalid date ***";

				case OPTION:
					return "*** Invalid option ***";
			}

			return "";
		};
	}
}