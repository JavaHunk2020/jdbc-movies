package com.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class SaveMovie {
	public static void main(String[] args) {
		try {
			  //Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			//Creating connection to the database
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","mysql@1234");
			if(connection!=null)  {
				System.out.println("Connection is created!!!!!!!!!!!");
			}
			
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter name");
			String name=scanner.next();
			System.out.println("Enter year");
			int year=scanner.nextInt();
			
			System.out.println("Enter rating");
			int rating=scanner.nextInt();
			
			System.out.println("Enter budget");
			Long budget=scanner.nextLong();
			
			System.out.println("Enter teams");
			int teams=scanner.nextInt();
			
			Date date=new Date();
			Timestamp timestamp=new Timestamp(date.getTime());
			
			String sql="insert into movie_tbl(name,year,rating,budget,teams,createdate) values(?,?,?,?,?,?)";
			//Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt=connection.prepareStatement(sql);
			
			//setting the values inside PreparedStatement object
			pstmt.setString(1,name);
			pstmt.setInt(2,year);
			pstmt.setInt(3,rating);
			pstmt.setBigDecimal(4,new BigDecimal(budget));
			pstmt.setInt(5,teams);
			pstmt.setTimestamp(6,timestamp);
			//Fire the query
		    pstmt.execute();
		    
		    System.out.println("Ahahah data is saved into database");	
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
