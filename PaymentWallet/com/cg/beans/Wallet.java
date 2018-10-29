package com.cg.beans;

import java.util.List;
import java.util.ArrayList;

public class Wallet
{
	private double balance;
	private List <Transaction> transactions;

	public Wallet (double balance)
	{
		this.balance = balance;
		this.transactions = new ArrayList <Transaction> ();
	}

	public double getBalance ()
	{
		return balance;
	}

	public List <Transaction> getTransactions ()
	{
		return transactions;
	}

	public void setBalance (double balance)
	{
		this.balance = balance;
	}
	
	public void setTransactions (List <Transaction> transactions)
	{
		this.transactions = transactions;
	}
}
