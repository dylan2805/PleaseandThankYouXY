package com.cg.beans;
public class Transaction
{
	private int transactionId;
	private int otherPartyId;
	private double amount;
	private String description;
	
	public Transaction (int transactionId, int otherPartyId, double amount, String description)
    {
	    this.transactionId = transactionId;
	    this.otherPartyId = otherPartyId;
	    this.amount = amount;
	    this.description = description;
    }

	@Override
    public String toString ()
    {
    	// to do
		return null;
    }
}
