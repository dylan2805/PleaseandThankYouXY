package com.cg.service;

import java.util.ArrayList;

import com.cg.beans.Customer;
import com.cg.beans.Transaction;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidInputException;

public interface ServiceInterface
{
	public Customer createAccount (String name, String mobile, double balance) throws InvalidInputException;
	public Customer getBalance (String mobile) throws AccountNotFoundException, InvalidInputException;
	public Customer makeDeposit (String mobile, double amount) throws AccountNotFoundException, InvalidInputException;
	public Customer transferFunds (String from, String to, double amount) throws AccountNotFoundException, InsufficientBalanceException, InvalidInputException;
	public ArrayList <Transaction> getTransactions (String mobile) throws AccountNotFoundException, InvalidInputException;
}