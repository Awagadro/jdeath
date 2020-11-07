package jdeath.awagadro.daoJdbc.dao;

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
	public static final String SQL_SELECT_USER_BY_SURNAME = "SELECT user_id,name FROM user WHERE sur_name =?";
	public static final String SQL_DELETE_USER_BY_ID = "delete from user where user_id=?";
	public static final String SQL_CREATE_NEW_USER = "INSERT INTO user (name, sur_name) VALUES(?,?)";

	@Override
	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		Connection con = null;
		Statement st = null;
		System.out.println("findAll() started");

		try {
			con = ConnectorDB.getConnection();
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
		boolean flag = false;
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("delete by id started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_DELETE_USER_BY_ID);
			st.setObject(1, id);
			st.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}
		return flag;
	}

	@Override
	public boolean delete(User entity) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("delete(entity) started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_DELETE_USER_BY_ID);
			st.setObject(1, entity.getId());
			st.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}
		return flag;
	}

	@Override
	public User create(User entity) {
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("create(entity) started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_CREATE_NEW_USER, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, entity.getName());
			st.setString(2, entity.getSurName());
			st.executeUpdate();
			final ResultSet rs = st.getGeneratedKeys();
			rs.next();
			final int id = rs.getInt(1);
			entity.setId(id);

		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}

		return entity;

	}

	@Override
	public List<User> create(List<User> entityList) {
		List<User> users = new ArrayList<User>();

		for (User entity : entityList) {
			User user = create(entity);
			users.add(user);
		}
		return users;
	}

	@Override
	public User update(User entity) {
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
			st = con.prepareStatement(SQL_SELECT_USER_BY_SURNAME);
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
