package bankPackage;


import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Operations {
	static Scanner sc=new Scanner(System.in);
	static int accnum;
	static long balance;
    public static void createAcc() {
    	try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","Kalyani@123");
			 Statement st=con.createStatement();
			 Scanner sc=new Scanner(System.in);
			 System.out.println("*** Enter Account Details ***");
			 System.out.println("Enter Account Number");
			 accnum=sc.nextInt();
			 System.out.println("Enter First Name");
			 String fName=sc.next();
			 System.out.println("Enter Last Name");
			 String lName=sc.next();
			 System.out.println("Enter Gender (f/m)");
			 String gender=sc.next();
			 System.out.println("Enter Age");
			 int age=sc.nextInt();
			 System.out.println("Enter Phone Number");
			 String phonenum=sc.next();
			 System.out.println("Enter Address");
			 String address=sc.next();
			 System.out.println("Enter Amount");
			 balance=sc.nextLong();
			 String sql="insert into secure_bank values("+accnum+",'"+fName+"','"+lName+"','"+gender+"',"+age+",'"+phonenum+"','"+address+"','"+balance+"')";
			 st.executeUpdate(sql);
			 System.out.println("Yours Account Created Successfully");
			 System.out.println("**".repeat(30));
			 
			 
			 
		}
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
				
		 catch(Exception e) {
			 System.out.println(e);
			 System.out.println("**".repeat(30));
		 }
	
		
	}
    public static void deposit() {
		int acc;
		long bal=0;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","Kalyani@123");
			 Statement st=con.createStatement();
			 Scanner sc=new Scanner(System.in);
			 
			 System.out.println("Enter Account Number ");
			 acc=sc.nextInt();
			 System.out.println("Enter Deposit Amount");
			 bal=sc.nextLong();
			 if(bal<=0) {
				 System.out.println("Deposited Amount Should be Greater than 0 ");
				 System.out.println("**".repeat(30));
			     
			 }
			 else {
				 String sql="select balance from secure_bank where accno="+acc+" "; 
				 ResultSet rs=st.executeQuery(sql);
				  if(rs.next()){
					 Long prevbalance=(long) rs.getInt("balance");
					
					 Long currentbal=prevbalance+bal;
					 String newBalanceQuery="update secure_bank set balance="+currentbal+" where accno="+acc+" ";
					 st.executeUpdate(newBalanceQuery);
					 System.out.println("Deposit Sccussfully");
					 System.out.println("Your Current Balance is : "+ currentbal); 
				 }
				  else {
						 System.out.println("Account Number Incorrect");
						 
					 }
			 }
			 System.out.println("-".repeat(30));
			 
		}
		catch(InputMismatchException e) {
			System.out.println("Enter Valid Input");
		}
		
		 catch(Exception e) {
			 System.out.println(e);
			 System.out.println("**".repeat(30));
			 
		 }
    }
		public static void withdraw() {
		   // int acct;
			Long witha;
		
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","Kalyani@123");
				 Statement st=con.createStatement();
				 System.out.println("Enter Account Number ");
				 accnum=sc.nextInt();
				 System.out.println("Enter Withdraw  Amount");
				 witha=sc.nextLong();
				 if(witha<=0) {
					 System.out.println("Withdraw Amount Should be greater than 0");
				     
				 }
				 else {
					 String sql="select balance from secure_bank where accno="+accnum+" "; 
					 ResultSet rs=st.executeQuery(sql);
					  if(rs.next()){
						 Long prevbalance=(long) rs.getInt("balance");
						 if(prevbalance<witha) {
							 System.out.println("Your Amount not Sufficent to Withdraw");
							 
						 }
						 else {
							 Long currentbal=prevbalance-witha;
							 String updatedbal="update secure_bank set balance="+currentbal+" where accno="+accnum+" ";
							 st.executeUpdate(updatedbal);
							 System.out.println("Withdraw Sccussfully");
							 System.out.println("Your Current Balance is : "+ currentbal);
							 
							 
						 } 
					 }
					  else {
							 System.out.println("Account Number Incorrect");
							 
						 }
	 
				 }
				 System.out.println("-".repeat(30));
				 }
			catch(InputMismatchException e) {
				System.out.println("Enter Valid Input");
			}
			catch(Exception e) {
					 System.out.println(e);
					 
			}	 		 
		}
		
		public static void checkBalance() {
		       Long viewbal;
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","Kalyani@123");
				 Statement st=con.createStatement();
				 System.out.println("Enter Account Number ");
				 accnum=sc.nextInt();
				 String sql="select * from secure_bank where accno="+accnum+" "; 
				 ResultSet rs=st.executeQuery(sql);
				 if(rs.next()) {
					 System.out.println("Name     : "+( rs.getString(2)+" "+rs.getString(3))+"\n"+"Balance  :"+" "+rs.getString(8));
					 
				 }
				 System.out.println("-".repeat(30));
				 
			}
			catch(InputMismatchException e) {
				System.out.println("Enter Valid Input");
			}catch(Exception e) {
				System.out.println(e);
			}
			
		}
		
		public static void diplayAccountholerDetails() {
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","Kalyani@123");
				 Statement st=con.createStatement();
				 System.out.println("Enter Account Number ");
				 accnum=sc.nextInt();
				 String sql="select * from secure_bank where accno="+accnum+" "; 
				 ResultSet rs=st.executeQuery(sql);
				 if(rs.next()) {
					 System.out.println("Account Number  : "+rs.getString(1)+"\n"+"Name"+" ".repeat(12)+": "+(rs.getString(2)+" "+rs.getString(3))+"\n"+"Gender"+" ".repeat(10)+": "+rs.getString(4)+"\n"+"Age"+" ".repeat(13)+": "+rs.getString(5)+"\n"+"Phone Number"+" ".repeat(4)+": "+rs.getString(6)+"\n"+"Balance"+" ".repeat(9)+": "+rs.getString(8)+"\n"+"Address"+" ".repeat(9)+": "+rs.getString(7)+" ");
					 
				 } 
				 else {
					 System.out.println("Your Account Not Found");
				 }
				 System.out.println("-".repeat(30));
				 
			}
			catch(InputMismatchException e) {
				System.out.println("Enter Valid Input");
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		public static void closeAccount() {
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankproject","root","Kalyani@123");
				 Statement st=con.createStatement();
				 System.out.println("Enter Account Number ");
				 accnum=sc.nextInt();
				 String sqls="select fname from secure_bank where accno="+accnum+" "; 
				 ResultSet getname=st.executeQuery(sqls);
				 if(getname.next()) {
					 String s="delete from secure_bank where accno="+accnum+" ";
					  st.executeUpdate(s);
					  System.out.println("Your Account Closed Successfully");
		 
				 }
				 else {
					 System.out.println("Your account doesn't exits");
				 }
				 System.out.println("-".repeat(30));
				 
			}
			catch(InputMismatchException e) {
				System.out.println("Enter Valid Input");
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
			
	
    
}
