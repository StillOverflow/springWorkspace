package com.example.demo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class SpringBootTest {
	DataSource dataSource;
	public void test() {
		try (Connection conn = dataSource.getConnection()) {
			System.out.println(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
