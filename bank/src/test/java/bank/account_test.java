package bank;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class account_test 
{
	public account obj;
	public account obj2;
	public customer client;
	public customer client2;
	
	@Before
	public void setUp()
	{
		client = new customer (1,"Abdurrafay","fast",0610);
		client2 = new customer (2,"Gulsher","fast",0445);
		obj = new account (client,100);
		obj2 = new account (client2,200);
	}

	@Test
	public void test() 
	{
		int bal = obj.makeDeposit(500);
		Assert.assertEquals(600, bal);
		
		bal = obj.makeDeposit(-1000);
		Assert.assertEquals(600, bal);
		
		obj.transferAmount(obj2, 600);
		Assert.assertEquals(800,obj2.checkBalance());
		
//		fail("Not yet implemented");
	}

}
