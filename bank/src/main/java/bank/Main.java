package bank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<saving> saving_list = new ArrayList<saving>();
		ArrayList<checking> checking_list = new ArrayList<checking>();
		int AccNo=1;
		Scanner input = new Scanner (System.in);
		int condition=7;
		
		while(condition!=0)
		{
			System.out.println("To open a new account type 1");
			System.out.println("To close an existing account type 2");
			System.out.println("To Login to a specific account type 3");
			System.out.println("To specify interest rate, applicable to all saving accounts type 4");
			System.out.println("To display all details type 5");
			System.out.println("To exit type 0");
			
			condition = input.nextInt();
			
			if(condition==1)
			{
				System.out.println("Which account do you want to make? Press s for saving account, c for current and b if you want to make both");
				String choice =input.next();
				System.out.println(choice);
				if(choice.equals("s"))
				{
					int acc=AccNo;
					AccNo++;
					String name;
					String address;
					int Phoneno;
					
					System.out.println("You have selected saving account");
					System.out.println("Kindly give the following details:");
					System.out.println("Name:");
					name = input.next();
					System.out.println("Adress:");
					address = input.next();
					System.out.println("Phone Number:");
					Phoneno = input.nextInt();
					
					customer client=new customer(acc,name,address,Phoneno);
					
					int bal;
					System.out.println("Initial balance to store:");
					bal = input.nextInt();
					
					saving sav=new saving(client, bal);
					
					saving_list.add(sav);
				}
				else if(choice.equals("c"))
				{
					int acc=AccNo;
					AccNo++;
					String name;
					String address;
					int Phoneno;
					
					System.out.println("You have selected checking account");
					System.out.println("Kindly give the following details:");
					System.out.println("Name:");
					name = input.next();
					System.out.println("Adress:");
					address = input.next();
					System.out.println("Phone Number:");
					Phoneno = input.nextInt();
					
					customer client=new customer(acc,name,address,Phoneno);
					
					int bal;
					System.out.println("Initial balance to store:");
					bal = input.nextInt();
					
					checking check=new checking(client, bal);
					
					checking_list.add(check);
				}
				else if(choice.equals("b"))
				{
					int acc=AccNo;
					AccNo++;
					String name;
					String address;
					int Phoneno;
					
					System.out.println("You have selected to create both account");
					System.out.println("Kindly give the following details:");
					System.out.println("Name:");
					name = input.next();
					System.out.println("Adress:");
					address = input.next();
					System.out.println("Phone Number:");
					Phoneno = input.nextInt();
					
					customer client=new customer(acc,name,address,Phoneno);
					
					int bal;
					System.out.println("Initial balance to store:");
					bal = input.nextInt();
					
					checking check=new checking(client, bal);
					saving sav= new saving(client, bal);
					
					saving_list.add(sav);
					checking_list.add(check);
				}
			}
			else if(condition==2)
			{
				System.out.println("Enter Account number of the account you want to delete");
				int del_Acc=input.nextInt();
				
				int index1=saving_list.size();
				int index2=checking_list.size();
				
				
				//deletion for saving account
				for(int i=0;i<index1;i++)
				{
					if(saving_list.get(i).client.AccNo==del_Acc)
					{
						System.out.println("A saving account with this number found. delete? Y/n");
						String c;
						c = input.next();
						if(c.equals("Y"))
						{
							System.out.println("Successfully deleted");
							System.out.println(" ");
							saving_list.remove(i);
						}
						else
						{
							System.out.println("Not deleted");
						}
					}
				}
				
				//deletion for checking account
				for(int i=0;i<index2;i++)
				{
					if(checking_list.get(i).client.AccNo==del_Acc)
					{
						System.out.println("A checking account with this number found. delete? Y/n");
						String c;
						c = input.next();
						if(c.equals("Y"))
						{
							System.out.println("Successfully deleted");
							System.out.println(" ");
							checking_list.remove(i);
						}
						else
						{
							System.out.println("Not deleted");
						}
					}
				}
			}
			else if(condition==3)
			{
				System.out.println("Enter Account number of the account you want to login");
				int login_Acc=input.nextInt();
				
				int index1=saving_list.size();
				int index2=checking_list.size();
				
				int index11=-1;
				int index22=-1;
				
				if(index1==0 && index2==0)
				{
					System.out.println("No such account found and there are currently no accounts in the bank");
				}
				else
				{
					for(int i=0;i<index1;i++)
					{
						if(saving_list.get(i).client.AccNo==login_Acc)
						{
							index11=i;
						}
					}
					for(int i=0;i<index2;i++)
					{
						if(checking_list.get(i).client.AccNo==login_Acc)
						{
							index22=i;
						}
					}

					if(index11==-1 && index22==-1)
					{
						System.out.println("No such account found");
					}
					else if(index11!=-1 && index22!=-1)
					{
						System.out.println("Both saving and checking account found,which one do you want? Press s for saving or c for checking");
						String c=input.next();
						
						if(c.equals("s"))
						{
							index22=-1;
						}
						else if(c.equals("c"))
						{
							index11=-1;
						}	
					}
					
					if(index11!=-1)
					{
						//saving account found
						System.out.println("Saving account found and logged in");
						int condition1=9;
						while(condition1!=0)
						{
							System.out.println("To exit this interface type 0");
							System.out.println("To check balance type 1");
							System.out.println("To make deposit amount type 2");
							System.out.println("To make withdrawal type 3");
							System.out.println("To transfer amount type 4");
							System.out.println("To print statement type 5");
							condition1=input.nextInt();
							
							if(condition1==1)
							{
								saving_list.get(index11).checkBalance();
							}
							else if(condition1==2)
							{
								System.out.println("Enter deposit amount:");
								int deposit=input.nextInt();
								saving_list.get(index11).makeDeposit(deposit);
							}
							else if(condition1==3)
							{
								System.out.println("Enter withdrawal amount:");
								int withdraw=input.nextInt();
								saving_list.get(index11).makeWithdrawal(withdraw);
							}
							else if(condition1==4)
							{
								System.out.println("Enter transfer amount:");
								int transfer=input.nextInt();
								System.out.println("Enter account number of the account to tranfer:");
								
								int acc2=input.nextInt();
								
								int iindex11=-1;
								int iindex22=-1;
								
								if(index1==0 && index2==0)
								{
									System.out.println("No such account found");
								}
								else
								{
									for(int i=0;i<index1;i++)
									{
										if(saving_list.get(i).client.AccNo==acc2)
										{
											iindex11=i;
										}
									}
									for(int i=0;i<index2;i++)
									{
										if(checking_list.get(i).client.AccNo==acc2)
										{
											iindex22=i;
										}
									}

									if(iindex11==-1 && iindex22==-1)
									{
										System.out.println("No such account found");
									}
									else if(iindex11 != -1 && iindex22 != -1)
									{
										System.out.println("Account found in both saving and checking, which one do you want?Press s for saving or c for checking ");
										String cc=input.next();
										
										if(cc.equals("s"))
										{
											saving_list.get(index11).transferAmount(saving_list.get(iindex11), transfer);
											System.out.println("Target account is a saving account, and transfer done");
										}
										else if(cc.equals("c"))
										{
											saving_list.get(index11).transferAmount(checking_list.get(iindex22), transfer);
											System.out.println("Target account is a checking account, and transfer done");
										}
									}
									else if(iindex11 !=-1)
									{
										saving_list.get(index11).transferAmount(saving_list.get(iindex11), transfer);
										System.out.println("Target account is a saving account, and transfer done");
									}
									else if(iindex22!= -1)
									{
										saving_list.get(index11).transferAmount(checking_list.get(iindex22), transfer);
										System.out.println("Target account is a checking account, and transfer done");
									}
								}
							}
							else if(condition1==5)
							{
								saving_list.get(index11).printStatement();
							}
						}
					}
					else if(index22!= -1)
					{
						System.out.println("A checking account found and logged in");
						int condition1=9;
						while(condition1!=0)
						{
							System.out.println("To exit this interface type 0");
							System.out.println("To check balance type 1");
							System.out.println("To make deposit amount type 2");
							System.out.println("To make withdrawal type 3");
							System.out.println("To transfer amount type 4");
							System.out.println("To print statement type 5");
							condition1=input.nextInt();
							
							if(condition1==1)
							{
								checking_list.get(index22).checkBalance();
							}
							else if(condition1==2)
							{
								System.out.println("Enter deposit amount:");
								int deposit=input.nextInt();
								checking_list.get(index22).makeDeposit(deposit);
							}
							else if(condition1==3)
							{
								System.out.println("Enter withdrawal amount:");
								int withdraw=input.nextInt();
								checking_list.get(index22).makeWithdrawal(withdraw);
							}
							else if(condition1==4)
							{
								System.out.println("Enter transfer amount:");
								int transfer=input.nextInt();
								System.out.println("Enter account number of the account to tranfer:");
								
								int acc2=input.nextInt();
								
								int iindex11=-1;
								int iindex22=-1;
								
								if(index1==0 && index2==0)
								{
									System.out.println("No such account found");
								}
								else
								{
									for(int i=0;i<index1;i++)
									{
										if(saving_list.get(i).client.AccNo==acc2)
										{
											iindex11=i;
										}
									}
									for(int i=0;i<index2;i++)
									{
										if(checking_list.get(i).client.AccNo==acc2)
										{
											iindex22=i;
										}
									}

									if(iindex11==-1 && iindex22==-1)
									{
										System.out.println("No such account found");
									}
									else if(iindex11!=-1 && iindex22!=-1)
									{
										System.out.println("Account found in both saving and checking, which one do you want?Press s for saving or c for checking ");
										String cc=input.next();
										
										if(cc.equals("s"))
										{
											checking_list.get(index22).transferAmount(saving_list.get(iindex11), transfer);
											System.out.println("Target account is a saving account, and transfer done");
										}
										else if(cc.equals("c"))
										{
											checking_list.get(index22).transferAmount(checking_list.get(iindex22), transfer);
											System.out.println("Target account is a checking account, and transfer done");
										}
									}
									else if(iindex11 !=-1)
									{
										checking_list.get(index22).transferAmount(saving_list.get(iindex11), transfer);
										System.out.println("Target account is a saving account, and transfer done");
									}
									else if(iindex22!= -1)
									{
										checking_list.get(index22).transferAmount(checking_list.get(iindex22), transfer);
										System.out.println("Target account is a checking account, and transfer done");
									}
								}
							}
							else if(condition1==5)
							{
								checking_list.get(index22).printStatement();
							}
						}
					}
				}
			}
			
			else if(condition==4)
			{
				System.out.println("Enter value of % interest in integer:");
				int intr_rate=input.nextInt();
				
				if(saving_list.size()==0)
				{
					customer client=new customer(0,"test","test",5);
					saving sav= new saving(client, 5);
					sav.setInterest(intr_rate);
				}
				else
				{
					saving_list.get(0).setInterest(intr_rate);
				}
			}
			else if(condition==5)
			{
				int index1=saving_list.size();
				int index2=checking_list.size();
				
				for(int i=0;i<index1;i++)
				{
					saving_list.get(i).printdetails();
				}
				for(int i=0;i<index2;i++)
				{
					checking_list.get(i).printdetails();
				}
			}
		}
		input.close();
	}
}
