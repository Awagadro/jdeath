package jdeath.awagadro.service;

import java.util.List;

import jdeath.awagadro.daoJdbc.dao.UserAccountDao;
import jdeath.awagadro.daoJdbc.entity.UserAccount;

public class UserAccountService {
	private UserAccountDao dao;

	public UserAccountService(UserAccountDao dao) {
		super();
		this.dao = dao;
	}

	public UserAccount get(Integer id) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public List<UserAccount> getAll() {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public UserAccount save(UserAccount entity) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public List<UserAccount> save(List<UserAccount> users) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public boolean delete(Integer id) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public UserAccount update(UserAccount entity) {
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}

	public List<UserAccount> find(Integer userId) { // optional
		throw new UnsupportedOperationException(); // post this if the body of the
		// method is empty
	}
}
