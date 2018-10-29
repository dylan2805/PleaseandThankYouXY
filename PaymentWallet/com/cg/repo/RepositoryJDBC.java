package com.cg.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.beans.Customer;
import com.cg.beans.Transaction;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InvalidInputException;
import com.cg.utils.Database;

public class RepositoryJDBC implements RepositoryInterface
{
	public Customer save (Customer customer) throws InvalidInputException
	{
		validCustomer (customer);
		
		try
		{
			ResultSet resultSet = Database.query ("SELECT * FROM customer WHERE mobile = " + customer.getMobile ());
			if (resultSet.next ()) throw new InvalidInputException ("Customer already exists");
			
			ResultSet keys = Database.insertGetKey ("INSERT INTO wallet (balance) VALUES (" +
													 customer.getWallet ().getBalance () + ")");
			
			if (!keys.next ()) throw new SQLException ();
			int walletID = keys.getInt (1);
			
			Database.update ("INSERT INTO customer (mobile, name, wallet_id) VALUES (" + customer.getMobile () +
							 ", '" + customer.getName () + "', " + walletID + ")");
			
			List <Transaction> transactions = customer.getWallet ().getTransactions ();
			
			for (Transaction transaction : transactions)
			{
				Database.updateDate ("INSERT INTO transaction (id, participant, amount, description, balance, date, wallet_id) VALUES (" +
									 transaction.getTransactionId () + ", " + transaction.getParticipant () + ", " +
									 transaction.getAmount () + ", " + transaction.getDescription () + ", " +
									 transaction.getBalance () + ", '?', " + walletID + ")", transaction.getDate ());
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace ();
			
			Database.deleteUnreferencedWallets ();
			Database.deleteCustomersWithoutWallet ();
			Database.deleteTransactiosnWithoutWallet ();
			
			throw new InvalidInputException ("Invalid customer");
		}
		
		return customer;
	}

	public Customer findByMobile (String mobile) throws AccountNotFoundException, InvalidInputException
	{
		if (mobile == null) throw new InvalidInputException ("Mobile cannot be null");
		
		try
		{
			ResultSet resultSet = Database.query ("SELECT name, wallet_id FROM customer WHERE mobile = " + mobile);
			if (!resultSet.next ()) throw new SQLException ("customer");
			
			String name = resultSet.getString (1);
			int walletID = resultSet.getInt (2);
			
			resultSet = Database.query ("SELECT balance FROM wallet WHERE id = " + walletID);
			if (!resultSet.next ()) throw new SQLException ("wallet");
			
			double balance = resultSet.getDouble (1);
			
			Customer customer = new Customer (name, mobile, balance);
			
			resultSet = Database.query ("SELECT * FROM transaction WHERE wallet_id = " + walletID);
			
			List <Transaction> transactions = new ArrayList <Transaction> ();
			while (resultSet.next ())
			{
				Transaction transaction = new Transaction (resultSet.getInt (1), resultSet.getString (2), resultSet.getDouble (3),
														   resultSet.getString (4), resultSet.getDouble (5), resultSet.getDate (6));	
				transactions.add (transaction);
			}
			
			customer.getWallet ().setTransactions (transactions);
			
			return customer;
		}
		catch (SQLException e)
		{
			switch (e.getMessage ())
			{
				case "customer":
					throw new AccountNotFoundException ("Customer with mobile " + mobile + " not found");
					
				case "wallet":
					throw new InvalidInputException ("Wallet id is invalid");
					
				default:
					throw new InvalidInputException ("Invalid input");
			}
		}
	}
	
	public Customer update (Customer customer) throws AccountNotFoundException, InvalidInputException
	{
		validCustomer (customer);
		
		try
		{
			ResultSet resultSet = Database.query ("SELECT wallet_id FROM customer WHERE mobile = " + customer.getMobile ());
			if (!resultSet.next ()) throw new AccountNotFoundException ("Account with mobile " + customer.getMobile () + " not found");
				
			int walletID = resultSet.getInt (1);
			Database.update ("UPDATE wallet SET balance = " + customer.getWallet ().getBalance () + " WHERE id = " + walletID);
			
			List <Transaction> transactions = customer.getWallet ().getTransactions ();
			for (Transaction transaction : transactions)
			{
				resultSet = Database.query ("SELECT * FROM transaction WHERE id = " + transaction.getTransactionId ());
				if (!resultSet.next ())
				{
					Database.updateDate ("INSERT INTO transaction (id, participant, amount, description, balance, date, wallet_id) VALUES(" +
										 transaction.getTransactionId () + ", " + transaction.getParticipant () + ", " +
										 transaction.getAmount () + ", '" + transaction.getDescription () + "', " +
										 transaction.getBalance () + ", ?, " + walletID + ")", transaction.getDate ());
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace ();
			throw new InvalidInputException ("Invalid input");
		}
		
		return customer;
	}
	
	private void validCustomer (Customer customer) throws InvalidInputException
	{
		if (customer == null) throw new InvalidInputException ("Invalid Customer");
		
		if (customer.getName () == null) throw new InvalidInputException ("Name cannot be null");
		if (!customer.getName ().matches ("[a-zA-Z ]+")) throw new InvalidInputException ("Name should only contain alphabets");	
		
		if (customer.getMobile () == null) throw new InvalidInputException ("Mobile cannot be null");	
		if (!customer.getMobile ().matches ("[0-9]+")) throw new InvalidInputException ("Mobile should only contain numbers");
		if (customer.getMobile ().length () != 8) throw new InvalidInputException ("Invalid mobile number");
		
		if (customer.getWallet ().getBalance () < 0) throw new InvalidInputException ("Balance cannot be negative");
	}
}
