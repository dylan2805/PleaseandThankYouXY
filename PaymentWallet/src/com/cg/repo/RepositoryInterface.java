package com.cg.repo;

import com.cg.beans.Customer;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;

public interface RepositoryInterface
{
	public Customer save (Customer customer) throws InvalidInputException;
	public Customer update (Customer customer) throws AccountNotFoundException, InvalidInputException;
	public Customer findByMobile (String mobile) throws AccountNotFoundException, InvalidInputException;
}
