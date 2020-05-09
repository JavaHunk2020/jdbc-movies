package com.main;

import java.util.Scanner;

import com.dao.MovieDao;
import com.dao.MovieDaoImpl;

public class DeleteMovie {
	public static void main(String[] args) {
		try {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter name");
			String name=scanner.next();
			MovieDao movieDao=new MovieDaoImpl();
			movieDao.deleteByName(name);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
