package com.capgemini.paymentwallet.repository;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.exceptions.AccountNotFoundException;
import com.capgemini.paymentwallet.exceptions.CustomerExistException;
import com.capgemini.paymentwallet.exceptions.InvalidInputException;

/**
 * @author arulnr
 *
 */
public class RepositoryImpl implements Repository{
	private Map<String, Customer> customerAccounts;
	
//	public RepositoryImpl() {
//		// TODO Auto-generated constructor stub
//		customerAccounts = new HashMap<String, Customer>();//hardwiring
//	}
	
	public RepositoryImpl(Map<String, Customer> customerAccounts){//allows to use different type of Maps (dependency injection)
		this.customerAccounts = customerAccounts;
	}
	
	@Override
	public Customer save(Customer customer) throws InvalidInputException, CustomerExistException{
		if(customer == null){
			throw new InvalidInputException("Invalid Customer");
		}
		if(customer.getName() == null){
			throw new InvalidInputException("Name not Valid");
		}
		if(customer.getName().equals("")){
			throw new InvalidInputException("Name not entered");
		}
		if(customer.getMobile() == null){
			throw new InvalidInputException("Invalid Mobile");
		}
		if(customer.getMobile().length() != 8){
			throw new InvalidInputException("Invalid Mobile");
		}
		char[] c = customer.getMobile().toCharArray();
		for(int i = 0; i < c.length; i++){
			if(!Character.isDigit(c[i])){
				throw new InvalidInputException("Invalid Mobile");
			}
		}
		if(customer.getWallet().getBalance() < 0.0){
			throw new InvalidInputException("Invalid Mobile");
		}
		
		for(Customer a : customerAccounts.values()){
			if(customer.getMobile() == a.getMobile()){
				throw new CustomerExistException("Customer already exist");
			}
		}
		customerAccounts.put(customer.getMobile(), customer);
		return customer;
	}

	@Override
	public Customer findByMobile(String mobile) throws AccountNotFoundException, InvalidInputException {
		if(mobile == null){
			throw new InvalidInputException("Invalid Mobile");
		}
		if(mobile.length() != 8){
			throw new InvalidInputException("Invalid Mobile");
		}
		char[] c = mobile.toCharArray();
		for(int i = 0; i < c.length; i++){
			if(!Character.isDigit(c[i])){
				throw new InvalidInputException("Invalid Mobile");
			}
		}
		
		Customer cust = customerAccounts.get(mobile);
		if(cust == null){
			throw new AccountNotFoundException("Customer does not exist");
		}
		return cust;
	}
	
}
