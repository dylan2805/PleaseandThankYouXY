package com.cg.interfaces;


import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;

public interface Repository {
	// save customer to repository 
	// InvalidInputException
	public Customer save (Customer c) throws InvalidInputException;
	// findbymobile method to find the cus object by mobile number
	public Customer findbymobile(String mobile) throws AccountNotFoundException;

}
