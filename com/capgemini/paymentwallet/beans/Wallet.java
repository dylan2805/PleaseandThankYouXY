package com.capgemini.paymentwallet.beans;

import java.util.ArrayList;

/**
 * @author arulnr
 *
 */
public class Wallet {
	private double balance;
	private ArrayList<Transaction> transactions;
	
	public Wallet(double balance){
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
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public ArrayList<Transaction> addTransaction(Transaction transaction){
		transactions.add(transaction);
		return transactions;
	}
	
}
