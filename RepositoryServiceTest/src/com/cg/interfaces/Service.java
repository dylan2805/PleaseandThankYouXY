package com.cg.interfaces;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidInputException;

// Rename ServiceRepository to ServiceWallet
public interface Service {
	
	 public Customer createAccount(String name, String mobile, double balance) 
			 throws InvalidInputException; 
	 public Customer getBalance(String mobile) 
			 throws AccountNotFoundException, InvalidInputException;
	 public Customer FundTransfer
	 (String fromMobile, String toMobile, double amount)
             throws AccountNotFoundException;
	 
	 public Customer deposit (String mobile, double amount)
	 throws AccountNotFoundException;

}
