package com.cg.beans;

import java.util.Date;

public class Transaction
{
	private int transactionId;
	private String otherPartyId;
	private double amount;
	private String description;
	private double balance;
	private Date date;
	
	public Transaction (int transactionId, String otherPartyId, double amount, String description, double balance, Date date)
    {
	    this.transactionId = transactionId;
	    this.otherPartyId = otherPartyId;
	    this.amount = amount;
	    this.description = description;
	    this.balance = balance;
	    this.date = date;
    }

	public int getTransactionId ()
	{
		return transactionId;
	}

	public String getOtherPartyId ()
	{
		return otherPartyId;
	}

	public double getAmount ()
	{
		return amount;
	}

	public String getDescription ()
	{
		return description;
	}

	public double getBalance ()
    {
	    return balance;
    }
	
	public Date getDate ()
    {
	    return date;
    }
	
	@Override
    public String toString ()
    {
    	return new StringBuilder ().append ("Transaction id  : ").append (transactionId).append ('\n')
								   .append ("Trasaction      : ").append (otherPartyId).append ('\n')
								   .append ("Amount          : ").append (amount).append ('\n')
								   .append ("Description     : ").append (description).append ('\n')
								   .append ("Date            : ").append (date).append ('\n')
								   .toString ();
    }
}
