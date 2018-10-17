package com.capgemini.question4;

import com.capgemini.utils.Logging;

public class SavingsAccount extends Account
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
