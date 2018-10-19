package com.capgemini.question4;

public class Account
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
