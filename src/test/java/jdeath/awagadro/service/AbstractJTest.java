package jdeath.awagadro.service;

public class AbstractJTest {

	public void cleanDB() {
		// clean DB recursive before each test
		UserAccountService userAccountService = new UserAccountService();
		UserService userService = new UserService();

		userAccountService.deleteAll();
		userService.deleteAll();
	}

}
