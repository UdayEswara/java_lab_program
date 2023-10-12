package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ClassCrudOperation {

	static Scanner sc = new Scanner(System.in);
	static Connection con = null;
	static PreparedStatement pst = null;
	static Statement stmt = null;
	void create() throws Exception
	{
		
		String sql = "CREATE TABLE product\r\n"
				+ "(\r\n"
				+ "   no int not null auto_increment,\r\n"
				+ "   name varchar(30),\r\n"
				+ "   category varchar(20),\r\n"
				+ "   price int,\r\n"
				+ "   brand varchar(20),\r\n"
				+ "   rating float,\r\n"
				+ "   primary key(no)\r\n"
				+ ");";
		stmt = con.createStatement();
		stmt.execute(sql);
		System.out.println("Table is created ");
		
	}
	 void insert()throws Exception
	{
		String sql="insert into product (name, category, price, brand, rating) values(?,?,?,?,?)";
		pst=con.prepareStatement(sql);
		System.out.println("Enter no of records:");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter "+i+" values:");
			String name = sc.nextLine();
			System.out.println("Enter name: ");
			name = sc.nextLine();
			
			System.out.println("Enter category: ");
			String category = sc.next();
			
			System.out.println("Enter price: ");
			int price = sc.nextInt();
			
			System.out.println("Enter brand: ");
			String brand = sc.next();
			
			System.out.println("Enter rating: ");
			float rating = sc.nextFloat();
			
			pst.setString(1, name);
			pst.setString(2,category);
			pst.setInt(3, price);
			pst.setString(4, brand);
			pst.setFloat(5, rating);
			
			pst.executeUpdate();
			
			
		}
		System.out.println(n+"records are insert ");
	}
	void select()throws Exception
	{
		stmt = con.createStatement();
		ResultSet resultSet1 = stmt.executeQuery("select * from product where price <= 1000;");
		while(resultSet1.next())
		{
			System.out.println(resultSet1.getInt(1)+" | "+resultSet1.getString(2)+" | "+resultSet1.getString(3)+" | "+resultSet1.getInt(4)+" | "+resultSet1.getString(5)+" | "+resultSet1.getFloat(6));
		}
		System.out.println("=========================================");
		ResultSet resultSet2 = stmt.executeQuery("select * from product where category = 'Gadgets' and rating > 4.5;");
		while(resultSet2.next())
		{
			System.out.println(resultSet2.getInt(1)+" | "+resultSet2.getString(2)+" | "+resultSet2.getString(3)+" | "+resultSet2.getInt(4)+" | "+resultSet2.getString(5)+" | "+resultSet2.getFloat(6));
		}
	}
	void update()throws Exception
	{
		stmt = con.createStatement();
		stmt.executeUpdate("update product set price = 1000 where no = 9;");
		ResultSet resultSet1 = stmt.executeQuery("select * from product where no = 9;");
		while(resultSet1.next())
		{
			System.out.println(resultSet1.getInt(1)+" | "+resultSet1.getString(2)+" | "+resultSet1.getString(3)+" | "+resultSet1.getInt(4)+" | "+resultSet1.getString(5)+" | "+resultSet1.getFloat(6));
		}
	}
	void delete()throws Exception
	{
		stmt = con.createStatement();
		ResultSet resultSet1 = stmt.executeQuery("select * from product where price <= 100;");
		while(resultSet1.next())
		{
			int no = resultSet1.getInt(1);
			String sql = "delete from product where no = ?;";
			pst=con.prepareStatement(sql);
			pst.setInt(1, no);
			int n = pst.executeUpdate();
			if(n!=0)
				System.out.println("recored is deleted");
		}
		ResultSet resultSet2 = stmt.executeQuery("select * from product;");
		while(resultSet2.next())
		{
			System.out.println(resultSet2.getInt(1)+" | "+resultSet2.getString(2)+" | "+resultSet2.getString(3)+" | "+resultSet2.getInt(4)+" | "+resultSet2.getString(5)+" | "+resultSet2.getFloat(6));
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/db";
			String user = "root";
			String pass = "root";
			con = DriverManager.getConnection(url,user,pass);
			
			ClassCrudOperation crud = new ClassCrudOperation();
			while(true)
			{
				
				System.out.println("1.)Create \n2.)Insert \n3.)Select \n4.)Update \n5.)Delete \n6.)Exit");
				System.out.println("Enter your choose :");
				int choose = sc.nextInt();
				switch(choose)
				{
					case 1 : crud.create();break;
					case 2 : crud.insert();break;
					case 3 : crud.select();break;
					case 4 : crud.update();break;
					case 5 : crud.delete();break;
					case 6 : System.exit(0);
					default : System.exit(1);
				}
			}
			
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
    	{
    		try 
    		{
    			sc.close();
    			con.close();
    		}
    		catch(Exception e)
    		{
    			e.printStackTrace();
    		}	
    	}
	}

}
