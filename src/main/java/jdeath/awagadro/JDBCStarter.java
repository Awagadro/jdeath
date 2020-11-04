package jdeath.awagadro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCStarter {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/bank_list";
		Properties prop = new Properties();
		prop.put("user", "mysql");
		prop.put("password", "root");
		prop.put("autoReconnect", "true");
		prop.put("characterEncoding", "UTF-8");
		prop.put("useUnicode", "true");

		Connection cn = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			cn = DriverManager.getConnection(url, prop);
			Statement st = null;

			try {
				st = cn.createStatement();
				ResultSet rs = null;
				try {
					rs = st.executeQuery("SELECT * FROM user");
					List<User> users = new ArrayList<User>();
					while (rs.next()) {
						int id = rs.getInt(1);
						String name = rs.getString(2);
						String surName = rs.getString(3);
						users.add(new User(id, name, surName));
					}
					if (users.size() > 0) {
						System.out.println(users);
					} else {
						System.out.println("Not Found");
					}
				} finally {
					if (rs != null) {
						rs.close();
					} else {
						System.out.println("Ошибка во время чтения из базы");
					}
				}
			} finally {
				if (st != null) {
					st.close();
				} else {
					System.out.println("Statement не создан");
				}
			}
		} catch (SQLException e) {
			System.err.println("DB connection error: " + e);
		} finally {
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					System.err.println("connection close error: " + e);
				}
			}
		}

	}
}
