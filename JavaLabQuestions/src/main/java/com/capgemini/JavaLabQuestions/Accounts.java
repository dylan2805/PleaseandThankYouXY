package com.capgemini.JavaLabQuestions;

public class Accounts {

	private long accNum;
	private double balance;
	private Person accHolder;

	public long getAccNum() {
		return accNum;
	}

	public void setAccNum(long accNum) {
		this.accNum = accNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Person getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

	protected void deposit(double deposit) {

	}

	protected void withdraw(double withdraw) {

	}

	protected boolean withdraw(double withdraw, double balance) {
		return true;
	}

}