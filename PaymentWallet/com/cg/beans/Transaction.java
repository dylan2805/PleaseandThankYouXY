package com.cg.beans;

import java.util.Date;

public class Transaction
{
	private int transactionId;
	private String participant;
	private double amount;
	private String description;
	private double balance;
	private Date date;
	
	public Transaction (int transactionId, String participant, double amount, String description, double balance, Date date)
    {
	    this.transactionId = transactionId;
	    this.participant = participant;
	    this.amount = amount;
	    this.description = description;
	    this.balance = balance;
	    this.date = date;
    }

	public int getTransactionId ()
	{
		return transactionId;
	}

	public String getParticipant ()
	{
		return participant;
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
	
    public String toString ()
    {
    	return new StringBuilder ().append ("Transaction ID  : ").append (transactionId).append ('\n')
								   .append ("TraNsaction     : ").append (participant).append ('\n')
								   .append ("Amount          : ").append (amount).append ('\n')
								   .append ("Description     : ").append (description).append ('\n')
								   .append ("Date            : ").append (date).append ('\n')
								   .toString ();
    }
}
