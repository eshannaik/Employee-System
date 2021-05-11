import java.sql.*;

public class DBAccess
{
	PreparedStatement s;
	Connection con;
	ResultSet r;

	public DBAccess()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","password");
			System.out.println("\t\t\tDatabase Connected");
		}
		catch(Exception e)
		{
			System.out.println("Database Not Connected because " + e);
		}
	}

	public void insert(String id,String n,String a,String sa,String pn)
	{
		try
		{
			s = con.prepareStatement("Insert into Employee Values (?,?,?,?,?)");
			s.setString(1,id);
			s.setString(2,n);
			s.setString(3,a);
			s.setString(4,sa);
			s.setString(5,pn);
			System.out.println("Record has been added");
		}
		catch(Exception e)
		{
			System.out.println("Record has not been added because " + e);
		}	
	}

	public void delete(String id)
	{
		try
		{
			s = con.prepareStatement("Delete Employee with id =?");
			s.setString(1,id);
			s.executeUpdate();
			System.out.println("Record has been deleted");
		}
		catch(Exception e)
		{
			System.out.println("Record has not deleted due to " + e);
		}	
	}

	public void modify(String id,String n,String a,String sa,String pn)
	{
		try
		{
			s = con.prepareStatement("update Employee set name=?, age=?, salary=?, phno=? WHERE emp_id = ?");
			s.setString(1,n);
			s.setString(2,a);
			s.setString(3,sa);
			s.setString(4,pn);
			s.setString(5,id);
			s.executeUpdate();
			System.out.println("Record has been updates");
		}
		catch(Exception e)
		{
			System.out.println("Record has not been updated due to " + e);
		}	
	}

	public void display()
	{
		try
		{
			s = con.prepareStatement("select * from Employee");
			r = s.executeQuery();
				System.out.println("  ID    |    NAME        |    Age   |   Salary     | PHONE ");
                System.out.println("---------------------------------------------------------------");

            while(r.next())
            {
            	System.out.println( r.getString(1) + "\t " + r.getString(2) + "\t " + r.getString(3) + "\t " + r.getString(4) + "\t " + r.getString(5));
            }
			System.out.println("Record has been updates");
		}
		catch(Exception e)
		{}	
	}

	public void close()
	{
		try
		{
			r.close();
			s.close();
			con.close();
		}
		catch(Exception e)
		{}
	}
}