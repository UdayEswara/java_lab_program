package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ClassPreparedStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db";
			String user = "root";
			String pass = "root";
			con = DriverManager.getConnection(url, user, pass);
			
			/*String sql = "INSERT INTO student VALUES(?,?,?)";
			pst = con.prepareStatement(sql);
			*/
			String sql="insert into student (name, marks, address) values(?,?,?)";
			pst=con.prepareStatement(sql);
			  
			System.out.println("Enter no of records:");
			int n = sc.nextInt();
			for(int i=1;i<=n;i++)
			{
				  System.out.println("Enter name:");
				  String name=sc.next();
				  System.out.println("Enter marks:");
				  float marks=sc.nextFloat();
				  System.out.println("Enter address:");
				  String address=sc.next();
				  
				
				  pst.setString(1,name);
				  pst.setFloat(2,marks);
				  pst.setString(3,address);
				
				  pst.executeUpdate();
				
			}
			sc.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
