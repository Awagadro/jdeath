package jdeath.awagadro.daoJdbc.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdeath.awagadro.daoJdbc.entity.User;

public class DataBaseHelper {
	private final static String SQL_INSERT = "INSERT INTO user (name, sur_name) VALUES(?,?)";
	private Connection connect;

	public DataBaseHelper() throws SQLException, ClassNotFoundException {
		System.out.println("DB Helper started");
		connect = ConnectorDB.getConnection();
	}

	public PreparedStatement getPreparedStatement() {
		PreparedStatement ps = null;
		try {
			ps = connect.prepareStatement(SQL_INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public boolean insertUser(PreparedStatement ps, User u) {
		boolean flag = false;
		try {
			// ps.setInt(1, u.getUserId());
			ps.setString(1, u.getName());
			ps.setString(2, u.getSurName());
			ps.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public void closeStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
