package com.cg.testing;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.exceptions.InvalidInputException;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.repo.RepositoryJDBC;
import com.cg.utils.Database;

public class RepositoryTest
{
	private RepositoryJDBC repository;
	
	public RepositoryTest ()
    {
	    repository = new RepositoryJDBC ();
    }
	
	@Before
	public void removeAll () throws SQLException
	{
		Database.update ("DELETE FROM customer");
		Database.update ("DELETE FROM wallet");
		Database.update ("DELETE FROM transaction");
	}
	
	// ------------------------------ Test Save ------------------------------
	
	@Test
	public void save_Name_98765432_1000 () throws InvalidInputException, SQLException
	{
		Customer customer = new Customer ("Hello", "98765432", 1000);
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
	public void findByMobile_98765432 () throws AccountNotFoundException, InvalidInputException, SQLException
	{
		Customer customer = new Customer ("Name", "98765432", 1000);
		repository.save (customer);
		assertEquals (customer, repository.findByMobile ("98765432"));
	}
	
	@Test (expected = AccountNotFoundException.class)
	public void findByMobile_Name () throws AccountNotFoundException, InvalidInputException
	{
		repository.findByMobile ("Name");
	}
	
	@Test (expected = InvalidInputException.class)
	public void findByMobile_null () throws AccountNotFoundException, InvalidInputException
	{
		repository.findByMobile (null);
	}
}
