package CRUD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

public class Login {

	Connection_manager con=new Connection_manager();
		public void loginData() throws ClassNotFoundException, SQLException {
			
			//Connection_manager con=new Connection_manager();
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the Username");
			String username=s.next();
			System.out.println("Enter the Password");
			String password=s.next();
			
			Statement st=(Statement) con.getConnection().createStatement();
			ResultSet r=st.executeQuery("select * from student");
			while(r.next()) {
				System.out.println(r.getString(1)+" "+r.getInt(2)+" "+r.getString(3)+" "+r.getInt(4)+" "+r.getString(5)+" "+r.getString(6)+" "+r.getString(7)+" ");
				if((r.getString(6).equals(username)) && (r.getString(7).equals(password))) {
					System.out.println("Verified");
				}
				else {
					System.out.println("Mismatch");
				}
			}

	}

}
