package com.cg.testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.exceptions.InvalidInputException;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.repo.Repository;

public class RepositoryTest
{
	private Repository repository;
	
	@Before
	public void init ()
	{
		repository = new Repository ();
	}
	
	// ------------------------------ Test Save ------------------------------
	
	@Test
	public void save_Name_98765432_1000 () throws InvalidInputException
	{
		Customer customer = new Customer ("Name", "98765432", 1000);
		assertEquals (customer, repository.save (customer));
	}
	
	@Test (expected = InvalidInputException.class)
	public void save_98765432_98765432_1000 () throws InvalidInputException
	{
		Customer customer = new Customer ("92837472", "92837472", 1000);
		repository.save (customer);
	}
	
	@Test (expected = InvalidInputException.class)
	public void save_Name_Name_1000 () throws InvalidInputException
	{
		Customer customer = new Customer ("Name", "Name", 1000);
		repository.save (customer);
	}
	
	@Test (expected = InvalidInputException.class)
	public void save_98765432_Name_1000 () throws InvalidInputException
	{
		Customer customer = new Customer ("98765432", "Name", 1000);
		repository.save (customer);
	}
	
	@Test (expected = InvalidInputException.class)
	public void save_null_98765432_1000 () throws InvalidInputException
	{
		Customer customer = new Customer (null, "98765432", 1000);
		repository.save (customer);
	}
	
	@Test (expected = InvalidInputException.class)
	public void save_Name_null_1000 () throws InvalidInputException
	{
		Customer customer = new Customer ("Name", null, 1000);
		repository.save (customer);
	}
	
	@Test (expected = InvalidInputException.class)
	public void save_null () throws InvalidInputException
	{
		repository.save (null);
	}

	// ------------------------------ Test findBy ------------------------------
	
	@Test
	public void findByMobile_98765432 () throws InvalidInputException, AccountNotFoundException
	{
		Customer customer = new Customer ("Name", "98765432", 1000);
		assertEquals (customer, repository.save (customer));
		assertEquals (customer, repository.findByMobile ("98765432"));
	}
	
	@Test (expected = AccountNotFoundException.class)
	public void findByMobile_Name () throws InvalidInputException, AccountNotFoundException
	{
		repository.findByMobile ("Name");
	}
	
	@Test (expected = InvalidInputException.class)
	public void findByMobile_null () throws InvalidInputException, AccountNotFoundException
	{
		repository.findByMobile (null);
	}
}
