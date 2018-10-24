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
/* public Customer FundTransfer
 (String fromMobile, String toMobile, double amount) 
		 throws AccountNotFoundException {
	 // get balance of customer 1 - based on mobile
	 // get balance of customer 2 - based on mobile
	 // set balance of customer 1 - deduct amount
	 // set balance of customer 2 - add amount
	 // call balance of customer 1 again.
	 // get the customer objects based on the mobile number
	 Customer fromTransfer = r.findbymobile(toMobile);
	 Customer toTransfer = r.findbymobile(fromMobile);
	 // get the wallet from the customer 
	 Wallet fromTransferWallet = fromTransfer.getWallet();
	 double fromTransferBalance = fromTransferWallet.getBalance();
	 
	 
	 
	 
 }*/
}
