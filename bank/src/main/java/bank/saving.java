package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class saving extends account
{
	static int interest_rate;
	saving(customer Client, int bal)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now= LocalDateTime.now();
		String date=dtf.format(now);
		
		interest_rate=1;
		client=Client;
		balance=bal;
		date_created=date;
	}
	public boolean makeWithdrawal(int withdraw)
	{
		if (withdraw > balance)
		{
			System.out.println("Cannot withdraw more than balance in saving account");
			System.out.println("Your balance is: "+ balance);
			return false;
		}
		else
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
	}
	public float calculateInterest()
	{
		float ir=interest_rate;
		return balance*ir/100;
	}
	public float calculateZakat()
	{
		if(balance>=20000)
		{
			float bal=balance;
			return (bal*5)/200;
		}
		else
		{
			return 0;
		}
	}
	public int setInterest(int ir)
	{
		interest_rate=ir;
		return interest_rate;
	}
}

