package CRUD;

import java.sql.SQLException;
import java.util.Scanner;

public class Firstapp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		Firstapp first=new Firstapp();
		first.choice();
	}
	
	public void choice() throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the choice");
		
		System.out.println("1)Insert\n2)View\n3)Update\n4)Delete\n5)Login");
		int n=s.nextInt();
		switch(n) {
		case 1:
			Insert insert=new Insert();
			insert.insertData();
			break;
		case 2:
			View view=new View();
			view.viewData();
			break;
		case 3:
			Update update=new Update();
			update.updateData();
			break;
		case 4:
			Delete delete=new Delete();
			delete.deleteData();
			break;
		case 5:
			Login login=new Login();
			login.loginData();
		}

	}

}
