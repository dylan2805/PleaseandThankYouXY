package com.cg.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String mobile;
	private String name;
	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Wallet wallet;

	public Customer ()
	{
		super ();
	}

	public Customer (String name, String mobile, double balance)
    {
	    this.name = name;
	    this.mobile = mobile;
	    this.wallet = new Wallet (balance);
    }

	public int getId ()
	{
		return this.id;
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
