package project343;

public class CheckBalance extends Operations
{
	void ReturnBalance(Account acc)
	{
		System.out.println("\nAccount: " + acc.getAccountName());
		System.out.println("Current balance in the account: $" + acc.getBalance());
	}
	
	void Receipt(Account acc) 
	{
		super.Receipt(acc);
		System.out.println("Transaction Check Balance From: " + acc.getAccountName());
	}
}

