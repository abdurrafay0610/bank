package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class checking_test 
{
	public checking obj;
	public customer client;
	
	@Before
	public void setup()
	{
		client = new customer(1,"abdurrafay","fast",0610);
		obj = new checking(client,100);
	}
	@Test
	public void test() 
	{	
		boolean check=obj.makeWithdrawal(5100);
		Assert.assertEquals(true,check);
		
		int bal = obj.checkBalance();
		
		Assert.assertEquals(bal, -5000);
		
		obj.makeDeposit(5000);
		
		check=obj.makeWithdrawal(5001);
		
		Assert.assertEquals(false, check);
		
//		fail("Not yet implemented");
	}

}
