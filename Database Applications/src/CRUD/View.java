package CRUD;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class View {

	public void viewData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection_manager con=new Connection_manager();
		
			Statement st=(Statement) con.getConnection().createStatement();
			ResultSet r=st.executeQuery("select * from student");
			while(r.next()) {
				System.out.println(r.getString(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getString(5)+" "+r.getString(6)+" "+r.getString(7)+" ");
				
			}
			con.getConnection().close();
			
			Firstapp first=new Firstapp();
			first.choice();
			
	}

	

}
