package com.capgemini.paymentwallet.service;

import java.util.ArrayList;

import com.capgemini.paymentwallet.beans.Customer;
import com.capgemini.paymentwallet.beans.Transaction;
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
public class ServiceImpl implements Service{
	private Repository repos;
	//	private Transaction trans;
//	public ServiceImpl() {
//		repos = new RepositoryImpl();//always goes to the collection
//	}
	
	public ServiceImpl(Repository repos){//programming to super type
		this.repos = repos;
	}

	@Override
	public Customer createAccount(String name, String mobile, double balance) throws InvalidInputException, CustomerExistException, AccountNotFoundException {
		if(name == null){
			throw new InvalidInputException("Name not Valid");
		}
		if(name.equals("")){
			throw new InvalidInputException("Name not entered");
		}
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
		if(balance < 0.0){
			throw new InvalidInputException("Invalid Mobile");
		}
		Wallet wallet = new Wallet(balance);
		Customer customer = new Customer(name, mobile, wallet);
		return repos.save(customer);
	}

	@Override
	public Customer getBalance(String mobile) throws AccountNotFoundException, InvalidInputException {
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
		Customer customer = repos.findByMobile(mobile);
		if(customer == null){
			throw new AccountNotFoundException("Customer does not exist");
		}
		return customer;
	}

	@Override
	public Customer makeDeposit(String mobile, double balance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer transferFunds(String name, String mobile, double balance) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Transaction> getTransactions(String mobile) {
		return null;
	}

}
