package CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Insert {
	Connection_manager con=new Connection_manager();
	Scanner s=new Scanner(System.in);

	public void insertData() throws ClassNotFoundException, SQLException {
		
		
		con.getConnection();
		

		Pattern patName=Pattern.compile("(^[A-Z]+[a-z]*)");
		
//	      String regexNum = "^[0-9]*";
//	      Pattern patNum = Pattern.compile(regexNum);
//	      
//	      String regexDep = "(^[a-z]+[A-Z.]*)";
//			 Pattern patDep = Pattern.compile(regexDep);
			 
	      Pattern patPas=Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
		
		
		
		//con.getConnection();
		System.out.println("Enter name");
		String name=s.next();
		//Matcher nme=patName.matcher(name);
		System.out.println("Enter register number");
		String regno=s.next();
		//Matcher rg=patNum.matcher(regno);
		
		System.out.println("Enter Department");
		String dep=s.next();
		//Matcher dpt=patDep.matcher(dep);
		
		System.out.println("Enter year");
		String year=s.next();
		//Matcher yr=patNum.matcher(year);
		System.out.println("Enter Address");
		String address=s.next();
		//Matcher addr=patDep.matcher(year);
		
		
		
		System.out.println("Enter Username");
		String username=s.next();
		Matcher usernme=patName.matcher(username);
		System.out.println("Enter password");
		String password=s.next();
		Matcher pas=patPas.matcher(password);
		
		if((usernme.matches()) && (pas.matches())) {
			PreparedStatement ps=con.getConnection().prepareStatement("insert into Student (Name,Regno,Department,Year,Address,Username,Password) values(?,?,?,?,?,?,?);");
			
			ps.setString(1, name);
			ps.setString(2, regno);
		    ps.setString(3, dep);
			ps.setString(4, year);
			ps.setString(5, address);
			
			ps.setString(6,username);
			ps.setString(7, password);
			ps.executeUpdate();
			con.getConnection().close();
			System.out.println("Data Saved");
		
		}
		else {
			if(!usernme.matches()) {
				System.out.println("Invalid username");
			}
			if(!pas.matches()) {
				System.out.println("Invalid password");
			}
		}
		
		
		Firstapp first=new Firstapp();
			first.choice();
		
		
		
		}
	
	
}
