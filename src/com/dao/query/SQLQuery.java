package com.dao.query;

public interface SQLQuery {
	public static String DELETE_MOVIE_BY_NAME="delete from movie_tbl where name = ?";
	public static String INSERT_MOVIE="insert into movie_tbl(name,year,rating,budget,teams,createdate) values(?,?,?,?,?,?)";
	public static String UPDATE_MOVIE="update movie_tbl set year =?, budget=?  where name =?";
	public static String SELECT_ALL_MOVIE="select mid,name,year,rating,budget,teams,createdate from movie_tbl";
}
