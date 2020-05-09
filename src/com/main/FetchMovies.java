package com.main;

import com.dao.MovieDao;
import com.dao.MovieDaoImpl;

public class FetchMovies {
	public static void main(String[] args) {
		try {
			MovieDao movieDao=new MovieDaoImpl();
			movieDao.findAll().forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
