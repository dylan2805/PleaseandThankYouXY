package com.cg.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Database
{	
	// Standard query
	public static ResultSet query (String query) throws SQLException
	{
		Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
		PreparedStatement statement = connection.prepareStatement (query);
		
		return statement.executeQuery ();
	}
	
	// Get auto generated key
	public static ResultSet insertGetKey (String query) throws SQLException
	{
		Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
		PreparedStatement statement = connection.prepareStatement (query, Statement.RETURN_GENERATED_KEYS);
		
		statement.executeUpdate ();
		
		return statement.getGeneratedKeys ();
	}
	
	// Standard update
	public static int update (String query) throws SQLException
	{
		Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
		PreparedStatement statement = connection.prepareStatement (query);
		
		return statement.executeUpdate ();
	}
	
	// Update with date object
	public static int updateDate (String query, Date date) throws SQLException
	{
		Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
		PreparedStatement statement = connection.prepareStatement (query);
		statement.setDate (1, new java.sql.Date (date.getTime ()));
		
		return statement.executeUpdate ();
	}
	
	// Remove customers without valid wallet
	public static void deleteCustomersWithoutWallet ()
	{
		try
		{
			Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
			PreparedStatement statement = connection.prepareStatement ("DELETE FROM customer WHERE wallet_id NOT IN (SELECT id FROM wallet)");
			statement.executeUpdate ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	// Remove wallets without customers
	public static void deleteUnreferencedWallets ()
	{
		try
		{
			Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
			PreparedStatement statement = connection.prepareStatement ("DELETE FROM wallet WHERE id NOT IN " +
																	   "(SELECT wallet_id FROM customer WHERE wallet_id IS NOT NULL)");
			statement.executeUpdate ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	// Remove transactions without valid wallet
	public static void deleteTransactiosnWithoutWallet ()
	{
		try
		{
			Connection connection = DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
			PreparedStatement statement = connection.prepareStatement ("DELETE FROM transaction WHERE wallet_id NOT IN (SELECT id FROM wallet)");
			statement.executeUpdate ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
