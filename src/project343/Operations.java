package project343;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Operations {
  
	void Receipt(Account acc) 
	{
		System.out.println("\nBEACH BANK");
		System.out.println("-----------------");
		DateFormat date_display = new SimpleDateFormat("MM/dd/yyyy");
		DateFormat time_display = new SimpleDateFormat("hh:mm a");
		Date date = new Date();
		Date time = new Date();
		System.out.println("Date: " + date_display.format(date));
		System.out.println("Time: " + time_display.format(time));
		String lastFour = acc.getAccountNum().substring(acc.getAccountNum().length() - 4);
		System.out.println("Account Number: " + "XXXX" + lastFour);
		int min = 100000;
		int max = 999999;
		int range = (max - min) + 1;
		int transNum = (int)(Math.random() * range) + min;
		System.out.println("Transaction Num: " + transNum);
		System.out.println("Account Balance: $" + acc.getBalance());
	}
	
	boolean verifyBalance(Account acc, double balance)
	{
		if(acc.getBalance() >= balance) 
		{
			return true;
		}
		
		return false;
	}
	
}
