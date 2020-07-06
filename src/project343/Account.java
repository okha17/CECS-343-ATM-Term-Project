package project343;

abstract class Account
{
	  private String pin;
	  private String lastName;
	  private String firstName;
	  private String accountNumber;
	  
	  Account()
	  {
	    pin = "";
	    lastName = "";
	    firstName = "";
	    accountNumber = "";
	  }
	  
	  Account(String p, String ln, String fn, String an)
	  {
	    pin = p;
	    lastName = ln;
	    firstName = fn;
	    accountNumber = an;
	  }
	  
	  public String getPin(){
	    return pin;
	  }
	  
	  public void setPin(String p){
	    pin = p;
	  }
	  
	  public String getAccountNum(){
			return accountNumber;    
	  }
	  
	  public abstract double getBalance();
	  
	  public abstract void updateBalance(double difference);
	  
	  public abstract String getAccountName();
}
