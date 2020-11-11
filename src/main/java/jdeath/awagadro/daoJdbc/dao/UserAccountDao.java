package jdeath.awagadro.daoJdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdeath.awagadro.daoJdbc.entity.UserAccount;
import jdeath.awagadro.daoJdbc.utils.ConnectorDB;

public class UserAccountDao extends AbstractDao<Integer, UserAccount> {

	public static final String SQL_SELECT_ALL_ACCOUNTS = "SELECT * FROM user_account";
	public static final String SQL_SELECT_ACCOUNTS_OF_ONE_USER = "SELECT id, account FROM user_account WHERE user_id =?"; // specific
	// method
	// (optional)
	public static final String SQL_SELECT_ACCOUNT_BY_ID = "SELECT account, user_id FROM user_account WHERE id =?";
	public static final String SQL_DELETE_ACCOUNT_BY_ID = "delete from user_account where id=?";
	public static final String SQL_CREATE_NEW_ACCOUNT = "INSERT INTO user_account (account, user_id) VALUES(?,?)";
	public static final String SQL_UPDATE_ACCOUNT = "UPDATE user_account SET account=?, user_id=? WHERE id=?";

	@Override
	public List<UserAccount> findAll() {
		// throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
		List<UserAccount> uAccounts = new ArrayList<UserAccount>();
		Connection con = null;
		Statement st = null;
		System.out.println("findAll() started");

		try {
			con = ConnectorDB.getConnection();
			st = con.createStatement();
			ResultSet rs = st.executeQuery(SQL_SELECT_ALL_ACCOUNTS);
			while (rs.next()) {
				UserAccount uAccount = new UserAccount();
				uAccount.setId(rs.getInt("id"));
				uAccount.setAccount(rs.getInt("account"));
				uAccount.setUserId(rs.getInt("user_id"));
				uAccounts.add(uAccount);
			}
		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}
		return uAccounts;
	}

	public List<UserAccount> findAccountsForUser(Integer userId) {
		List<UserAccount> uAccounts = new ArrayList<UserAccount>();
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("findAccountsForUser() started");

		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_SELECT_ACCOUNTS_OF_ONE_USER);
			st.setObject(1, userId);
			st.execute();

			final ResultSet rs = st.getResultSet();
			while (rs.next()) {
				UserAccount uAccount = new UserAccount();
				uAccount.setId(rs.getInt("id"));
				uAccount.setAccount(rs.getInt("account"));
				uAccount.setUserId(rs.getInt("user_id"));
				uAccounts.add(uAccount);
			}
		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}
		return uAccounts;
	}

	@Override
	public UserAccount findById(Integer id) {
		UserAccount uAccount = new UserAccount();
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("find by id started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_SELECT_ACCOUNT_BY_ID);
			st.setObject(1, id);
			st.execute();

			final ResultSet rs = st.getResultSet();
			rs.next();
			uAccount.setId(id);
			uAccount.setAccount(rs.getInt("account"));
			uAccount.setUserId(rs.getInt("user_id"));

		} catch (SQLException e) {
			System.err.println("SQLException (request failed): " + e);

		} catch (ClassNotFoundException e) {
			System.err.println("ClassNotFoundException (driver load failed): " + e);
			e.printStackTrace();
		} finally {
			close(st);
		}

		return uAccount;
	}

	@Override
	public boolean delete(Integer id) {
		boolean flag = false;
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("delete by id started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_DELETE_ACCOUNT_BY_ID);
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
	public UserAccount create(UserAccount entity) {
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("create(entity) started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_CREATE_NEW_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, entity.getAccount());
			st.setObject(2, entity.getUserId());
			st.executeUpdate();
			final ResultSet rs = st.getGeneratedKeys();
			rs.next();
			final int id = rs.getInt("id"); // alternative put column index 1
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
	public List<UserAccount> create(List<UserAccount> entityList) {
		Connection con = null;
		PreparedStatement st = null;
		List<UserAccount> uAccounts = new ArrayList<UserAccount>();
		System.out.println("create(entities...) started");
		try {
			con = ConnectorDB.getConnection();
			con.setAutoCommit(false); // transaction mode
			try { // transaction mode
				st = con.prepareStatement(SQL_CREATE_NEW_ACCOUNT, Statement.RETURN_GENERATED_KEYS);
				for (UserAccount entity : entityList) {
					st.setInt(1, entity.getAccount());
					st.setInt(2, entity.getUserId());
					st.addBatch();
					uAccounts.add(entity);
				}
				st.executeBatch();
				con.commit();// transaction mode
			} catch (Exception e) {
				con.rollback();
				System.out.println("Transaction failed");
				throw new RuntimeException(e);
			} // transaction mode

			final ResultSet rs = st.getGeneratedKeys();

			for (UserAccount user : uAccounts) {
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

		return uAccounts;
	}

	@Override
	public UserAccount update(UserAccount entity) {
		Connection con = null;
		PreparedStatement st = null;
		System.out.println("update(entity) started");
		try {
			con = ConnectorDB.getConnection();
			st = con.prepareStatement(SQL_UPDATE_ACCOUNT);
			st.setInt(1, entity.getAccount());
			st.setInt(2, entity.getUserId());
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

}
