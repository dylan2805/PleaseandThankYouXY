package com.capgemini.JavaLabQuestions;

import java.util.Scanner;

public class CurrentAccount {
	private final double overdraftlimit = 2000;

	public double getOverdraftlimit() {
		return overdraftlimit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		CurrentAccount ca = new CurrentAccount();
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the withdrawal amount: ");
//		double withdrawamount = sc.nextDouble();
//		if(ca.withdraw(withdrawamount, ca.getOverdraftlimit())) {
//			System.out.println("You are allowed to withdraw amount");
//		} else 
//		{
//			System.out.println("You are not allowed to withdraw");
//		}
	}
	
	protected boolean withdraw(double withdraw, double overdraftlimit) {
		CurrentAccount ca = new CurrentAccount();
		overdraftlimit = ca.getOverdraftlimit();
		if(withdraw < overdraftlimit) {
			return true;
		} else {
			return false;
		}
	}

}
