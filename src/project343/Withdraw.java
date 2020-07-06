package project343;

import java.util.Scanner;

public class Withdraw extends Operations
{
	void withdraw(Account acc)
	{
		Scanner input = new Scanner(System.in);
		int amountToWithdraw;
		
		System.out.print("Enter the amount of money you want to withdraw: $");
		amountToWithdraw = input.nextInt();
		if(verifyBalance(acc, amountToWithdraw))
		{
			acc.updateBalance(-amountToWithdraw);
			System.out.println("\n$" + amountToWithdraw + " withdraws from account number " + acc.getAccountNum());
		}
		else
		{
			System.out.println("Not enough funds in the account!");
		}	
	}
	
	void Receipt(Account acc) 
	{
		super.Receipt(acc);
		System.out.println("Transaction Withdraw From: " + acc.getAccountName());
	}
}