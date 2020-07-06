package project343;

import java.util.Scanner;

class Menu {
	
	Scanner input = new Scanner(System.in);
	
  public void displayWelcome() {
    System.out.println("Welcome! Press Enter to begin.");
    input.nextLine();
  }
  
  public String getAccountNumber() {
	  
	  System.out.print("Enter Account Number: ");
	  String number = input.next();  
	  return number;
  }
  
  public void accountNotFound(){
	    System.out.println("	The account number does not match any records!");
  }
	  
  public String enterPIN() {
		  
	  System.out.print("Enter your pin. PIN: ");
	  String pin = input.next();
	  return pin;
  }
	  
  public void invalidPIN(){
	  System.out.println("	PIN does not match!");
  }
  
  public double getFundAmount() {
	  System.out.print("Enter an amount: ");
	  double amount = input.nextDouble();
	  return amount;
  }
  
  public int chooseOperation() {
	  
    int selection;
    
  	System.out.println("\n---Select an Option---");
    System.out.println("1. Transfer");
    System.out.println("2. Deposit");
    System.out.println("3. Withdraw");
    System.out.println("4. Check Balance");
    System.out.println("5. Exit");
    
    System.out.print("Choice: ");
    
    selection = input.nextInt();
    
    return selection;
  }
  
  public int chooseAccount(String a1, String a2) {
	  
	  System.out.println("\n--Choose an account--");
	  System.out.println("1. " + a1);
	  System.out.println("2. " + a2);
	  
	  System.out.print("Choice: ");
	  
	  int selection = input.nextInt();
	    
	  return selection;
  }
  
  public void displayBalance(String accountName, double balance) {
	  System.out.println("\nAccount: " + accountName);
	  System.out.println("Balance: " + balance);
  }
  
  public int transferFromTo(String a1, String a2) {
	  
    int selection;
    
    System.out.println("\n--Choose Account to transfer from--");
    System.out.println("1. " + a1);
    System.out.println("2. " + a2);
    
    System.out.print("Choice: ");
    
    selection = input.nextInt();
    
    return selection;
  }
  
  public int askReceipt()
  {
	  int selection;
	  System.out.println("\nWould you like a receipt for this transaction?");
	  System.out.println("Enter 1 for YES and 2 for NO");
	  System.out.print("Choice: \n");
	    
	  selection = input.nextInt();
	    
	  return selection;
  }
  
}