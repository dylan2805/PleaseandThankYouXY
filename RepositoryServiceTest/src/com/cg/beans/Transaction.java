package com.cg.beans;

import java.time.LocalDateTime;

public class Transaction {
	private int id;
	private LocalDateTime date;
	private String description;
	private double amount;
	private double balance;
	
	public Transaction(int id, LocalDateTime date, String description,
			double amount, double balance) {
		super();
		this.id = id;
		this.date = date;
		this.description = description;
		this.amount = amount;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public LocalDateTime getDate() {
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
		return "Transactions [id=" + id + ", date=" + date + ", description="
				+ description + ", amount=" + amount + ", balance=" + balance
				+ "]";
	}
	
}
