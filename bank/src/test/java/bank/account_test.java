package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class account_test 
{
	public account obj;
	public customer client;
	
	@Before
	public void setUp() throws Exception 
	{
		client = new customer (1,"Abdurrafay","fast",0610);
		obj = new account (client,100);
	}

	@Test
	public void test() 
	{
		int bal = obj.makeDeposit(500);
		Assert.assertEquals(600, bal);
		
		bal = obj.makeDeposit(-1000);
		Assert.assertEquals(600, bal);
		
//		fail("Not yet implemented");
	}

}
