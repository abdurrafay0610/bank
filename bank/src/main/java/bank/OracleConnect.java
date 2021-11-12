package bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnect 
{
	private Connection con;
	//constructor
	OracleConnect()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:SYED","scott","1234");
			
			System.out.println("Connection Established");
			
			//creating schema
			Statement stmt = con.createStatement();

			ResultSet rs=stmt.executeQuery("CREATE TABLE checking(id NUMBER PRIMARY KEY,balance NUMBER,datte VARCHAR(30))");
			rs=stmt.executeQuery("CREATE TABLE saving(id NUMBER PRIMARY KEY,balance NUMBER,datte VARCHAR(30))");
			
		}
		catch(Exception e)
		{
			
		}
		
	}
	//ftns
	public void addChecking(checking check) throws SQLException
	{
		String sql="INSERT INTO checking(id,balance,datte) VALUES (?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setInt(1, check.client.AccNo);
		statement.setInt(2, check.balance);
		statement.setString(3, check.date_created);
		
		int rowsInserted = statement.executeUpdate();
		
		if(rowsInserted>0)
		{
			System.out.println("Checking account saved");
		}
		
	}
	public void addSaving(saving save) throws SQLException
	{
		String sql="INSERT INTO saving(id,balance,datte) VALUES (?,?,?)";
		PreparedStatement statement = con.prepareStatement(sql);
		
		statement.setInt(1, save.client.AccNo);
		statement.setInt(2, save.balance);
		statement.setString(3, save.date_created);
		
		int rowsInserted = statement.executeUpdate();
		
		if(rowsInserted>0)
		{
			System.out.println("Checking account saved");
		}
	}
}
