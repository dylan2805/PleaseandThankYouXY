package com.capgemini.question4;

import com.capgemini.utils.Keyboard;

public class Question42
{
	private static String menu [] = {"Current", "Savings"};	// Menu options
	
	public static void main (String [] args)
	{
		int choice = Keyboard.menuInput ("Select account", menu);		// Display menu for user choice
		double balance = Keyboard.readDouble ("Enter balance : ");		// Get balance value
		double withdraw = Keyboard.readDouble ("Enter withdraw : ");	// Get withdraw amount
		
		if (choice == 1)	// Current Account
		{
			double overdraftLimit = Keyboard.readDouble ("Specify overdraft limit : ");
			new CurrentAccount (balance, overdraftLimit).withdraw (withdraw);
		}
		else	// Savings account
		{
			double minBalance = Keyboard.readDouble ("Specify minimum balance : ");
			new CurrentAccount (balance, minBalance).withdraw (withdraw);
		}
	}	
}
