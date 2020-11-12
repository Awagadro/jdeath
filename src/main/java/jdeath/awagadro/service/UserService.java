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
		return dao.findById(id);
	}

	public List<User> getAll() {
		return dao.findAll();
	}

	public User save(User entity) {
		return dao.create(entity);
	}

	public List<User> save(List<User> entityList) {
		return dao.create(entityList);
	}

	public boolean delete(Integer id) {
		return dao.delete(id);
	}

	public boolean deleteAll() {
		return dao.deleteAll();
	}

	public User update(User entity) {
		return dao.update(entity);
	}

	public User find(String surName) { // optional
		return dao.findUserBySUrName(surName);
	}

}
