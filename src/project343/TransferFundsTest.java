package project343;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class TransferFundsTest {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTransfer() {
		Account checking = new Checking("1", "l", "f", "1", "Checking");
		Account savings = new Savings("1", "l", "f", "1", "Savings");
		
		checking.updateBalance(10000);
		savings.updateBalance(0);
		
		TransferFunds t = new TransferFunds();
		t.transfer(checking, savings);
		
		assertTrue("Not enough funds in checking or funds did not decrease", 10000 > checking.getBalance());
		assertTrue("Funds were not added into savings", savings.getBalance() > 0);
		
		checking.updateBalance(0);
		savings.updateBalance(10000);
		
		t.transfer(savings, checking);
		assertTrue("Not enough funds in savings or funds did not decrease", 10000 > savings.getBalance());
		assertTrue("Funds were not added into checking", checking.getBalance() > 0);
	}

}
