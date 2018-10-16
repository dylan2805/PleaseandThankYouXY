package com.capgemini.solutions;

import com.capgemini.utils.Keyboard;
import com.capgemini.utils.Logging;

class Account
{
	private double balance;
	
	Account ()
	{
		this.balance = 0;
	}
	
	Account (double balance)
	{
		this.balance = balance;
	}
	
	public void withdraw (double amount)
	{
		this.balance -= amount;
	}
	
	public double getBalance ()
	{
		return balance;
	}
}

class SavingsAccount extends Account
{
	private final double MIN_BALANCE;

	SavingsAccount (double balance, double minBalance)
	{
		// Set balance and minBalance
		super (balance);
		this.MIN_BALANCE = minBalance;
	}
	
	@Override
	public void withdraw (double amount)
	{
		// Valid of balance > amount and difference >= MIN_BALANCE
		if (getBalance () - amount >= MIN_BALANCE)
		{
			super.withdraw (amount);	// If valid deduct withdraw amount from balance
			Logging.LOG.info ("Withdraw success!");
		}
		else
		{
			Logging.LOG.error ("Withdraw failed");
		}
	}
}

class CurrentAccount extends Account
{
	private double overdraftLimit;
	private boolean limitReached;
	
	public CurrentAccount (double balance, double overdraftLimit)
	{
		// Set balance and overdraftLimit
		super (balance);
		this.overdraftLimit = overdraftLimit;
	}
	
	@Override
	public void withdraw (double amount)
	{	
		// withdraw allowed if condition is met
		limitReached = Math.abs (getBalance () - amount) >= overdraftLimit;
		if (!limitReached)
		{
			super.withdraw (amount);
			Logging.LOG.info ("Withdraw success!");
		}
		else
		{
			Logging.LOG.error ("Withdraw failed");
		}
	}
}

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
