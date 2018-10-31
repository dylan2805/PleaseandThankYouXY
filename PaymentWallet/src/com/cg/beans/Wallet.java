package com.cg.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Wallet
{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private double balance;
	
	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = "wallet_id")
	private List <Transaction> transactions;

	public Wallet ()
	{
		super ();
	}

	public Wallet (double balance)
	{
		this.balance = balance;
		this.transactions = new ArrayList <Transaction> ();
	}

	public int getId ()
	{
		return this.id;
	}
	
	public double getBalance ()
	{
		return balance;
	}

	public List <Transaction> getTransactions ()
	{
		return transactions;
	}

	public void setBalance (double balance)
	{
		this.balance = balance;
	}
	
	public void setTransactions (List <Transaction> transactions)
	{
		this.transactions = transactions;
	}
}
