package com.capgemini.paymentwallet.testing;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Wallet;
import com.capgemini.paymentwallet.exceptions.AccountNotFoundException;
import com.capgemini.paymentwallet.exceptions.CustomerExistException;
import com.capgemini.paymentwallet.exceptions.InvalidInputException;
import com.capgemini.paymentwallet.repository.Repository;
import com.capgemini.paymentwallet.repository.RepositoryImpl;
import com.capgemini.paymentwallet.service.Service;
import com.capgemini.paymentwallet.service.ServiceImpl;

/**
 * @author arulnr
 *
 */
public class ServiceTesting {
	Service ser;
	
	@Before
	public void init(){
		Map<String, Customer> accounts = new TreeMap<String, Customer>();
		Repository repo = new RepositoryImpl(accounts);
		ser = new ServiceImpl(repo);
	}
	@Test
	public void createAccountPositive() throws InvalidInputException, CustomerExistException, AccountNotFoundException {
		Wallet wal = new Wallet(15.0);
		Customer cust = ser.createAccount("Jane", "83584235", 15.0);
		assertEquals(cust.getName(), "Jane");
		assertEquals(cust.getMobile(), "83584235");
		assertEquals(cust.getWallet().getBalance(), 15.0,0.0001);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_WrongNameNull() throws InvalidInputException, CustomerExistException, AccountNotFoundException {
		ser.createAccount(null, "83584235", 15.0);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_WrongNumberNull() throws InvalidInputException, CustomerExistException, AccountNotFoundException {
		ser.createAccount("Jane", null, 15.0);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_WrongNegativeBalance() throws InvalidInputException, CustomerExistException, AccountNotFoundException {
		ser.createAccount("Jane", "83584235", -15.0);
	}
	
	@Test (expected = InvalidInputException.class)
	public void createAccount_WrongNullNameMobile() throws InvalidInputException, CustomerExistException, AccountNotFoundException {
		ser.createAccount(null, null, 15.0);
	}
	
	
	/********************************GetBalance********************************************************/
	
	@Test
	public void getBalance_Positive() throws AccountNotFoundException, InvalidInputException, CustomerExistException{
		Wallet wal = new Wallet(1000.0);
		Customer cust = new Customer("Rita", "96165529", wal);
		ser.createAccount("Rita", "96165529", 1000.0);
		Customer c = ser.getBalance("96165529");
		assertEquals(cust.getName(), c.getName());
		assertEquals(cust.getMobile(), c.getMobile());
		assertEquals(cust.getWallet().getBalance(), c.getWallet().getBalance(), 0.0001);
	}
	
	@Test (expected = AccountNotFoundException.class)
	public void getBalance_WrongAccountNotFound() throws AccountNotFoundException, InvalidInputException{
		ser.getBalance("96165529");
	}
	
	@Test (expected = InvalidInputException.class)
	public void getBalance_WrongMobileNull() throws AccountNotFoundException, InvalidInputException{
		ser.getBalance(null);
	}
	
	@Test (expected = InvalidInputException.class)
	public void getBalance_WrongMobileLength() throws AccountNotFoundException, InvalidInputException{
		ser.getBalance("9765473447");
	}
	
	@Test (expected = InvalidInputException.class)
	public void getBalance_WrongMobile_CharFound() throws AccountNotFoundException, InvalidInputException{
		ser.getBalance("97655t34");
	}
	

}
