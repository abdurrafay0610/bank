package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;

public class saving_test 
{
	saving obj;
	customer client;
	
	@Before
	public void setup()
	{
		client = new customer (1,"Abdurrafay","fast",0610);
		obj = new saving(client,100);
	}
	
	@Test
	public void test() 
	{
		
		int ir=obj.setInterest(10);
		Assert.assertEquals(10, ir);
		
		obj.makeDeposit(50);
		
		float interest=obj.calculateInterest();
		
		Assert.assertEquals(15f, interest);
		
		float zakat=obj.calculateZakat();
		
		Assert.assertEquals(0f,zakat);
		
		obj.makeDeposit(20000);
		
		zakat = obj.calculateZakat();
		
		Assert.assertEquals(503.75f, zakat);
		
		Assert.assertEquals(false, obj.makeWithdrawal(20151));
		
		obj.makeWithdrawal(20150);
		
		int bal = obj.checkBalance();
		
		Assert.assertEquals(0, bal);
		
//		fail("Not yet implemented");
	}

}
