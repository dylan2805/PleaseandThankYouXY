package com.cg.service;
import com.cg.beans.Customer;
import com.cg.beans.Wallet;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.interfaces.Repository;
import com.cg.interfaces.Service;
import com.cg.repository.RepositoryImpl;

public class ServiceImpl implements Service {
	// always Make reference to the interface since its a contract,
	// methods are being called from here
	private Repository r;

	public ServiceImpl() {
		r = new RepositoryImpl();
	}

	// create account method 
	public Customer createAccount (String name, String mobile, double balance)
			throws InvalidInputException
	{	
		Customer c = new Customer(name,mobile, balance);
		if(!mobile.matches(".*\\d+.*")){
			throw new InvalidInputException("Please enter only numbers");
		}
		Customer c1 = r.save(c); 
		return c1;
	}
	// getbalance for the respective customer
	public Customer getBalance(String mobile) 
			throws AccountNotFoundException, InvalidInputException {

		if(mobile == null){
			throw new AccountNotFoundException("Account not found");
		}

		if(!mobile.matches(".*\\d+.*")){
			throw new InvalidInputException("Please enter only numbers");
		}
		return r.findbymobile(mobile);

	}
	// Fundtransfer from customer 1 to Customer 2
	// return customer object (frommobile)
	public Customer FundTransfer
	(String fromMobile, String toMobile, double amount) 
			throws AccountNotFoundException {
		// get the customer objects based on the mobile number
		Customer fromTransfer = r.findbymobile(fromMobile);
		Customer toTransfer = r.findbymobile(toMobile);
		// get the wallet from the customer who is transferring
		Wallet fromTransferWallet = fromTransfer.getWallet();
		// set the balance for the customer who is transferring amount
		fromTransferWallet.setBalance(fromTransferWallet.getBalance()-amount);
		return fromTransfer;
	}
	// add balance to the customer deposit
	public Customer deposit (String mobile, double amount) 
			throws AccountNotFoundException 
	{
		// get the customer objects based on the mobile number
		Customer customerDepositing = r.findbymobile(mobile);
		// get the wallet from the customer who is transferring
		Wallet customerDepositW = customerDepositing.getWallet();
		// set the balance for the customer who is transferring amount
		customerDepositW.setBalance(customerDepositW.getBalance()+amount);
		return customerDepositing;
	}
}
