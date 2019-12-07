package Usermanager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import CRUD.Connection_manager;

public class Login1 {

	User_manager con=new User_manager();
	public void loginData() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter Username");
		String usernme=s.next();
		System.out.println("Enter Password");
		String pass=s.next();
		
		
		Statement st=(Statement) con.getConnection().createStatement();
		ResultSet r=st.executeQuery("select * from admin");
		while(r.next()) {
			System.out.println(r.getString(2)+" "+r.getString(3)+" ");
			if((r.getString(2).equals(usernme)) && (r.getString(3).equals(pass))) {
				System.out.println("Verified");
			}
			else {
				System.out.println("Mismatch");
			}
		}
		
		
		
		

	}

}
