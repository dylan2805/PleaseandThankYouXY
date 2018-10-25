package com.cg.beans;

public class Customer {

	private String name; 
	private String mobile;
	private Wallet wallet;
	
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Customer() {
		
	}
	
	public Customer(String name, String mobile, double amount) {
		super();
		this.name = name;
		this.mobile = mobile;
		// creates a new Wallet object when amount entered 
		this.wallet = new Wallet(amount);
	
	}

	public Wallet getWallet() {
		return wallet;
	}
	
	public Wallet setWallet(Wallet w) {
		return this.wallet = w;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + "]";
	}

	public String getMobile() {
		return mobile;
	}	
}
