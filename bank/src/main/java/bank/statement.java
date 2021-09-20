package bank;

public class statement 
{
	String type;
	String date;
	int tranAmount;
	int BalThen;
	statement next;
	
	statement(String Date,int amount,int balance,String Type)
	{
		type=Type;
		date=Date;
		tranAmount=amount;
		BalThen=balance;
	}
}
