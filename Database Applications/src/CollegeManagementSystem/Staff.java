package CollegeManagementSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Staff {
	Collegemanager con=new Collegemanager();


	
		
		
		
	    Scanner s=new Scanner(System.in);
	    int n,p;
	public void staffData()throws ClassNotFoundException,SQLException
	{
	Statement s1=con.getConnection().createStatement();
	System.out.println("Enter the username");
	String user=s.next();
	System.out.println("Enter the password");
	   String pass=s.next();
	   ResultSet r2=s1.executeQuery("select * from staff");
	   while(r2.next())
	   {
	   String name1=r2.getString(1);
	   String pw1=r2.getString(2);
	   if(name1.equals(user)&&pw1.equals(pass))
	   {
	    System.out.println("Successfully verified");
	    do
	    {
	    System.out.println("1)Insert\n2)View\n3)Update\n4)Delete\n5)Logout");
	    System.out.println("Enter the choice");
	    n=s.nextInt();
	    switch(n)
	    {
	    case 1:
	    System.out.println("Enter the student id");
	    int id=s.nextInt();
	    System.out.println("Enter name of student");
	    String name=s.next();
	    System.out.println("Enter the department");
	    String dept=s.next();
	    System.out.println("Enter the attendance of student");
	    int at=s.nextInt();
	    System.out.println("Enter mark of paper1");
	    int m1=s.nextInt();
	    System.out.println("Enter mark of paper2");
	    int m2=s.nextInt();
	    System.out.println("Enter mark of paper3");
	    int m3=s.nextInt();
	    System.out.println("Enter mark of paper4");
	    int m4=s.nextInt();
	    System.out.println("Enter mark of paper5");
	    int m5=s.nextInt();
	    int sum=m1+m2+m3+m4+m5;
	    System.out.println("Total marks: "+sum);
	    //int tot=s.nextInt();
	    
	    System.out.println("Student details added successfully");
	    PreparedStatement ps=(PreparedStatement)con.getConnection().prepareStatement("insert addstud(Student_id,Student_name,Department,Attendance,Paper1,Paper2,Paper3,Paper4,Paper5,Total_marks)values(?,?,?,?,?,?,?,?,?,?)");
	                ps.setInt(1,id);
	                ps.setString(2,name);
	                ps.setString(3,dept);
	                ps.setInt(4,at);
	                ps.setInt(5,m1);
	                ps.setInt(6,m2);
	                ps.setInt(7,m3);
	                ps.setInt(8,m4);
	                ps.setInt(9,m5);
	                ps.setInt(10, sum);
	                
	                ps.executeUpdate();
	                con.getConnection().close();
	                break;
	    case 2:
	    	do {
	    System.out.println("1)Student\n2)Staff\n3)Exit");
	    System.out.println("Enter the choice");
	    p=s.nextInt();
	    if(p==1)
	    {
	    Statement sta=con.getConnection().createStatement();
	        ResultSet r1=sta.executeQuery("select * from addstud");
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
	    }
	    if(p==2)
	    {
	    Statement sta1=con.getConnection().createStatement();
	       ResultSet r3=sta1.executeQuery("select * from staffadd");
	       System.out.println("Staff Details");
	       while(r3.next())
	        {
	       
	       System.out.println("###########*******###########");
	       System.out.println("Staff ID ->"+r3.getInt(1));
	       System.out.println("Staff name ->"+r3.getString(2));
	       System.out.println("Deparment ->"+r3.getString(3));
	       System.out.println("Attendance ->"+r3.getInt(4));
	       System.out.println("Salary ->"+r3.getInt(5));
	       System.out.println("###########*******###########");
	        }
	    }
	    if(p==3) {
	    	System.out.println("Exit");
	    	break;
	    }
	    	}while(p!=0);
	    con.getConnection().close();
	    break;
	    case 3:
	    Statement sta2=con.getConnection().createStatement();
	    ResultSet r4=sta2.executeQuery("select *from addstud ");
	    while(r4.next())
	    {
	    System.out.println("##########List of Students #########");
	    System.out.println("Student ID ->"+r4.getInt(1));//print value
	    System.out.println("Department ->"+r4.getString(3));
	    }
	             System.out.println("Enter the id of student to be updated");
	             int id3=s.nextInt();
	             System.out.println("Enter new attendance of student");
	    	     int at2=s.nextInt();
	             System.out.println("New mark of paper1");
	             int p1=s.nextInt();
	             System.out.println("New mark of paper2");
	     int p2=s.nextInt();
	     System.out.println("New mark of paper3");
	     int p3=s.nextInt();
	     System.out.println("New mark of paper4");
	     int p4=s.nextInt();
	     System.out.println("New mark of paper5");
	     int p5=s.nextInt();
	     int tot=p1+p2+p3+p4+p5;
	     System.out.println(tot);
	     
	     Statement sta3=con.getConnection().createStatement();
	     ResultSet r5=sta3.executeQuery("select * from addstud");
	     int f=0;
	     while(r5.next())
	     {
	     if(r5.getInt(1)==id3)
	     {
	    f=1;  
	     }
	     }
	                      if(f==1);
	                      {
	              PreparedStatement ps2=(PreparedStatement)con.getConnection().prepareStatement("update addstud set Attendance=?,Paper1=?,Paper2=?,Paper3=?,Paper4=?,Paper5=?,Total_marks=? where Student_id=?");
	             
	              ps2.setInt(1,at2);
	              ps2.setInt(2,p1);
	                   ps2.setInt(3,p2);
	                   ps2.setInt(4,p3);
	                   ps2.setInt(5,p4);
	                   ps2.setInt(6,p5);
	                   
	                   ps2.setInt(7,tot);
	                   ps2.setInt(8, id3);
	                   ps2.executeUpdate();
	                   con.getConnection().close();
	                   
	                   System.out.println("updated successfully");
	                      }
	                      con.getConnection().close();
	          break;
	    case 4:
	    Statement st3=con.getConnection().createStatement();
	    ResultSet r6=st3.executeQuery("select * from addstud ");
	    while(r6.next())
	    {
	    System.out.println("##########List of Students #########");
	    System.out.println("Student ID ->"+r6.getInt(1));//print value
	    System.out.println("Department ->"+r6.getString(3));
	    }
	    System.out.println("Enter the id to be deleted");
	    int id4=s.nextInt();
	    ResultSet r7=st3.executeQuery("select * from addstud ");
	    while(r7.next())
	     {
	     if(r7.getInt(1)==id4)
	     {  
	    PreparedStatement ps3=(PreparedStatement)con.getConnection().prepareStatement("delete from addstud where Student_id = ?");//delete statement  
	        ps3.setInt(1,id4);
	    ps3.executeUpdate();
	     
	    con.getConnection().close();
	    System.out.println("deleted successfully");
	     }
	     else
	     {
	    System.out.println("Please check the student id");
	     }
	     }
	    break;
	     
	    case 5:
	    System.out.println("Staff account Logout");
	    Collegeapp college=new Collegeapp();
		college.choice();
	    break;
	    }
	   
	    }while(n!=0);
	   }
	   else {
		   System.out.println("Not Verified");
		   Collegeapp college=new Collegeapp();
			college.choice();
	   }
	   }

	}

}
