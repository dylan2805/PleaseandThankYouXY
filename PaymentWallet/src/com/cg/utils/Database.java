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
		PreparedStatement statement = getConnection ().prepareStatement (query);
		return statement.executeQuery ();
	}
	
	// Get auto generated key
	public static ResultSet insertGetKey (String query) throws SQLException
	{
		PreparedStatement statement = getConnection ().prepareStatement (query, Statement.RETURN_GENERATED_KEYS);
		statement.executeUpdate ();
		
		return statement.getGeneratedKeys ();
	}
	
	// Standard update
	public static int update (String query) throws SQLException
	{
		PreparedStatement statement = getConnection ().prepareStatement (query);
		return statement.executeUpdate ();
	}
	
	// Update with date object
	public static int updateDate (String query, Date date) throws SQLException
	{
		PreparedStatement statement = getConnection ().prepareStatement (query);
		statement.setDate (1, new java.sql.Date (date.getTime ()));
		
		return statement.executeUpdate ();
	}
	
	// Remove customers without valid wallet
	public static void deleteCustomersWithoutWallet ()
	{
		try
		{
			PreparedStatement statement = getConnection ().prepareStatement ("DELETE FROM customer WHERE wallet_id NOT IN (SELECT id FROM wallet)");
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
			PreparedStatement statement = getConnection ().prepareStatement ("DELETE FROM wallet WHERE id NOT IN (SELECT wallet_id FROM customer WHERE wallet_id IS NOT NULL)");
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
			PreparedStatement statement = getConnection ().prepareStatement ("DELETE FROM transaction WHERE wallet_id NOT IN (SELECT id FROM wallet)");
			statement.executeUpdate ();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	private static Connection getConnection () throws SQLException
	{
		try
		{
			Class.forName ("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return DriverManager.getConnection ("jdbc:mysql://localhost:3306/paymentwallet", "root", "password");
	}
}
