package com.capgemini.JavaLabQuestions;

import java.util.Scanner;

public class SavingsAccount extends Accounts {

	private final double minBalance = 6000;
	private double remBalance = 0;

	public double getRemBalance() {
		return remBalance;
	}

	public void setRemBalance(double remBalance) {
		this.remBalance = remBalance;
	}

	protected void withdraw(double withdraw) {
		SavingsAccount sa = new SavingsAccount();

		boolean greateramount = true;
		Scanner sc = new Scanner(System.in);
		while (greateramount) {
			if (sa.getMinBalance() < withdraw) {
				System.out.println("Withdraw limit exceeded. Please enter new value: ");
				withdraw = Double.parseDouble(sc.next());
				greateramount = true;
			} else {
				double rembalance = sa.getMinBalance() - withdraw;
				// getters and setters must be used within same code block.
				// memory does not allow storage of the code for use between code
				// blocks
				sa.setRemBalance(rembalance);
				System.out.println("Your new balance is " + sa.getRemBalance());
				greateramount = false;
				break;
			}
		}

	}

	public double getMinBalance() {
		return minBalance;
	}

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter withdrawal amount: ");
//		double withdraw = sc.nextDouble();
//		SavingsAccount sa = new SavingsAccount();
//		sa.withdraw(withdraw);
	}

}
