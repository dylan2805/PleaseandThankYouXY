package com.capgemini.question4;

import com.capgemini.utils.Logging;

public class CurrentAccount extends Account
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