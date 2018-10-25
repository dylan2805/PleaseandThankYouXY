package com.cg.testrepository;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.exceptions.InvalidInputException;
import com.cg.service.ServiceImpl;

public class TestCreateAccount {
	
	private ServiceImpl s;
	@Before
	public void init() {
		
		s = new ServiceImpl();
		
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
	
	//enter letters as values 
	@Test (expected = InvalidInputException.class)
	public void mobile_number_should_only_contain_numbers() 
			throws InvalidInputException {
		// method to create account
		s.createAccount("name", "ee", 200.00);
	}
}
