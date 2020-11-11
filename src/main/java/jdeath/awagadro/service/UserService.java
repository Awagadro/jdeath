package jdeath.awagadro.service;

import java.util.List;

import jdeath.awagadro.daoJdbc.dao.UserDao;
import jdeath.awagadro.daoJdbc.entity.User;

public class UserService {
	private UserDao dao;

	public UserService(UserDao dao) {
		super();
		this.dao = dao;
	}

	public User get(Integer id) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public List<User> getAll() {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public User save(User entity) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public List<User> save(List<User> users) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public boolean delete(Integer id) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public User update(User entity) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public User find(String sur_name) { // optional
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

}
