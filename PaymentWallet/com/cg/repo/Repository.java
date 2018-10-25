package com.cg.repo;

import java.util.HashMap;
import java.util.Map;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;

public class Repository implements RepositoryInterface
{
	private Map <String, Customer> customers;
	
	public Repository ()
    {
		customers = new HashMap <String, Customer> ();
    }
	
	public Repository (Map <String, Customer> customers)
    {
		// Should use this, allows for varying implementation of map
		// Default constructor forces map to only be HashMap
	    this.customers = customers;
    }

	public Customer save (Customer customer) throws InvalidInputException
	{
		if (customer == null) throw new InvalidInputException ("Invalid Customer");
		
		if (customer.getName () == null) throw new InvalidInputException ("Name cannot be null");
		if (!customer.getName ().matches ("[a-zA-Z ]+")) throw new InvalidInputException ("Name should only contain alphabets");	
		
		if (customer.getMobile () == null) throw new InvalidInputException ("Mobile cannot be null");	
		if (!customer.getMobile ().matches ("[0-9]+")) throw new InvalidInputException ("Mobile should only contain numbers");
		if (customer.getMobile ().length () != 8) throw new InvalidInputException ("Invalid mobile number");
		
		if (customer.getWallet ().getBalance () < 0) throw new InvalidInputException ("Balance cannot be negative");
		
		customers.put (customer.getMobile (), customer);
		return customer;
	}
	
	public Customer findByMobile (String mobile) throws AccountNotFoundException, InvalidInputException
	{
		if (mobile == null) throw new InvalidInputException ("Mobile cannot be null");
		
		Customer customer = customers.get (mobile);
		if (customer == null) throw new AccountNotFoundException ("Account with mobile " + mobile + " not found");
		
		return customer;
	}
}
