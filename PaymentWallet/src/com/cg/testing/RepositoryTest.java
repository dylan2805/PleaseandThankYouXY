package com.cg.testing;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.repo.RepositoryJPA;

public class RepositoryTest
{
	private static RepositoryJPA repository;
	
	@BeforeClass
	public static void init ()
	{
		repository = new RepositoryJPA (Persistence.createEntityManagerFactory ("wallet").createEntityManager ());
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
		
		try
		{
			repository.save (customer);
		}
		catch (InvalidInputException e)
		{
			if (!e.getMessage ().equals ("Customer already exists!")) throw e;
		}
		finally
		{
			assertEquals (customer, repository.findByMobile ("98765432"));
		}
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
