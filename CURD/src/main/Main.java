package main;
import java.sql.*;
import java.util.*;
public class Main {
public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
		
		Connection conn = null;
		Statement stmt = null; 
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/curd";
		try{
		
		conn = DriverManager.getConnection(url,"root", "root");
		System.out.println("connection is established");
		stmt = conn.createStatement();
		stmt.execute("CREATE TABLE student(roll INTEGER PRIMARY KEY, name VARCHAR(30), class INTEGER, section VARCHAR(3), Marks INTEGER)");
		System.out.println("table created succesfully");
		stmt.execute("INSERT INTO student VALUES(1,'amit',10,'A',90)");
		stmt.execute("INSERT INTO student VALUES(2,'lokesh',10,'A',100)");
		System.out.println("inserted succesfully");
	    stmt.execute("UPDATE student set marks=95 where roll=1");
		String str = "select * from student";
		boolean b = stmt.execute(str);
		if(b==true){
		rs = stmt.getResultSet();
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
		}
		}
		ystem.out.println("updated succesfully");
		stmt.execute("DELETE FROM student where roll=1");
		System.out.println("deleted succesfully");
		}
		catch (Exception e){
			System.out.println("cannot connect to the database");
			System.out.println(e);
		}
}
}
