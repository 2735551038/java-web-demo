package com.asingna.mvcapp.dao.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtil {
	
	private static DataSource dataSource = null;
	
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	public static void releaseConnection(Connection connection) {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
}