package jdeath.awagadro.daoJdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import jdeath.awagadro.daoJdbc.entity.AbstractEntity;

public abstract class AbstractDao<K, T extends AbstractEntity> {
	public abstract List<T> findAll();

	public abstract T findEntityById();

	public abstract boolean delete(K id);

	public abstract boolean delete(T entity);

	public abstract boolean create(T entity);

	public abstract boolean update(T entity);

	public void close(Statement st) {
		try {
			if (st != null) {
				st.close();
			}
		} catch (SQLException e) {
			System.out.println("Statement wasn't closed");
		}
	}

	public void close(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Statement wasn't closed");
		}
	}
}
