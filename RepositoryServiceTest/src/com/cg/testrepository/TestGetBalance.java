package com.cg.testrepository;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.beans.Wallet;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidInputException;
import com.cg.service.ServiceImpl;

public class TestGetBalance {

	private ServiceImpl s;

	@Before
	public void init() {
		s= new ServiceImpl();
		try {
			Customer c = s.createAccount("testname", "12345678", 500.00);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Test 
	public void getbalancecorrectreturn() throws AccountNotFoundException, InsufficientBalanceException {
		// method to create account

		Customer c;
		try {
			c = s.getBalance("12345678");
			Wallet w = c.getWallet();
			double balance = w.getBalance();
			assertTrue(500.00 == balance);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

/*	// null values entered 
	@Test (expected = AccountNotFoundException.class)
	public void getbalanceaccountnotfound() throws AccountNotFoundException, InsufficientBalanceException {
		// method to create account
		c = s.getBalance(null);
		w = c.getWallet();
		double balance = w.getBalance();
	}
*/




}
