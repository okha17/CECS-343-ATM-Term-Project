package project343;

import java.util.Scanner;

public class Deposit extends Operations
{
	void deposit(Account acc)
	{
		Scanner input = new Scanner(System.in);
		int amountToDeposit;
		
		System.out.print("Enter the amount of money you want to deposit: $");
		amountToDeposit = input.nextInt();
		acc.updateBalance(amountToDeposit);
		System.out.println("\n$" + amountToDeposit + " deposited into account number " + acc.getAccountNum());
	}
	
	void Receipt(Account acc) 
	{
		super.Receipt(acc);
		System.out.println("Transaction Deposit From: " + acc.getAccountName());
	}
}
