package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Studentdetails {
	private static Connection NULL;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		//Create Connection
		//Create connection object
		Connection con=null;
		
		//Create connection
		con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/student","root","");
		if(con!=NULL) {
			System.out.println("Connection Successful");
		}
		else {
			System.out.printf("Check your Connection");
		}
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the operation");
		System.out.println("1)insert\n2)Display");
		int n=s.nextInt();
		switch(n) {
		case 1:
		
		System.out.println("Enter name");
		String name=s.next();
		System.out.println("Enter register number");
		int regno=s.nextInt();
		System.out.println("Enter Department");
		String dep=s.next();
		System.out.println("Enter year");
		int year=s.nextInt();
		System.out.println("Enter Address");
		String address=s.next();
		//send data to the database
		PreparedStatement ps=con.prepareStatement("insert into Student (Name,Regno,Department,Year,Address) values(?,?,?,?,?);");
		//class          object                        insert query     db attributes
		ps.setString(1, name);
		ps.setInt(2, regno);
		ps.setString(3, dep);
		ps.setInt(4, year);
		ps.setString(5, address);
		ps.executeUpdate();
		System.out.println("insert Successful");
		con.close();
		break;
		
		case 2:
			//callable
			Statement st=(Statement) con.createStatement();
			ResultSet r=st.executeQuery("select * from student");
			while(r.next()) {
				System.out.println(r.getString(1)+" "+r.getInt(2)+" "+r.getString(3)+" "+r.getInt(4)+" "+r.getString(5)+" ");
				
			}
		
		//closing the connection
		con.close();
		break;
		
		}

	}

}
