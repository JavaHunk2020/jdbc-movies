package com.main;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

import com.dao.MovieDao;
import com.dao.MovieDaoImpl;
import com.dao.entity.MovieEntity;

public class UpdateMovie {
	public static void main(String[] args) {
		try {
			
			MovieDao movieDao = new MovieDaoImpl();
			movieDao.findAll().forEach(System.out::println);

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter name");
			String name = scanner.next();

			System.out.println("Enter year");
			int year = scanner.nextInt();

			System.out.println("Enter budget");
			Long budget = scanner.nextLong();

			MovieEntity entity = new MovieEntity(0, name, year, 0, budget, 0, null);
			
			movieDao.update(entity);
			System.out.println("Record is updated");
			System.out.println("Now new status");
			movieDao.findAll().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
