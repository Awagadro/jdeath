package jdeath.awagadro.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jdeath.awagadro.daoJdbc.entity.User;
import jdeath.awagadro.daoJdbc.entity.UserAccount;

public class UserAccountServiceTest extends AbstractJTest {
	@Test
	public void testCreate() {
		cleanDB(); // before each test
		UserService userService = new UserService();
		UserAccountService userAccountService = new UserAccountService();

		User user = new User(); // create new entity
		user.setName("Michael");
		user.setSurName("Jackson");
		userService.save(user);

		UserAccount entity = new UserAccount(); // create new entity
		entity.setAccount(100);
		entity.setUserId(user.getId());
		userAccountService.save(entity);

		final UserAccount entityFromDb = userAccountService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertTrue(entityFromDb.getAccount() == (entityFromDb.getAccount()));
	}

	@Test
	public void testFindAllAccountsForUser() {
		cleanDB(); // before each test
		UserService userService = new UserService();
		UserAccountService userAccountService = new UserAccountService();

		User user = new User(); // create new entity
		user.setName("Michael");
		user.setSurName("Jackson");
		userService.save(user);

		User user2 = new User(); // create new entity
		user2.setName("Freddy");
		user2.setSurName("Kruger");
		userService.save(user2);

		List<UserAccount> entities = new ArrayList<UserAccount>(); // create many entitities
		for (int i = 0; i < 10; i++) {
			UserAccount entity = new UserAccount(); // create new entity
			entity.setAccount(100);
			entity.setUserId(user.getId());
			entities.add(entity);
		}
		userAccountService.save(entities);

		UserAccount entity = new UserAccount(); // create new entity
		entity.setAccount(100);
		entity.setUserId(user2.getId());
		userAccountService.save(entity);

		final List<UserAccount> entitiesFromDb = userAccountService.find(user.getId());
		int totalSum = 0;
		for (UserAccount userAccount : entitiesFromDb) {
			totalSum = totalSum + userAccount.getAccount();
		}

		final List<UserAccount> allEntitiesFromDb = userAccountService.getAll();

//		assertNotNull(entitiesFromDb);
		assertTrue(entities.size() == (entitiesFromDb.size()));
		assertTrue(totalSum == 1000);
		assertFalse(entitiesFromDb.size() == (allEntitiesFromDb.size()));

	}

}
