package com.cg.beans;

public class Customer
{
	private String mobile;
	private String name;
	private Wallet wallet;

	public Customer (String name, String mobile, double balance)
    {
	    this.name = name;
	    this.mobile = mobile;
	    this.wallet = new Wallet (balance);
    }

	public String getMobile ()
	{
		return this.mobile;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public Wallet getWallet ()
	{
		return this.wallet;
	}

	@Override
    public String toString ()
    {
	    return "Customer [mobile=" + mobile + ", name=" + name + "]";
    }

	@Override
    public boolean equals (Object obj)
    {
	    if (obj instanceof Customer)
	    {
	    	Customer customer = (Customer) obj;
	    	return this.mobile.equals (customer.mobile);
	    }
	    
	    return false;
    }
}
