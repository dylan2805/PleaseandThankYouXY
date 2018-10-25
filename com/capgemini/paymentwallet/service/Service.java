package com.capgemini.paymentwallet.service;

import java.util.ArrayList;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Transaction;
import com.capgemini.paymentwallet.exceptions.AccountNotFoundException;
import com.capgemini.paymentwallet.exceptions.CustomerExistException;
import com.capgemini.paymentwallet.exceptions.InvalidInputException;

/**
 * @author arulnr
 *
 */
public interface Service {
	
	public Customer createAccount(String name, String mobile, double balance) throws InvalidInputException, CustomerExistException, AccountNotFoundException;
	
	public Customer getBalance(String mobile) throws AccountNotFoundException, InvalidInputException;
	
	public Customer makeDeposit(String mobile, double balance);
	
	public Customer transferFunds(String name, String mobile, double balance);
	
	public ArrayList<Transaction> getTransactions(String mobile);
	
}
