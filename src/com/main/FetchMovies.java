package com.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FetchMovies {
	public static void main(String[] args) {
		try {
			  //Loading the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			//Creating connection to the database
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/movie_db","root","mysql@1234");
			if(connection!=null)  {
				System.out.println("Connection is created!!!!!!!!!!!");
			}
			String sql="select mid,name,year,rating,budget,teams,createdate from movie_tbl";
			//Compiling query and assigning into PreparedStatement object
			PreparedStatement pstmt=connection.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			List<MovieEntity> movies=new ArrayList<>();
			while(rs.next()) {
		           int mid= rs.getInt(1);
		           String name= rs.getString(2);
		           int year= rs.getInt(3);
		           int rating= rs.getInt(4);
		           BigDecimal budget= rs.getBigDecimal(5);
		           int teams= rs.getInt(5);
		           Timestamp createDate= rs.getTimestamp(6);
		           MovieEntity entity=new MovieEntity(mid, name, year, rating, budget.longValue(), teams, createDate);
		           movies.add(entity);
		}
		    System.out.println("Ahahah data is saved into database");
		    
		    movies.forEach(System.out::println);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
