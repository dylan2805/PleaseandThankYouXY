package com.cg.beans;

import java.util.ArrayList;

public class Wallet {
	
	private double balance;
	private ArrayList<Transaction> transactions;
	
	public Wallet(double balance, ArrayList<Transaction> transactions) {
		super();
		this.balance = balance;
		this.transactions = transactions;
	}
	
	public Wallet(double balance) {
		super();
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
}
