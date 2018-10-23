package com.cg.service;
import java.util.ArrayList;

import com.cg.beans.Customer;
import com.cg.beans.Transaction;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.repo.Repository;

public class Service
{
	private Repository repository;
	
	public Service ()
	{
		repository = new Repository ();
	}
	
	public Customer createAccount (String name, String mobile, double balance) throws InvalidInputException
	{
		Customer customer = new Customer (name, mobile, balance);
		repository.save (customer);
		return customer;
	}
	
	public Customer getBalance (String mobile) throws AccountNotFoundException, InvalidInputException
	{
		return repository.findByMobile (mobile);
	}
	
	public Customer makeDeposit (String mobile, double amount)
	{
		return null;
	}
	
	public Customer transferFunds (String from, String to, double amount)
	{
		return null;
	}
	
	public ArrayList <Transaction> getTransactions (String mobile)
	{
		return new ArrayList <Transaction> ();
	}
}
