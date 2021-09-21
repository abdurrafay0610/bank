package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class checking extends account 
{
	checking(customer Client, int bal)
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now= LocalDateTime.now();
		String date=dtf.format(now);
		
		client=Client;
		balance=bal;
		date_created=date;
	}
	public boolean makeWithdrawal(int withdraw)
	{	
		if(withdraw>balance+5000)
		{
			System.out.println("Cannot withdraw more than 5000 above balance in checking account");
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
}
