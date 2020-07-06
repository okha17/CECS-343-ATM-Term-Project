package project343;

class Checking extends Account{
	  
	  private double balance;
	  private String accountName;
	  
	  Checking(String p, String ln, String fn, String an, String name){
	    
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
