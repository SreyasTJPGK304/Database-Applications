package CollegeManagementSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Shoppingapplication.Connectionshopping;

public class Superdmin {

	Collegemanager con=new Collegemanager();
	


	public void sadminData() throws SQLException, ClassNotFoundException {
		Scanner s=new Scanner(System.in);
		System.out.println("Admin Login");
		System.out.println("Enter Username");
		String username=s.next();
		System.out.println("Enter Password");
		String password=s.next();
		int n,c=0,total=0,t = 0;
		Statement st=(Statement)con.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select * from admin");
		while(rs.next()) {
			if((rs.getString(1).equals(username)) && (rs.getString(2).equals(password))) {
				System.out.println("Successfully Verified");
				do {
				System.out.println("1)addstaff\n2)Viewstaff / Viewstudent\n3)Updatestaff\n4)Deletestaff\n5)LogOut");
				System.out.println("Enter the choice");
				n=s.nextInt();
				switch(n) {
				case 1:
					System.out.println("Add Staff");
					System.out.println();
					System.out.println("Enter Staff id");
					int id=s.nextInt();
					System.out.println("Enter Staff Name");
					String name=s.next();
					System.out.println("Enter Department");
					String dep=s.next();
					System.out.println("Enter Attendance");
					int at=s.nextInt();
					System.out.println("Enter Basic Salary");
					int salary=s.nextInt();
					PreparedStatement ps=con.getConnection().prepareStatement("insert into staffadd (Staff_id,Staff_name,Department,Attendance,Basic_salary) values(?,?,?,?,?);");
					ps.setInt(1,id);
					ps.setString(2, name);
					ps.setString(3, dep);
					ps.setInt(4, at);
					ps.setInt(5, salary);
					ps.executeUpdate();
					con.getConnection().close();
					System.out.println("Data Saved");
					break;
					
				case 2:
					do {
					System.out.println("1)View Staff\n2)View Student\n3)Exit");
					System.out.println("Enter the choice");
					 c=s.nextInt();
					
					if(c==1) {
					
					System.out.println("Staff Details");
					System.out.println("-------------");
					
					Statement st1=(Statement)con.getConnection().createStatement();
					ResultSet rs1=st1.executeQuery("select * from staffadd");
					while(rs1.next()) {
						System.out.println("Staff id ->  "+rs1.getInt(1));
						System.out.println("Staff Name ->  "+rs1.getString(2));
						System.out.println("Staff Department ->  "+rs1.getString(3));
						System.out.println("Attendance ->  "+rs1.getInt(4));
						System.out.println("Basic Salary -> "+rs1.getInt(5));
						int sa=rs1.getInt(5);
						int f=sa*rs1.getInt(4);
						System.out.println("Salary ->  "+f);
						System.out.println("****************************");
					
					}
					
					}
					
					
					else if(c==2) {
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
						
						
						
					}
					
					 if(c==3) {
						System.out.println("Exit");
						break;
					}
					}while(c!=0);
					con.getConnection().close();
					break;
					
				case 3:
					
					Statement st2=(Statement) con.getConnection().createStatement();
					ResultSet rs2=st2.executeQuery("select * from staffadd");
					while(rs2.next()) {
						System.out.println("Staff ID->  "+rs2.getInt(1)+" "+"\nStaff Name ->  "+rs2.getString(2)+" "+"\nStaff Department ->  "+rs2.getString(3)+" "+"\nNo of days present ->  "+rs2.getInt(4)+" "+"\nSalary ->  "+rs2.getString(5)+" ");
						System.out.println("*********************************");
						con.getConnection().close();
					}
					
					
					System.out.println("Enter the staff id");
					int nid=s.nextInt();
					System.out.println("Enter the No.of days Present");
					int prs=s.nextInt();
					Statement st3=con.getConnection().createStatement();
					ResultSet rs3=st3.executeQuery("select Basic_salary from staffadd where Staff_id="+nid);
				    while(rs3.next())
				    {
				    	int d=rs3.getInt(1);
				    	t=d*prs;
				    }
				    PreparedStatement pst1=con.getConnection().prepareStatement("update staffadd set Attendance=?,Salary=? where Staff_id=?");
					pst1.setInt(1,prs);
				    pst1.setInt(2,t);
					pst1.setInt(3,nid);
					pst1.executeUpdate();
                    System.out.println("Updated successfully");
					break;
					
				case 4:
					
					Statement st5=con.getConnection().createStatement();
				    ResultSet r6=st5.executeQuery("select * from staffadd ");
				    while(r6.next())
				    {
				    System.out.println("##########List of Staff #########");
				    System.out.println("Staff ID ->"+r6.getInt(1));//print value
				    System.out.println("Department ->"+r6.getString(3));
				    }
				    System.out.println("Enter the id to be deleted");
				    int id4=s.nextInt();
				    ResultSet r7=st5.executeQuery("select * from staffadd ");
				    while(r7.next())
				     {
				     if(r7.getInt(1)==id4)
				     {  
				    PreparedStatement ps3=(PreparedStatement)con.getConnection().prepareStatement("delete from staffadd where Staff_id = ?");//delete statement  
				        ps3.setInt(1,id4);
				    ps3.executeUpdate();
				     
				    
				    System.out.println("deleted successfully");
				     }
				   // con.getConnection().close();
				     }  
				    break;
					
				   // con.getConnection().close();
				    
				case 5:
					System.out.println("Successfully LogOut");
					Collegeapp college=new Collegeapp();
					college.choice();
				    	
					}
					
				
				
					
					
				
				}while(n!=0);
				}
			else {
				System.out.println("Verification Failed");
				
				 Collegeapp college=new Collegeapp();
					college.choice();
			}
			}
			
		}
		
			

		}	


