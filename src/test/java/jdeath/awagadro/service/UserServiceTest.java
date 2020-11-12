package jdeath.awagadro.service;

import jdeath.awagadro.daoJdbc.entity.User;

public class UserServiceTest extends AbstractTest {

//	@Test
	public void testCreate() {
		cleanDB(); // before each test

		final User entity = saveNewUser();
		final User entityFromDb = userService.get(entity.getId());

//		 assertNotNull(entityFromDb);
//	     assertEquals(entity.getName(), entityFromDb.getName());

	}

}
