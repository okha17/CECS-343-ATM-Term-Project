package project343;

import java.util.Scanner;

public class TransferFunds extends Operations
{
	void transfer(Account acc1, Account acc2)
	{
		Scanner input = new Scanner(System.in);
		int amountToTransfer;
		
		System.out.print("Enter the amount of money you want to transfer: $");
		amountToTransfer = input.nextInt();
		
		
		if(verifyBalance(acc1, amountToTransfer))
		{
			acc2.updateBalance(amountToTransfer); //Adds the balance from account1 to account2 balance
			acc1.updateBalance(-amountToTransfer); //Subtracts the balance from account1 
		}
		else
		{
			System.out.println("Invalid balance. Not enough funds!");
		}
		
	}

	void Receipt(Account acc) 
	{
		super.Receipt(acc);
		System.out.println("Transaction Transfer From: " + acc.getAccountName());
	}
}
