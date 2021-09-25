package bank;

import static org.junit.Assert.*;

import org.junit.Before;
import junit.framework.Assert;
import org.junit.Test;

public class saving_test 
{
	saving obj;
	saving obj2;
	customer client;
	customer client2;
	
	@Before
	public void setup()
	{
		client = new customer (1,"Abdurrafay","fast",0610);
		client2 = new customer (2,"Ameen","fast",0600);
		obj = new saving(client,100);
		obj2 = new saving(client2,800);
	}
	
	@Test
	public void test() 
	{
		
		int ir=obj.setInterest(10);		//interest rate will be set
		Assert.assertEquals(10, ir);
		
		obj.makeDeposit(50);
		
		float interest=obj.calculateInterest();		//interest will be calculated
		
		Assert.assertEquals(15f, interest);
		
		float zakat=obj.calculateZakat();			//zakat will be calculated, should be 0 as balance is less
		
		Assert.assertEquals(0f,zakat);
		
		obj.makeDeposit(20000);						
		
		zakat = obj.calculateZakat();				//Again calculating zakat, but this time with sufficient balance
		
		Assert.assertEquals(503.75f, zakat);
		
		Assert.assertEquals(false, obj.makeWithdrawal(20151));	//Withdraw rejected as the amount we want to withdraw is more than our balance
		
		obj.makeWithdrawal(20150);
		
		int bal = obj.checkBalance();
		
		Assert.assertEquals(0, bal);
		
		obj.transferAmount(obj2, 1000);					//transfer will not occur as there are not enough money in the account
		Assert.assertEquals(800, obj2.checkBalance());	//So, balance will be the same as before
		
		obj2.printStatement();
		obj2.printdetails();
		
//		fail("Not yet implemented");
	}
}
