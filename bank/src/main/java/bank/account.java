package bank;

import java.util.ArrayList; // import the ArrayList class
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class account 
{
	customer client;
	int balance;
	ArrayList<statement> statement_list = new ArrayList<statement>();
	String date_created;
	
	account()
	{
		
	}
	account(customer Client, int bal)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now= LocalDateTime.now();
		String date=dtf.format(now);
		
		client=Client;
		balance=bal;
		date_created=date;
	}
	
	public int checkBalance() 
	{
		System.out.println("balance of customer with name, " + client.name + ", is:" + balance);
		return balance;
	}
	public int makeDeposit(int deposit)
	{
		if(deposit<0)
		{
			System.out.println("Invalid deposit");
		}
		else
		{	
			balance = balance + deposit;
			System.out.println("Your new balance is:"+balance);
		
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now= LocalDateTime.now();
			String date=dtf.format(now);
		
			statement obj=new statement(date,deposit,balance,"deposit");
			statement_list.add(obj);
		}
		return balance;
	}
	public boolean makeWithdrawal(int withdraw)
	{	
		balance = balance - withdraw;
		System.out.println("Your new balance is: "+ balance);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now= LocalDateTime.now();
		String date=dtf.format(now);
		
		statement obj=new statement(date,withdraw,balance,"withdraw");
		statement_list.add(obj);
		
		return true;
	}
	public void printStatement()
	{
		//gives us the most recent transaction
		int index=statement_list.size()-1;
		
		if(index==-1)
		{
			System.out.println("No transaction occured on this account");
		}
		else
		{
			System.out.println("Account Number:"+client.AccNo);
			System.out.println("Customer Name:"+client.name);
			System.out.println("Customer Address:"+client.address);
			System.out.println("Customer Number:"+client.phoneNo);
			System.out.println("Transaction Date and Time:"+statement_list.get(index).date);
			System.out.println("Transaction Amount:"+statement_list.get(index).tranAmount);
			System.out.println("Remaining Balance:"+statement_list.get(index).BalThen);
		}
	}
	public account transferAmount(account acc,int amount)
	{
		if(this.makeWithdrawal(amount))
		{
			acc.makeDeposit(amount);
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			LocalDateTime now= LocalDateTime.now();
			String date=dtf.format(now);
			
			statement obj=new statement(date,amount,balance,"transfer");
			statement_list.add(obj);
			acc.statement_list.add(obj);
			
		}
		else
		{
			System.out.println("Tranfer failed due to unsufficient balance in payers account");
		}
		return acc;
	}
	public void printdetails()
	{
		System.out.println("Account Number is: "+ client.AccNo);
		System.out.println("Account current balance is: "+ balance);
		System.out.println("Account created on: "+ date_created);
		System.out.println("Account holder name is: "+ client.name);
		System.out.println("Account holder number is: "+client.phoneNo);
		System.out.println("Account holder address is: "+ client.address);
		
		System.out.println("Transaction details:");
		
		int index=statement_list.size();
		if(index==0)
		{
			System.out.println("No transaction occured on this account");
			System.out.println(" ");
		}
		else
		{
			for(int i=0;i<index;i++)
			{
				System.out.println("Transaction Date and Time:"+statement_list.get(i).date);
				System.out.println("Transaction Amount:"+statement_list.get(i).tranAmount);
				System.out.println("Remaining Balance:"+statement_list.get(i).BalThen);
				System.out.println(" ");
			}
		}
	}
}