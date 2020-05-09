package com.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import com.dao.MovieDao;
import com.dao.MovieDaoImpl;
import com.dao.entity.MovieEntity;

public class SaveMovie {
	public static void main(String[] args) {
		try {
			
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
			
			LocalDateTime  localDate=LocalDateTime.of(2020,07, 20,12,12,12);
			Timestamp timestamp = Timestamp.valueOf(localDate);
			
		    MovieEntity entity=new MovieEntity(0, name, year, rating, budget, teams, timestamp);
			MovieDao movieDao=new MovieDaoImpl();
			movieDao.save(entity);
		    System.out.println("Ahahah data is saved into database");	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
