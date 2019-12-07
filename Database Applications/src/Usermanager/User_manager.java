package Usermanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class User_manager {
	private static Connection NULL;
	
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=null;
		con=DriverManager.getConnection("jdbc:Mysql://localhost:3306/Usermanager","root","");
		if(con!=NULL) {
			return con;
		
		}
		else {
			return null;
		}
		
		

	

	}

}
