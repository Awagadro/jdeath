package jdeath.awagadro.service;

import java.util.List;

import jdeath.awagadro.daoJdbc.dao.UserDao;
import jdeath.awagadro.daoJdbc.entity.User;

public class UserService {

	private UserDao getDao() {
		return new UserDao();
	}

	public UserService() {
	}

	public User get(Integer id) {
		return getDao().findById(id);
	}

	public List<User> getAll() {
		return getDao().findAll();
	}

	public User save(User entity) {
		return getDao().create(entity);
	}

	public List<User> save(List<User> entityList) {
		return getDao().create(entityList);
	}

	public boolean delete(Integer id) {
		return getDao().delete(id);
	}

	public boolean deleteAll() {
		return getDao().deleteAll();
	}

	public User update(User entity) {
		return getDao().update(entity);
	}

	public User find(String surName) { // optional
		return getDao().findUserBySUrName(surName);
	}

}
