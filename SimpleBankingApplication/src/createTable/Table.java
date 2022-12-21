package createTable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

public class Table {

	public static void main(String[] args) {
		try {
			//creating a connection
			String DB_URL = "jdbc:mysql://localhost/bankProject";
			String USER = "root";
			String PASS = "Kalyani@123";
			Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			//create query
			String q="CREATE TABLE secure_bank(accno int not null primary key,fname varchar(50) not null,lname varchar(50) not null ,gender char not null,age int(3) , phonen varchar(10) not null unique,address varchar(100),balance BIGINT(255) DEFAULT 0 CHECK(balance>=0) )";
			//create a statement
			Statement stmt=conn.createStatement();
			stmt.executeUpdate(q);
			System.out.println("Table Successfully Created");
		}catch(SQLSyntaxErrorException e) {
			System.out.println("Table already exits");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
