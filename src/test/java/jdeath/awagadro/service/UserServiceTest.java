package jdeath.awagadro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import jdeath.awagadro.daoJdbc.entity.User;

public class UserServiceTest extends AbstractJTest {

	@Test
	public void testCreate() {
		cleanDB(); // before each test
		UserService userService = new UserService();

		User entity = new User(); // create new entity
		entity.setName("Michael");
		entity.setSurName("Jackson");

		userService.save(entity);
		final User entityFromDb = userService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getName(), entityFromDb.getName());
		assertTrue(entityFromDb.getId().equals(entityFromDb.getId()));

	}

	@Test
	public void testCreateMultiple() {
		cleanDB(); // before each test
		UserService userService = new UserService();

		List<User> entities = new ArrayList<User>(); // create many entitities
		for (int i = 0; i < 10; i++) {
			User entity = new User();
			entity.setName("UserName" + i);
			entity.setSurName("SurName" + i);
			entities.add(entity);
		}
		userService.save(entities);
		

		final List<User> entitiesFromDb = userService.getAll();

		assertNotNull(entitiesFromDb);
		assertTrue(entities.size() == (entitiesFromDb.size()));

	}

}
