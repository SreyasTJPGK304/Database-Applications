package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import java.util.Scanner;
import java.sql.Statement;

public class Connection_manager {
	private static Connection NULL;
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		//Create Connection
		//Create connection object
		Connection con=null;
		
		//Create connection
		con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/student","root","");
		if(con!=NULL) {
			return con;
		}
		else {
			return null;
		}
		
	}
}

