package com.capgemini.JavaLabQuestions;

import java.util.Scanner;

public class TestClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please indicate account type");
		String accounttype = sc.next();
		if(accounttype.toLowerCase().equals("savingsaccount")) {
			System.out.println("Enter withdrawal amount: ");
			double withdraw = sc.nextDouble();
			SavingsAccount sa = new SavingsAccount();
			sa.withdraw(withdraw);
		} else if(accounttype.toLowerCase().equals("currentaccount")) {
			CurrentAccount ca = new CurrentAccount();
			System.out.println("Enter the withdrawal amount: ");
			double withdrawamount = sc.nextDouble();
			if(ca.withdraw(withdrawamount, ca.getOverdraftlimit())) {
				System.out.println("You are allowed to withdraw amount");
			} else 
			{
				System.out.println("You are not allowed to withdraw");
			}
		}
	}

}
