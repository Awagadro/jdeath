package jdeath.awagadro.daoJdbc;

import java.util.ArrayList;
import java.util.List;

import jdeath.awagadro.daoJdbc.dao.UserAccountDao;
import jdeath.awagadro.daoJdbc.dao.UserDao;
import jdeath.awagadro.daoJdbc.entity.User;
import jdeath.awagadro.daoJdbc.entity.UserAccount;

public class TestStarter {

	public static void main(String[] args) {
		UserDao uDao = new UserDao();
		UserAccountDao uAcDao = new UserAccountDao();
		uAcDao.deleteAll();
		uDao.deleteAll();

		User user = uDao.create(new User(0, "Майкл", "Джексон"));
		System.out.println("New user created: " + user.toString());

		UserAccount entity = new UserAccount(); // create new entity
		entity.setAccount(100);
		entity.setUserId(user.getId());

		UserAccount entity2 = new UserAccount(); // create new entity
		entity2.setAccount(200);
		entity2.setUserId(user.getId());
		List<UserAccount> eList = new ArrayList<UserAccount>();
		eList.add(entity);
		eList.add(entity2);
		eList = uAcDao.create(eList);

		List<UserAccount> listFromDB = new ArrayList<UserAccount>();
		listFromDB = uAcDao.findAccountsForUser(user.getId());
		for (UserAccount userAccount : listFromDB) {
			System.out.println(userAccount);
		}

		// List<User> users1 = new ArrayList<User>();
		// users1 = uDao.findAll();
		// for (User user : users1) {
		// System.out.println(user.toString());
		// }

		// User usr1 = uDao.findUserBySUrName("Джексон");
		// System.out.println(usr1.toString());

		// boolean flag = uDao.deleteAll();
		// System.out.println(flag);

		// List<User> users1 = new ArrayList<User>();
		// users1 = uDao.findAll();
		// for (User user : users1) {
		// System.out.println(user.toString());
		// }

		// List<User> users = new ArrayList<User>();
		// users.add(new User(0, "Филипп", "Киркоров"));
		// users.add(new User(1, "Алла", "Пугачева"));
		// users.add(new User(1, "Николай", "Басков"));
		// List<User> usersFromBase = uDao.create(users);

		// User usr = uDao.findById(20);
		// System.out.println("Меняем фамилию " + usr.getSurName());
		// usr.setSurName("Валуев");
		// usr = uDao.update(usr);

	}

}
