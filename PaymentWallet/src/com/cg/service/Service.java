package com.cg.service;
import java.util.ArrayList;
import java.util.Date;

import com.cg.beans.Customer;
import com.cg.beans.Transaction;
import com.cg.beans.Wallet;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidInputException;
import com.cg.repo.Repository;
import com.cg.repo.RepositoryInterface;

public class Service implements ServiceInterface
{
	private RepositoryInterface repository;
	
	public Service ()
	{
		repository = new Repository ();
	}
	
	public Service (RepositoryInterface repository)
    {
		// Should use this constructor, allows for implementation of choice at runtime
		// Known as constructor injection
	    this.repository = repository;
    }

	public Customer createAccount (String name, String mobile, double balance) throws InvalidInputException
	{
		if (name == null) throw new InvalidInputException ("Name cannot be null");
		if (!name.matches ("[a-zA-Z]+")) throw new InvalidInputException ("Name should only contain alphabets");	
		
		if (mobile == null) throw new InvalidInputException ("Mobile cannot be null");	
		if (!mobile.matches ("[0-9]+")) throw new InvalidInputException ("Mobile should only contain numbers");
		if (mobile.length () != 8) throw new InvalidInputException ("Invalid mobile number");
		
		if (balance < 0) throw new InvalidInputException ("Balance cannot be negative");
		
		Customer customer = new Customer (name, mobile, balance);
		repository.save (customer);
		return customer;
	}
	
	public Customer getBalance (String mobile) throws AccountNotFoundException, InvalidInputException
	{
		if (mobile == null) throw new InvalidInputException ("Mobile cannot be null");
		return repository.findByMobile (mobile);
	}
	
	public Customer makeDeposit (String mobile, double amount) throws AccountNotFoundException, InvalidInputException
	{
		if (mobile == null) throw new InvalidInputException ("Mobile cannot be null");	
		if (!mobile.matches ("[0-9]+")) throw new InvalidInputException ("Mobile should only contain numbers");
		if (mobile.length () != 8) throw new InvalidInputException ("Invalid mobile number");

		if (amount < 0) throw new InvalidInputException ("Amount cannot be negative");

		Customer customer= repository.findByMobile (mobile);
		customer.getWallet ().setBalance (customer.getWallet ().getBalance () + amount);
		
		Date date = new Date ();
		Transaction transaction = new Transaction (((int) date.getTime () / 1000), mobile, amount, "Deposit",
													   customer.getWallet ().getBalance (), date);
		
		getTransactions (mobile).add (transaction);
		
		return customer;
	}
	
	public Customer transferFunds (String from, String to, double amount) throws AccountNotFoundException, InsufficientBalanceException,
																				 InvalidInputException
	{
		if (from == null || to == null) throw new InvalidInputException ("Mobile cannot be null");	
		if (!from.matches ("[0-9]+") || !to.matches ("[0-9]+")) throw new InvalidInputException ("Mobile should only contain numbers");
		if (from.length () != 8 || to.length () != 8) throw new InvalidInputException ("Invalid mobile number");
		
		Customer fromCustomer = repository.findByMobile (from);
		Wallet fromWallet = fromCustomer.getWallet ();
		Wallet toWallet = repository.findByMobile (to).getWallet ();
		
		if (amount < 0) throw new InvalidInputException ("Amount cannot be negative");
		if (fromWallet.getBalance () < amount) throw new InsufficientBalanceException ("Insufficient balance");
		
		fromWallet.setBalance (fromWallet.getBalance () - amount);
		toWallet.setBalance (toWallet.getBalance () + amount);
		
		Date date = new Date ();
		Transaction fromTransaction = new Transaction (((int) date.getTime () / 1000), to, amount, "Transfer",
													   fromWallet.getBalance (), date);
		Transaction toTransaction = new Transaction (((int) date.getTime () / 1000), from, amount, "Transfer",
													 toWallet.getBalance (), date);
		
		getTransactions (from).add (fromTransaction);
		getTransactions (to).add (toTransaction);
		
		return fromCustomer;
	}
	
	public ArrayList <Transaction> getTransactions (String mobile) throws AccountNotFoundException, InvalidInputException
	{
		if (mobile == null) throw new InvalidInputException ("Mobile cannot be null");	
		if (!mobile.matches ("[0-9]+")) throw new InvalidInputException ("Mobile should only contain numbers");
		if (mobile.length () != 8) throw new InvalidInputException ("Invalid mobile number");
		
		return repository.findByMobile (mobile).getWallet ().getTransactions ();
	}
}