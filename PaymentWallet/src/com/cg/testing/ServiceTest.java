package com.cg.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.persistence.Persistence;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidInputException;
import com.cg.repo.RepositoryJPA;
import com.cg.service.Service;

public class ServiceTest
{
	private static RepositoryJPA repository;
	private static Service service;
	
	@BeforeClass
	public static void init ()
	{
		repository = new RepositoryJPA (Persistence.createEntityManagerFactory ("wallet").createEntityManager ());
		service = new Service (repository);
	}
	
	public Customer create (String name, String mobile, double balance) throws AccountNotFoundException, InvalidInputException
	{
		Customer customer = null;
		
		try
		{
			customer = service.createAccount (name, mobile, balance);
		}
		catch (InvalidInputException e)
		{
			if (!e.getMessage ().equals ("Customer already exists!")) throw e;
			customer = repository.findByMobile (mobile);
			customer.getWallet ().setBalance (balance);
			repository.update (customer);
		}
		
		return customer;
	}
	
	// ------------------------------ createAccount () ------------------------------
	
	@Test
	public void createAccount_Name_98765432_1000 () throws InvalidInputException, AccountNotFoundException
	{
		Customer customer = new Customer ("Name", "98765432", 1000);
		assertEquals (customer, create ("Name", "98765432", 1000));
	}
	
	@Test
	public void createAccount_Name_98765432_0 () throws InvalidInputException, AccountNotFoundException
	{
		Customer customer = new Customer ("Name", "98765432", 0);
		assertEquals (customer, create ("Name", "98765432", 0));
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_98765432_98765432_1000 () throws InvalidInputException, AccountNotFoundException
	{
		create ("98765432", "98765432", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_Name_Name_1000 () throws InvalidInputException, AccountNotFoundException
	{
		create ("Name", "Name", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_98765432_Name_1000 () throws InvalidInputException, AccountNotFoundException
	{
		create ("98765432", "Name", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_Name_98765432_Minus5 () throws InvalidInputException, AccountNotFoundException
	{
		create ("Name", "98765432", -5);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_null_98765432_1000 () throws InvalidInputException, AccountNotFoundException
	{
		create (null, "98765432", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_Name_null_1000 () throws InvalidInputException, AccountNotFoundException
	{
		create ("Name", null, 1000);
	}
	
	// ------------------------------ getBalance () ------------------------------
	
	@Test
	public void getBalance_98765432 () throws AccountNotFoundException, InvalidInputException
	{
		Customer customer = new Customer ("Name", "98765432", 1000);
		
		try
		{
			create ("Name", "98765432", 1000);
		}
		catch (InvalidInputException e)
		{
			// do nothing
		}
		finally
		{
			assertEquals (customer, service.getBalance ("98765432"));
		}
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
	
	@Test
	public void makeDeposit_1000 () throws AccountNotFoundException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		Customer customer = service.makeDeposit ("98765432", 1000);
		assertTrue (customer.getWallet ().getBalance () == 2000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void makeDeposit_MobileNotNumber () throws AccountNotFoundException, InvalidInputException
	{
		service.makeDeposit ("Name", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void makeDeposit_MobileTooShort () throws AccountNotFoundException, InvalidInputException
	{
		service.makeDeposit ("9876543", 1000);
	}
	
	@Test (expected = InvalidInputException.class)
	public void makeDeposit_MobileTooLong () throws AccountNotFoundException, InvalidInputException
	{
		service.makeDeposit ("987654321", 1000);
	}
	
	@Test (expected = AccountNotFoundException.class)
	public void makeDeposit_NoSuchAccount () throws AccountNotFoundException, InvalidInputException
	{
		service.makeDeposit ("92345678", 1000);
	}
	
	// ------------------------------ transferFunds () ------------------------------
	
	@Test
	public void transferFunds_98765432to91234567_500 () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		Customer c1 = service.transferFunds ("98765432", "91234567", 500);
		Customer c2 = service.getBalance ("91234567");
		
		assertTrue (c1.getWallet ().getBalance () == 500);
		assertTrue (c2.getWallet ().getBalance () == 1500);
	}

	@Test (expected = AccountNotFoundException.class)
	public void transferFunds_98765432to92345678_Negative () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		service.transferFunds ("98765432", "92345678", 500);
	}
	
	@Test (expected = InvalidInputException.class)
	public void transferFunds_98765432to91234567_Negative () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		service.transferFunds ("98765432", "91234567", -5);
	}

	@Test (expected = InvalidInputException.class)
	public void transferFunds_98765432to98765432 () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		service.transferFunds ("98765432", "98765432", 500);
	}
	
	@Test (expected = InvalidInputException.class)
	public void transferFunds_98765432toName () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		service.transferFunds ("98765432", "Name", 500);
	}
	
	@Test (expected = InvalidInputException.class)
	public void transferFunds_NameTo98765432 () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		service.transferFunds ("Name", "98765432", 500);
	}
	
	@Test (expected = InvalidInputException.class)
	public void transferFunds_NullTo98765432 () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		service.transferFunds (null, "98765432", 500);
	}
	
	@Test (expected = InvalidInputException.class)
	public void transferFunds_NameToNull () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		service.transferFunds ("98765432", null, 500);
	}
	
	@Test (expected = InsufficientBalanceException.class)
	public void transferFunds_98765432to91234567_insufficientFunds () throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException
	{
		create ("Name", "98765432", 1000);
		create ("Name", "91234567", 1000);
		
		service.transferFunds ("98765432", "91234567", 1001);
	}
	
	// ------------------------------ getTransactions () ------------------------------
}
