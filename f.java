import java.sql.*;
import java.io.*;
import java.util.*;

class menu
{
	static String input()
	{
		String c;
		try{
			Scanner sn = new Scanner(System.in);
			c = sn.nextLine();
		}
		catch(Exception e)
		{
			return null;
		}
		return c;
	}

	static int display() throws IOException
	{

		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("\t\t\tEmployee Managament System:");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("1) Add Employee Details");
		System.out.println("2) Delete Employee Details");
		System.out.println("3) Modify Employee Details");
		System.out.println("4) Display Entire Database");
		System.out.println("5) Exit");
		System.out.println("Choose your option (1,2,3,4,5,6)");
		int c = Integer.parseInt(input());
		return c;
	}

	public static void main(String[] args) throws IOException
	{
		Scanner sn=new Scanner(System.in);
		DBAccess db = new DBAccess();

		while(true)
		{
			int c = display();
			switch (c)
			{
				case 1:
					System.out.println("Enter Employee id:");
					String id = input();
					System.out.println("Enter Name:");
					String n = input();
					System.out.println("Enter Age :");
					String a = input();
					System.out.println("Enter Salary:");
					String s = input();
					System.out.println("Enter Phone Number:");
					String pn = input();
					db.insert(id,n,a,s,pn);
					break;
				case 2:
					System.out.println("Enter Employee id:");
					id = input();
					db.delete(id);
					break;
				case 3:
					System.out.println("Enter Employee Name:");
					id = input();
					System.out.println("Enter Name:");
					n = input();
					System.out.println("Enter Age :");
					a = input();
					System.out.println("Enter Salary:");
					s = input();
					System.out.println("Enter Phone Number:");
					pn = input();
					db.modify(id, n, a, s, pn);
					break;
				case 4:
					db.display();
					break;
				case 5:
					db.close();
					System.exit(0);
			}
		}
	}
}