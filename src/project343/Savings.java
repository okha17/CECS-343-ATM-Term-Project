package project343;

public class Savings extends Account{

	private double balance;
	  private String accountName;
	  
	  Savings(String p, String ln, String fn, String an, String name){
	    
	    super(p, ln, fn, an);
	    accountName = name;
	    balance = 0;
	  }
	  
	  public double getBalance(){
	    return balance;
	  }
	  
	  public void updateBalance(double b){
	    balance += b;
	  }
	  
	  public String getAccountName(){
	    return accountName;
	  }

}
