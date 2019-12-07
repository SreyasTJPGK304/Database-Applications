package Usermanager;

import java.sql.SQLException;
import java.util.Scanner;

import CRUD.Firstapp;
import CRUD.Insert;

public class Secondapp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Secondapp second=new Secondapp();
		second.choice();
	}
		public void choice() throws ClassNotFoundException, SQLException {
	
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the choice");
		System.out.println("1)Insert\n2)Login\n3)Exit");
		int n=s.nextInt();
		switch(n) {
		case 1:
			Insert1 insert1=new Insert1();
			insert1.insertData();
			break;
		case 2:
			Login1 login1=new Login1();
			login1.loginData();
			break;
		case 3:
			System.out.println("Exit");
			break;
		  
		}
		
		
		
		
	
	}

}
