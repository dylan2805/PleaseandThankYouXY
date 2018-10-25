package com.cg.multithreading;

import com.cg.beans.Customer;
import com.cg.beans.Wallet;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.interfaces.Service;
import com.cg.service.ServiceImpl;

public class ThreadingProblem implements Runnable {

	private Service s;
	 public ThreadingProblem() {
	// TODO Auto-generated constructor stub
		s = new ServiceImpl();
		try {
			Customer c1 = s.createAccount("testname", "12345678", 500.00);
			Customer c2 = s.createAccount("testname2", "23456789", 700.00);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		Customer c = s.FundTransfer("12345678", "23456789", 20.00);
		Wallet w = c.getWallet();
			System.out.println(w.getBalance());
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
