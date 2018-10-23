package com.cg.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;

public class Repository
{
	private Map <String, Customer> customers;
	
	public Repository ()
    {
		customers = new HashMap <String, Customer> ();
    }
	
	public Customer save (Customer customer) throws InvalidInputException
	{
		if (customer == null) throw new InvalidInputException ("Invalid Customer");
		
		if (customer.getName () == null) throw new InvalidInputException ("Invalid Name");
		if (!customer.getName ().matches ("[a-zA-Z]+")) throw new InvalidInputException ("Invalid Name");	
		
		if (customer.getMobile () == null) throw new InvalidInputException ("Invalid Mobile");	
		if (customer.getMobile ().length () != 8) throw new InvalidInputException ("Invalid Mobile");
		if (!customer.getMobile ().matches ("[0-9]+")) throw new InvalidInputException ("Invalid Mobile");
		
		if (customer.getWallet ().getBalance () < 0) throw new InvalidInputException ("Invalid Balance");
		
		customers.put (customer.getMobile (), customer);
		return customer;
	}
	
	public Customer findByMobile (String mobile) throws AccountNotFoundException, InvalidInputException
	{
		if (mobile == null) throw new InvalidInputException ("Invalid Mobile");
		
		Customer customer = customers.get (mobile);
		if (customer == null) throw new AccountNotFoundException ("Account with mobile " + mobile + " not found");
		
		return customer;
	}
}
