package com.cg.testrepository;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.cg.beans.Customer;
import com.cg.beans.Wallet;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.repository.RepositoryImpl;
import com.cg.service.ServiceImpl;

public class TestRepository {
	
	RepositoryImpl r;
	ServiceImpl s;
	Customer c; 
	Wallet w;
	@Before
	public void init() {
		r = new RepositoryImpl();
		s = new ServiceImpl();
		
	}
	
	@Test 
	public void FindByMobilecorrectValues() throws AccountNotFoundException, InvalidInputException {
		Customer c = r.findbymobile("12345678");
		assertTrue(c.getMobile().equals("12345678"));	
	}
	
	// account cannot be found based on number
	@Test (expected = AccountNotFoundException.class)
	public void FindByMobilenoAccount() 
			throws AccountNotFoundException 
	{
		Customer c = r.findbymobile("12");
//		assertTrue(c.getMobile().equals("12345678"));	
	}
	
	// incorrect input letters
	@Test (expected = AccountNotFoundException.class)
	public void FindByMobilenoincorrectInput() 
			throws AccountNotFoundException
	{
		Customer c = r.findbymobile("wew");
		assertTrue(c.getMobile().equals("12345678"));	
	}
	
		// incorrect input alphanumeric
		@Test (expected = AccountNotFoundException.class)
		public void FindByMobilenoincorrectInputalpha() 
				throws AccountNotFoundException
		{
			Customer c = r.findbymobile("12sde");
			assertTrue(c.getMobile().equals("12345678"));	
		}
	
		// incorrect input null values
		@Test (expected = AccountNotFoundException.class)
		public void FindByMobilenoincorrectInputnull() 
				throws AccountNotFoundException
		{
			Customer c = r.findbymobile(null);
			assertTrue(c.getMobile().equals("12345678"));	
		}
		
		// incorrect input empty Strings
		@Test (expected = AccountNotFoundException.class)
		public void FindByMobilenoincorrectemptystr() 
				throws AccountNotFoundException
		{
			Customer c = r.findbymobile("");
			assertTrue(c.getMobile().equals("12345678"));	
		}
		
		
	


}
