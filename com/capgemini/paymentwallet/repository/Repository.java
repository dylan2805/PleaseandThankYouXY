package com.capgemini.paymentwallet.repository;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.exceptions.AccountNotFoundException;
import com.capgemini.paymentwallet.exceptions.CustomerExistException;
import com.capgemini.paymentwallet.exceptions.InvalidInputException;

/**
 * @author arulnr
 *
 */
public interface Repository {
	
	public Customer save(Customer customer) throws InvalidInputException, CustomerExistException;
	
	public Customer findByMobile(String mobile) throws AccountNotFoundException, InvalidInputException;
}
