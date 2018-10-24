package com.capgemini.paymentwallet.testing;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Wallet;
import com.capgemini.paymentwallet.exceptions.AccountNotFoundException;
import com.capgemini.paymentwallet.exceptions.CustomerExistException;
import com.capgemini.paymentwallet.exceptions.InvalidInputException;
import com.capgemini.paymentwallet.repository.Repository;
import com.capgemini.paymentwallet.repository.RepositoryImpl;

/**
 * @author arulnr
 *
 */
public class RepositoryTesting {
	Repository repIml;

	@Before
	public void init(){
		Map<String, Customer> accounts = new HashMap<String, Customer>();
		repIml = new RepositoryImpl(accounts);
	}
	
	@Test
	public void SaveAllDataPositive() throws InvalidInputException, CustomerExistException {
		Wallet wall = new Wallet(13.0);
		Customer cust = new Customer("Jane", "98576124", wall);
		assertEquals(cust, repIml.save(cust));
	}
	
	@Test (expected = InvalidInputException.class)
	public void Save_WrongEmptyName() throws InvalidInputException, CustomerExistException {
		Wallet wall = new Wallet(15.0);
		Customer cust = new Customer("", "98576124", wall);
		repIml.save(cust);
	}
	
	@Test (expected = InvalidInputException.class)
	public void Save_WrongMobileGotChar() throws InvalidInputException, CustomerExistException {
		Wallet wall = new Wallet(130.0);
		Customer cust = new Customer("Tom", "9857e124", wall);
		repIml.save(cust);
	}
	
	@Test (expected = InvalidInputException.class)
	public void Save_WrongNegativeBalance() throws InvalidInputException, CustomerExistException {
		Wallet wall = new Wallet(-100.0);
		Customer cust = new Customer("Jessy", "98576124", wall);
		repIml.save(cust);
	}
	
	@Test (expected = InvalidInputException.class)
	public void Save_WrongNameNull() throws InvalidInputException, CustomerExistException {
		Wallet wall = new Wallet(1000.0);
		Customer cust = new Customer(null, "98576124", wall);
		repIml.save(cust);
	}
	
	@Test (expected = InvalidInputException.class)
	public void Save_WrongMobileNumbernull() throws InvalidInputException, CustomerExistException {
		Wallet wall = new Wallet(200.0);
		Customer cust = new Customer("Reem", null, wall);
		repIml.save(cust);
	}
	
	@Test (expected = InvalidInputException.class)
	public void SaveWrongNullCustomer() throws InvalidInputException, CustomerExistException {
		repIml.save(null);
	}
	
	@Test (expected = CustomerExistException.class)
	public void SaveWrong_CustomerExist() throws InvalidInputException, CustomerExistException {
		Wallet wall = new Wallet(200.0);
		Customer cust = new Customer("Reem", "98364373", wall);
		repIml.save(cust);
		Customer cust1 = new Customer("Reem", "98364373", wall);
		repIml.save(cust1);
	}
	
	/**********************************findByMobile******************************************************/
	
	@Test
	public void findByMobilePositive() throws InvalidInputException, AccountNotFoundException, CustomerExistException{
		Wallet wall = new Wallet(13.0);
		Customer cust = new Customer("Jane", "98576124", wall);
		repIml.save(cust);
		assertEquals(cust, repIml.findByMobile("98576124"));
	}
	
	
	@Test (expected = InvalidInputException.class)
	public void findByMobile_nullMobileNumber() throws InvalidInputException, AccountNotFoundException{
		repIml.findByMobile(null);
	}
	
	@Test (expected = InvalidInputException.class)
	public void findByMobile_WrongMobileLength() throws InvalidInputException, AccountNotFoundException{
		repIml.findByMobile("95375865959");
	}
	
	@Test (expected = InvalidInputException.class)
	public void findByMobile_WrongMobileGotChar() throws InvalidInputException, AccountNotFoundException{
		repIml.findByMobile("9539d24f");
	}
	
	@Test (expected = AccountNotFoundException.class)
	public void findByMobile_WrongAccountnotthere() throws InvalidInputException, AccountNotFoundException{
		repIml.findByMobile("98576123");
	}

}
