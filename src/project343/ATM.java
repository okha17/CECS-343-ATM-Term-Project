package project343;

import java.util.ArrayList;

public class ATM {

	private static ArrayList<Checking> checkingAccountList;
	private static ArrayList<Savings> savingsAccountList;
	private static Checking currentCheckingAcct;
	private static Savings currentSavingsAcct;
	private static String currentPIN;
	private static Menu menu = new Menu();
	
	
	ATM(){
		checkingAccountList = new ArrayList<Checking>();
		savingsAccountList = new ArrayList<Savings>();
		currentCheckingAcct = null;
		currentSavingsAcct = null;
		
	}
	
	void runATM() {
		
		///**creating testing accounts---------------------------------------------------------
		checkingAccountList.add(new Checking("1111", "Doe", "John", "12345678", "Checking"));
		savingsAccountList.add(new Savings("1111", "Doe", "John", "12345678", "Savings"));
		checkingAccountList.get(0).updateBalance(1200);
		savingsAccountList.get(0).updateBalance(2400);
		
		checkingAccountList.add(new Checking("2222", "Vera", "Alexis", "11112222", "Checking"));
		savingsAccountList.add(new Savings("2222", "Vera", "Alexis", "11112222", "Savings"));
		checkingAccountList.get(1).updateBalance(3500);
		savingsAccountList.get(1).updateBalance(1600);
		
		checkingAccountList.add(new Checking("3333", "Shunner", "Ken", "87654321", "Checking"));
		savingsAccountList.add(new Savings("3333", "Shunner", "Ken", "87654321", "Savings"));
		checkingAccountList.get(2).updateBalance(600);
		savingsAccountList.get(2).updateBalance(1500);
		//*/
		
		menu.displayWelcome();
		
		//LOOKING FOR ACCOUNT------------------------------------------------
		while(!findAccount()) {
			menu.accountNotFound();
		}
		
		while(!verifyPIN()) {
			menu.invalidPIN();
		}
		
		//STARTING OPERATIONS------------------------------------------------
		int choice = 0;
		
		while(choice != 5) {
			
			//Getting operation choice from user-------
			choice = menu.chooseOperation();
			
			int accountChoice;
			//this is used by every operationg to show balance at end---------
			CheckBalance check = new CheckBalance();
			
			switch(choice) {
			
			case 1: //Transfer Funds --------------------------------------------------------------------------------------------
				//Requesting user to choose account to tranfers from---
				accountChoice = menu.transferFromTo(currentCheckingAcct.getAccountName(), currentSavingsAcct.getAccountName());
				//Creating operation---
				TransferFunds transfer = new TransferFunds();
				
				
				if(accountChoice == 1) 
				{
					//Transfering from Checking to Savings---
					transfer.transfer(currentCheckingAcct, currentSavingsAcct);
					check.ReturnBalance(currentCheckingAcct);
					check.ReturnBalance(currentSavingsAcct);
					
					// Ask for receipt
					choice = menu.askReceipt();
					if(choice == 1)
					{
						transfer.Receipt(currentCheckingAcct);
					}			
				}
				else 
				{
					//Transfering from Savings to Checking---
					transfer.transfer(currentSavingsAcct, currentCheckingAcct);
					check.ReturnBalance(currentCheckingAcct);
					check.ReturnBalance(currentSavingsAcct);
					
					// Ask for receipt
					choice = menu.askReceipt();
					if(choice == 1)
					{
						transfer.Receipt(currentSavingsAcct);
					}
				}	
				
				System.out.println("\nRetuirning to menu...");
				
				break;
				
			case 2: //Deposit -------------------------------------------------------------------------------------------------
				//Requesting user to choose account to perform operation on---
				accountChoice = menu.chooseAccount(currentCheckingAcct.getAccountName(), currentSavingsAcct.getAccountName());
				//Creating operation---
				Deposit depo = new Deposit();
				
				if(accountChoice == 1) 
				{
					//Depositing into Checking--
					depo.deposit(currentCheckingAcct);
					check.ReturnBalance(currentCheckingAcct);
					// Ask for receipt 
					choice = menu.askReceipt();
					if(choice == 1)
					{
						depo.Receipt(currentCheckingAcct);
					}
				}
				else 
				{
					//Depositing into Savings--
					depo.deposit(currentSavingsAcct);
					check.ReturnBalance(currentSavingsAcct);
					//Ask for receipt
					choice = menu.askReceipt();
					if(choice == 1)
					{
						depo.Receipt(currentSavingsAcct);
					}
				}	
				
				System.out.println("\nRetuirning to menu...");
				
				break;
				
			case 3: //Withdraw ------------------------------------------------------------------------------------------------
				//Requesting user to choose account to perform operation on---
				accountChoice = menu.chooseAccount(currentCheckingAcct.getAccountName(), currentSavingsAcct.getAccountName());
				//Creating operation---
				Withdraw with = new Withdraw();
				
				if(accountChoice == 1) 
				{
					//Withdrawing from Checking---
					with.withdraw(currentCheckingAcct);
					check.ReturnBalance(currentCheckingAcct);
					// Ask for receipt
					choice = menu.askReceipt();
					if(choice == 1)
					{
						with.Receipt(currentCheckingAcct);
					}
				}
				else 
				{
					//Withdrawing from Savings--
					with.withdraw(currentSavingsAcct);
					check.ReturnBalance(currentSavingsAcct);
					// Ask for receipt
					choice = menu.askReceipt();
					if(choice == 1)
					{
						with.Receipt(currentSavingsAcct);
					}
				}	
				
				System.out.println("\nRetuirning to menu...");
				
				break;
				
			case 4: //CheckBalance ------------------------------------------------------------------------------------------
				//Requesting user to choose account to perform operation on---
				accountChoice = menu.chooseAccount(currentCheckingAcct.getAccountName(), currentSavingsAcct.getAccountName());
				
				if(accountChoice == 1) 
				{
					//Showing Checking balance and info--
					check.ReturnBalance(currentCheckingAcct);
					// Ask for receipt
					choice = menu.askReceipt();
					if(choice == 1)
					{
						check.Receipt(currentCheckingAcct);
					}
				}
				else 
				{
					//Showing Savings balance and info--
					check.ReturnBalance(currentSavingsAcct);
					// Ask for receipt
					choice = menu.askReceipt();
					if(choice == 1)
					{
						check.Receipt(currentSavingsAcct);
					}
				}
				
				System.out.println("\nRetuirning to menu...");
				
				break;
				
			case 5:
				//Exiting program---
				break;
			default:
				//User has entered an invalid choice---
				System.out.println("	Invalid Input!");
			
			}
				
		}
	}
	
	
	static Boolean findAccount() {
		
	  	boolean accountFound = false;
	  	
		String accountNum = menu.getAccountNumber();
		
		//Searching list of checking accounts----
		for (Account a: checkingAccountList) {
			if (a.getAccountNum().equals(accountNum)) {
				currentCheckingAcct = (Checking) a;
				accountFound = true;
				break;
			}		
		}
		
		if(!accountFound) {
			//account wasnt found with account number the user entered---
			return accountFound;
		}
		
		//Searching list of saving accounts----
		for (Account a: savingsAccountList) {
			if (a.getAccountNum().equals(accountNum)) {
				currentSavingsAcct = (Savings) a;
				break;
			}		
		}
		
		return accountFound;
	}
	  
	static Boolean verifyPIN() {
		
		currentPIN = menu.enterPIN();
		return(currentCheckingAcct.getPin().equals(currentPIN));
			
	}
	
}
