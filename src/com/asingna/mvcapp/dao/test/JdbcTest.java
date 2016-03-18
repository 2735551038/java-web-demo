package com.asingna.mvcapp.dao.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.asingna.mvcapp.dao.db.JdbcUtil;

public class JdbcTest {

	@Test
	public void testJdbc() throws SQLException {
		Connection connection = JdbcUtil.getConnection();
		System.out.println(connection);
	}
}
