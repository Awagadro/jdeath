package jdeath.awagadro.daoJdbc.pool;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	private final static String DATASOURCE_NAME = "jdbc/bank_list";
	private static DataSource ds;
	static {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup(DATASOURCE_NAME);

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private ConnectionPool() {}
	public static Connection getConnection() throws SQLException {
		Connection con = ds.getConnection();
		return con;
	}
		
// метод возвращения connection в пул
	
}
