package com.cg.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;

public class RepositoryJPA implements RepositoryInterface
{
	private EntityManager entityManager;
	
	public RepositoryJPA (EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	@Override
	public Customer save (Customer customer) throws InvalidInputException
	{
		validCustomer (customer);
		
		try
		{
			findByMobile (customer.getMobile ());
			throw new InvalidInputException ("Customer already exists!");
		}
		catch (AccountNotFoundException e)
		{
			entityManager.getTransaction ().begin ();
			customer = entityManager.merge (customer);
			entityManager.getTransaction ().commit ();
		}
		
		return customer;
	}

	@Override
	public Customer update (Customer customer) throws AccountNotFoundException, InvalidInputException
	{
		validCustomer (customer);
		
		entityManager.getTransaction ().begin ();
		customer = entityManager.merge (customer);
		entityManager.getTransaction ().commit ();
		
		return customer;
	}

	@Override
	public Customer findByMobile (String mobile) throws AccountNotFoundException, InvalidInputException
	{
		if (mobile == null) throw new InvalidInputException ("Mobile cannot be null");
		
		TypedQuery <Customer> query = entityManager.createQuery ("SELECT c FROM Customer c WHERE c.mobile=:mobile", Customer.class);
		query.setParameter ("mobile", mobile);
		
		List <Customer> customers = query.getResultList ();
		if (customers.isEmpty ()) throw new AccountNotFoundException ("No such account");
		
		return customers.get (0);
	}

	private void validCustomer (Customer customer) throws InvalidInputException
	{
		if (customer == null) throw new InvalidInputException ("Invalid Customer");
		
		if (customer.getName () == null) throw new InvalidInputException ("Name cannot be null");
		if (!customer.getName ().matches ("[a-zA-Z ]+")) throw new InvalidInputException ("Name should only contain alphabets");	
		
		if (customer.getMobile () == null) throw new InvalidInputException ("Mobile cannot be null");	
		if (!customer.getMobile ().matches ("[0-9]+")) throw new InvalidInputException ("Mobile should only contain numbers");
		if (customer.getMobile ().length () != 8) throw new InvalidInputException ("Invalid mobile number");
		
		if (customer.getWallet ().getBalance () < 0) throw new InvalidInputException ("Balance cannot be negative");
	}
}
