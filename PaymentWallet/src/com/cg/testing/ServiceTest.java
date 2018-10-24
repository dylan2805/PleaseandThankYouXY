package com.cg.testing;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.repo.Repository;
import com.cg.service.Service;

public class ServiceTest
{
	private Service service;
	
	public ServiceTest ()
	{
		service = new Service (new Repository (new HashMap <String, Customer> ()));
	}

	// ------------------------------ createAccount () ------------------------------
	
	@Test
	public void createAccount_Name_98765432_1000 () throws InvalidInputException
	{
		Customer customer = new Customer ("Name", "98765432", 1000);
		assertEquals (customer, service.createAccount ("Name", "98765432", 1000));
	}
	
	@Test
	public void createAccount_Name_98765432_0 () throws InvalidInputException
	{
		Customer customer = new Customer ("Name", "98765432", 0);
		assertEquals (customer, service.createAccount ("Name", "98765432", 0));
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_98765432_98765432_1000 () throws InvalidInputException
	{
		service.createAccount ("98765432", "98765432", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_Name_Name_1000 () throws InvalidInputException
	{
		service.createAccount ("Name", "Name", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_98765432_Name_1000 () throws InvalidInputException
	{
		service.createAccount ("98765432", "Name", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_Name_98765432_Minus5 () throws InvalidInputException
	{
		service.createAccount ("Name", "98765432", -5);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_null_98765432_1000 () throws InvalidInputException
	{
		service.createAccount (null, "98765432", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_Name_null_1000 () throws InvalidInputException
	{
		service.createAccount ("Name", null, 1000);
	}
	
	// ------------------------------ getBalance () ------------------------------
	
	@Test
	public void getBalance_98765432 () throws AccountNotFoundException, InvalidInputException
	{
		Customer customer = new Customer ("Name", "98765432", 1000);
		service.createAccount ("Name", "98765432", 1000);
		assertEquals (customer, service.getBalance ("98765432"));
	}
	

	@Test (expected = AccountNotFoundException.class)
	public void getBalance_Name () throws AccountNotFoundException, InvalidInputException
	{
		service.getBalance ("Name");
	}
	

	@Test (expected = InvalidInputException.class)
	public void getBalance_Null () throws AccountNotFoundException, InvalidInputException
	{
		service.getBalance (null);
	}

	// ------------------------------ makeDeposit () ------------------------------
	
	
	
	// ------------------------------ transferFunds () ------------------------------
	

	
	// ------------------------------ getTransactions () ------------------------------
}
