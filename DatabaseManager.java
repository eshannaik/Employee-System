import java.sql.*;

public class DatabaseManager
{
	private Connection c;
	private Statement stmt;
	DatabaseManager()
	{
		this.c = null;
		this.stmt = null;
	}
	public void setConnection()
	{
		try
		{
			this.c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","password");
			this.stmt = c.createStatement();
			System.out.println("\t\t\tDatabase Connected");
		}
		catch(SQLExcecption e)
		{
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		return this.c;
	}
	public Statement getStmt() {
		return this.stmt;
	}
}
