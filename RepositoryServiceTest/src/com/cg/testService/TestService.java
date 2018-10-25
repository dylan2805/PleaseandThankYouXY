package com.cg.testService;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.beans.Wallet;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidInputException;
import com.cg.service.ServiceImpl;

public class TestService {

	private ServiceImpl s;

	@Before
	public void init() {

		s = new ServiceImpl();
		try {
			Customer c1 = s.createAccount("testname", "12345678", 500.00);
			Customer c2 = s.createAccount("testname2", "23456789", 700.00);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// method naming camelcase(can use underscore)
	@Test
	public void create_account_with_valid_data() throws InvalidInputException {
		// method to create account
		// Test for all attributes entered within same method
		Customer c = s.createAccount("name1", "12345678", 200.00);
		assertTrue(c.getMobile().equals("12345678"));
		assertEquals(c.getMobile(), "12345678");

	}

	// enter letters as values
	@Test(expected = InvalidInputException.class)
	public void mobile_number_should_only_contain_numbers()
			throws InvalidInputException {
		// method to create account
		s.createAccount("name", "ee", 200.00);
	}

	@Test
	public void getbalancecorrectreturn() throws AccountNotFoundException,
			InsufficientBalanceException {
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

	@Test
	public void fund_Transfer_correct_values() throws AccountNotFoundException,
			InvalidInputException {
		// method to create account
		Customer c;
		c = s.FundTransfer("12345678", "23456789", 20.00);
		Wallet w = c.getWallet();
		assertTrue(w.getBalance() == (500.00 - 20.00));
	}

	@Test
	public void deposit_correct_values() throws AccountNotFoundException {
		// method to create account
		Customer c;
		c = s.deposit("12345678", 300.00);
		Wallet w = c.getWallet();
		assertTrue(w.getBalance() == (500.00 + 300.00));
	}

}
