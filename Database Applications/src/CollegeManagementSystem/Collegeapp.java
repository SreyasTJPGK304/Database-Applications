package CollegeManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Collegeapp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Collegeapp college=new Collegeapp();
		college.choice();
	}
	public void choice() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("1)Admin Login\n2)Staff Login\n3)Student Login\n4)Exit");
		System.out.println("Enter the choice");
		int n=s.nextInt();
		switch(n) {
		case 1:
			Superdmin sadmin=new Superdmin();
			sadmin.sadminData();
			break;
		case 2:
			Staff staff=new Staff();
			staff.staffData();
			break;
		case 3:
			Student stud=new Student();
			stud.studData();
			break;
		case 4:
			System.out.println("Process will Complete");
			System.exit(0);
		}
		
	}
		

	}


