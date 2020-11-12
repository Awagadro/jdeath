package jdeath.awagadro.service;

import jdeath.awagadro.daoJdbc.dao.UserAccountDao;
import jdeath.awagadro.daoJdbc.dao.UserDao;

public class AbstractJTest {
	protected UserService userService;
	protected UserAccountService userAccountService;

	public void cleanDB() {
		// clean DB recursive before each test
		UserAccountService userAccountService = new UserAccountService(new UserAccountDao());
		UserService userService = new UserService(new UserDao());

		userAccountService.deleteAll();
		userService.deleteAll();
	}

}
