package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	Connection_manager con=new Connection_manager();

	public void deleteData() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter regno");
		int regno=s.nextInt();
		
		PreparedStatement ps=(PreparedStatement)con.getConnection().prepareStatement("delete from Student where Regno= "+regno);
		
		//ResultSet r=ps.executeQuery("delete from student Regno= ");
		      
		      ps.executeUpdate();
		      System.out.println("Deleted Successfully");
		      con.getConnection().close();
		      
		      Firstapp first=new Firstapp();
				first.choice();
	}

	}


