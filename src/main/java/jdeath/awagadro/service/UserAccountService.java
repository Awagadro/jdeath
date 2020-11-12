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
		return dao.findById(id);
	}

	public List<UserAccount> getAll() {
		return dao.findAll();
	}

	public UserAccount save(UserAccount entity) {
		return dao.create(entity);
	}

	public List<UserAccount> save(List<UserAccount> entityList) {
		return dao.create(entityList);
	}

	public boolean delete(Integer id) {
		return dao.delete(id);
	}

	public boolean deleteAll() {
		return dao.deleteAll();
	}

	public UserAccount update(UserAccount entity) {
		return dao.update(entity);
	}

	public List<UserAccount> find(Integer userId) { // optional
		return dao.findAccountsForUser(userId);
	}
}
