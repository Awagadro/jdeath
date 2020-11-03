package jdeath.awagadro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHelper {
	private final static String SQL_INSERT = "INSERT INTO user (name, sur_name) VALUES(?,?)";
	private Connection connect;

	public DataBaseHelper() throws SQLException {
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
			ps.setString(2, u.getName());
			ps.setString(3, u.getSurName());
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
