package CRUD;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {

	Connection_manager con=new Connection_manager();

	public void updateData() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the reg no you want to update");
		int reg=s.nextInt();
		System.out.println("enter the new reg no");
		int newreg=s.nextInt();
		System.out.println("enter the new name");
		String newname=s.next();
		System.out.println("enter the new department");
		String newdep=s.next();
		System.out.println("enter the new year");
		int newy=s.nextInt();
		System.out.println("enter the new address");
		String newadd=s.next();
		System.out.println("enter the new username");
		String newuser=s.next();
		System.out.println("enter the new password");
		String newpwd=s.next();
		PreparedStatement ps=(PreparedStatement)con.getConnection().prepareStatement("update student set Name=?,Regno=?,Department=?,Year=?,Address=?,Username=?,Password=?where Regno=?");//delete statement
		ps.setString(1,newname);
		ps.setInt(2,newreg);
		ps.setString(3,newdep);
		ps.setInt(4,newy);
		ps.setString(5,newadd);
		ps.setString(6,newuser);
		ps.setString(7,newpwd);
		ps.setInt(8,reg);
		ps.executeUpdate();
		System.out.println("updated successfully");
		con.getConnection().close();
	      
	      Firstapp first=new Firstapp();
			first.choice();
	}

	
}
