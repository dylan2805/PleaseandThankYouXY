package com.capgemini.paymentwallet.beans;

import java.time.LocalDate;

/**
 * @author arulnr
 *
 */
public class Transaction {
	private int id;
	private LocalDate date;
	private String description;
	private double amount;
	private double balance;
	
	public Transaction(){
		
	}
	
	public Transaction(int id,LocalDate date,String description,double amount,double balance){
		this.id = id;
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
	}
	
	public int getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + date + ", description="
				+ description + ", amount=" + amount + ", balance=" + balance
				+ "]";
	}
	
	
}
