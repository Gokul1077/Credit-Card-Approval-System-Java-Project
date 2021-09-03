
import java.util.*;
import java.sql.*;

public class Login{
	public static void main(String[] args) {
		Connection conn = null;
		try {
			String driver="com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/stdbms";
			String username="root";
			String password="root1";
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("Database Connected Successfully\n");
		}
		catch(Exception e) {
			
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("SELECT ANY ONE OPTION \n1.ADD ACCOUNT\n2.CHECK ACCOUNT ");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:	System.out.println("Enter the username: ");
				String un = sc.next();
				System.out.println("\nEnter the password: ");
				String pd = sc.next();
				PreparedStatement p;
				try {
					p = conn.prepareStatement("INSERT INTO UNPD VALUES(?,?);");
					p.setString(1, un);
					p.setString(2, pd);
					p.execute();
					p.close();
					System.out.println("\nSUCCESSFULLY ADDED TO DB ");
				}
				catch(Exception e1)
				{
					
				}
				break;
				
		case 2: System.out.println("Enter the username: ");
				un = sc.next();
				System.out.println("\nEnter the password: ");
				pd = sc.next();
				java.sql.Statement stmt;
				try {
					stmt = conn.createStatement();
					ResultSet rs=stmt.executeQuery("SELECT * from unpd WHERE username = '"+un+"'");
					rs.next();
					if(rs.getString(2).equals(pd))
					{
						System.out.println("Correct Password");
					}
					else
						System.out.println("Incorrect Password");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
		}
		
		
	}
}