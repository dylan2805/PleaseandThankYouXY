package com.cg.beans;
import java.util.ArrayList;

public class Wallet
{
	private double balance;
	private ArrayList <Transaction> transactions;

	public Wallet (double balance)
    {
	    this.balance = balance;
	    this.transactions = new ArrayList <Transaction> ();
    }
	
	public double getBalance ()
	{
		return balance;
	}

	public void setBalance (double balance)
	{
		this.balance = balance;
	}
	
	public ArrayList <Transaction> getTransactions ()
    {
	    return transactions;
    }
	
	public void addTransaction (Transaction transaction)
	{
		this.transactions.add (transaction);
	}
}
