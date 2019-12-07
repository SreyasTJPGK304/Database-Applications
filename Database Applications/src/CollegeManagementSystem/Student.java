package CollegeManagementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import Shoppingapplication.Connectionshopping;

public class Student {

	Collegemanager con=new Collegemanager();


	public void studData() throws SQLException, ClassNotFoundException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Username");
		String username=s.next();
		System.out.println("Enter the Password");
		String password=s.next();
		int n,c;
		
		
		Statement stmt=(Statement) con.getConnection().createStatement();
		ResultSet rt=stmt.executeQuery("select * from student");
		while(rt.next()) {
			//System.out.println(rt.getString(1)+" "+rt.getString(2)+" ");
			
		
		if((rt.getString(1).equals(username)) && rt.getString(2).equals(password)) {
			System.out.println("Successfully Verified");
			do {
			System.out.println("1)Student Data\n2)Logout");
			System.out.println("Enter the choice");
			c=s.nextInt();
			switch(c) {
			case 1:
				//System.out.println("Student Details");
				
				Statement stat=(Statement) con.getConnection().createStatement();
		        ResultSet r1=stat.executeQuery("select * from addstud");
		        System.out.println("Student Details");
		        while(r1.next())
		        {
		       
		        System.out.println("###########*******###########");
		        System.out.println("Student ID ->"+r1.getInt(1));//print value
		        System.out.println("Student Name ->"+r1.getString(2));
		        System.out.println("Department ->"+r1.getString(3));
		        System.out.println("Attendance ->"+r1.getInt(4));
		        System.out.println("Paper1 ->"+r1.getInt(5));
		        System.out.println("Paper2 ->"+r1.getInt(6));
		        System.out.println("Paper3 ->"+r1.getInt(7));
		        System.out.println("Paper4 ->"+r1.getInt(8));
		        System.out.println("Paper5 ->"+r1.getInt(9));
		        System.out.println("Total Marks ->"+r1.getInt(10));
		        
		        System.out.println("###########*******###########");
		        }
		        break;
			case 2:
				System.out.println("LogOut Successfully");
				Collegeapp college=new Collegeapp();
				college.choice();
				break;
		        
		        
			}
			}while(c!=0);

	}
		else {
			System.out.println("Not Verified");
			Collegeapp college=new Collegeapp();
			college.choice();
		}

}
	}
	}
