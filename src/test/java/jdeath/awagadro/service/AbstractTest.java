package jdeath.awagadro.service;

import java.util.Random;

import jdeath.awagadro.daoJdbc.entity.User;

public class AbstractTest {
	protected UserService userService;
	protected UserAccountService userAccountService;

	public void cleanDB() {
		// clean DB recursive before each test
		userAccountService.deleteAll();
		userService.deleteAll();
	}

	public String getRandomPrefix(int high, int low) { // generate random prefix for string
		return new String(new Random().nextInt(high - low) + low + "");
	}

	protected User saveNewUser() {
		User entity = new User();
		entity.setName("User" + getRandomPrefix(1, 100));
		entity.setSurName("SurName" + getRandomPrefix(1, 100));
		userService.save(entity);

		return entity;
	}

}
