package com.capgemini.paymentwallet.beans;

/**
 * @author arulnr
 *
 */
public class Customer {
	private String name;
	private String mobile;
	private Wallet wallet;
	
	public Customer(String name,String mobile,Wallet wallet){
		this.name = name;
		this.mobile = mobile;
		this.wallet = wallet;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobile=" + mobile + ", wallet="
				+ wallet + "]";
	}
	
	

}
