package Usermanager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import CRUD.Connection_manager;

public class Insert1 {
	User_manager con=new User_manager();
	Scanner s=new Scanner(System.in);

	public void insertData() throws ClassNotFoundException, SQLException {
		con.getConnection();
		
		String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		 Pattern pswEmail = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
		 Pattern patEmail = Pattern.compile(regexEmail);
		
		System.out.println("Enter the choice");
		System.out.println("1)Admin Login\n2)Student Login");
		int n=s.nextInt();
		if(n==1) {
		System.out.println("Welcome to Admin Login");
		System.out.println("Enter the id");
		int id=s.nextInt();
		System.out.println("Enter Username");
		String username=s.next();
		Matcher user=patEmail.matcher(username);
		System.out.println("Enter Password");
		String password=s.next();
		Matcher pas=patEmail.matcher(password);
		
		if((user.matches()) && (pas.matches())) {
		
		PreparedStatement ps=con.getConnection().prepareStatement("insert into admin (Userid,Username,Password) values(?,?,?);");
		ps.setInt(1, id);
		ps.setString(2, username);
		ps.setString(3, password);
		ps.executeUpdate();
		con.getConnection().close();
		System.out.println("Data Saved");
		}
		else {
			if(!user.matches()) {
				System.out.println("Invalid username");
			}
			if(!pas.matches()) {
				System.out.println("Invalid password");
			}
		
		}
		}
		else if(n==2) {
			System.out.println("Welcome to Student Login");
			System.out.println("Enter the id");
			int id1=s.nextInt();
			System.out.println("Enter Username");
			String username1=s.next();
			Matcher user1=patEmail.matcher(username1);
			System.out.println("Enter Password");
			String password1=s.next();
			Matcher pas1=patEmail.matcher(password1);
			
			if((user1.matches()) && (pas1.matches())) {
			PreparedStatement ps=con.getConnection().prepareStatement("insert into students (Userid,Username,Password) values(?,?,?);");
			ps.setInt(1, id1);
			ps.setString(2, username1);
			ps.setString(3, password1);
			ps.executeUpdate();
			con.getConnection().close();
			System.out.println("Data Saved");
			
		}
			if(!user1.matches()) {
				System.out.println("Invalid username");
			}
			if(!pas1.matches()) {
				System.out.println("Invalid password");
			}
		
		}
		else {
			System.out.println("Invalid choice");
		}
		
		Secondapp second=new Secondapp();
		second.choice();
		

	  

	}

}
