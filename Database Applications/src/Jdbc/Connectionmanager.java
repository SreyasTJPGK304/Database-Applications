package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectionmanager {
	private static Connection NULL;

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");  //Register the Driver
		
		//Create Connection
		//Create Connection object
		Connection con=null;
		
		//create connection
		con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/Connection","root","");
		//object=class      method       API:database:serer: port number/DB_name,username,password
		//connection checking
		if(con!=NULL) {
			System.out.printf("Connection Successful");
		}
		else {
			System.out.printf("Check your Connection");
		}
		
		//closing the connection
		con.close();
		
	

	}

}
