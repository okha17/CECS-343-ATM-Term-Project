package project343;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class WithdrawTest {

	@Test
	public void testWithdraw() {
		Account checking = new Checking("1", "l", "f", "1", "Checking");
		checking.updateBalance(10000);
		Withdraw w = new Withdraw();
		w.withdraw(checking);
		
		assertTrue("Not enough funds in balance or funds did not decrease", 10000 > checking.getBalance());
		
	}

}
