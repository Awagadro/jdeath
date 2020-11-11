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
	public static final String SQL_SELECT_USER_BY_SURNAME = "SELECT id, name FROM user WHERE sur_name =?"; // specific
																											// method
																											// (optional)
	public static final String SQL_SELECT_USER_BY_ID = "SELECT sur_name, name FROM user WHERE id =?";
	public static final String SQL_DELETE_USER_BY_ID = "delete from user where id=?";
	public static final String SQL_CREATE_NEW_USER = "INSERT INTO user (name, sur_name) VALUES(?,?)";
	public static final String SQL_UPDATE_USER = "UPDATE user SET name=?, sur_name=? WHERE id=?";

	@Override
	public List<User> findAll() {
		// throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
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
				user.setId(rs.getInt("id"));
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
		Connection con = null;
		PreparedStatement st = null;
		List<User> users = new ArrayList<User>();
		System.out.println("create(entities...) started");
		try {
			con = ConnectorDB.getConnection();
			con.setAutoCommit(false); // transaction mode
			try { // transaction mode
				st = con.prepareStatement(SQL_CREATE_NEW_USER, Statement.RETURN_GENERATED_KEYS);
				for (User entity : entityList) {
					st.setString(1, entity.getName());
					st.setString(2, entity.getSurName());
					st.addBatch();
					users.add(entity);
				}
				st.executeBatch();
				con.commit();// transaction mode
			} catch (Exception e) {
				con.rollback();
				System.out.println("Transaction failed");
				throw new RuntimeException(e);
			} // transaction mode

			final ResultSet rs = st.getGeneratedKeys();

			for (User user : users) {
				rs.next(); // попробовать вынести за цикл
				final int id = rs.getInt(1);
				user.setId(id);
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
	public User update(User entity) {
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("update(entity) started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_UPDATE_USER);
			st.setString(1, entity.getName());
			st.setString(2, entity.getSurName());
			st.setObject(3, entity.getId());
			st.executeUpdate();

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
	public User findById(Integer id) {
		User user = new User();
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("find by id started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_SELECT_USER_BY_ID);
			st.setObject(1, id);
			st.execute();

			final ResultSet rs = st.getResultSet();
			rs.next();
			user.setId(id);
			user.setName(rs.getString("name"));
			user.setSurName(rs.getString("sur_name"));

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
			user.setId(rs.getInt("id"));
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
