package jdeath.awagadro.service;

import java.util.List;

import jdeath.awagadro.daoJdbc.dao.UserAccountDao;
import jdeath.awagadro.daoJdbc.entity.UserAccount;

public class UserAccountService {

	private UserAccountDao getDao() {
		return new UserAccountDao();
	}

	public UserAccountService() {
	}

	public UserAccount get(Integer id) {
		return getDao().findById(id);
	}

	public List<UserAccount> getAll() {
		return getDao().findAll();
	}

	public UserAccount save(UserAccount entity) {
		return getDao().create(entity);
	}

	public List<UserAccount> save(List<UserAccount> entityList) {
		return getDao().create(entityList);
	}

	public boolean delete(Integer id) {
		return getDao().delete(id);
	}

	public boolean deleteAll() {
		return getDao().deleteAll();
	}

	public UserAccount update(UserAccount entity) {
		return getDao().update(entity);
	}

	public List<UserAccount> find(Integer userId) { // optional
		return getDao().findAccountsForUser(userId);
	}
}
