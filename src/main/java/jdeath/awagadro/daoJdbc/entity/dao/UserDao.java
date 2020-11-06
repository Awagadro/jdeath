package jdeath.awagadro.daoJdbc.entity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdeath.awagadro.daoJdbc.entity.User;
import jdeath.awagadro.daoJdbc.utils.ConnectorDB;

public class UserDao extends AbstractDao<Integer, User> {
	public static final String SQL_SELECT_ALL_USERS = "SELECT * FROM user";
	public static final String SQL_SELECT_ABONENT_BY_SURNAME = "SELECT user_id,name FROM user WHERE sur_name =?";

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		Connection con = null;
		Statement st = null;

		try {
			con = ConnectorDB.getConnection();
			// con= ConnectionPool.getConnection(); // Blinov
			st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_USERS);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setSurName(rs.getString("sur_name"));
				users.add(user);
			}
		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}
		return users;
	}

	@Override
	public boolean delete(Integer id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean delete(User entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean create(User entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean update(User entity) {
		throw new UnsupportedOperationException();
	}

	@Override
	public User findEntityById() {
		throw new UnsupportedOperationException();
	}

	public User findUserBySUrName(String surName) {
		User user = new User();
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = ConnectorDB.getConnection();
			// con= ConnectionPool.getConnection(); // Blinov
			st = con.prepareStatement(SQL_SELECT_ABONENT_BY_SURNAME);
			st.setString(1, surName);
			ResultSet rs = st.executeQuery();
			rs.next();
			user.setId(rs.getInt("user_id"));
			user.setName(rs.getString("name"));
			user.setSurName(surName);

		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}

		return user;

	}

}
