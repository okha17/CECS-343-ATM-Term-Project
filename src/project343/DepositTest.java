package project343;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class DepositTest {


	@Test
	public void testDeposit() {
		Account checking = new Checking("1", "l", "f", "1", "Checking");
		Deposit d = new Deposit();
		d.deposit(checking);
		
		assertTrue("Funds were not added", checking.getBalance() > 0);
	}

}
