package com.cg.beans;

import java.util.Date;

public class Transaction
{
	private int transactionId;
	private int otherPartyId;
	private double amount;
	private String description;
	private Date date;
	
	public Transaction (int transactionId, int otherPartyId, double amount, String description, Date date)
    {
	    this.transactionId = transactionId;
	    this.otherPartyId = otherPartyId;
	    this.amount = amount;
	    this.description = description;
	    this.date = date;
    }

	public int getTransactionId ()
	{
		return transactionId;
	}

	public int getOtherPartyId ()
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
