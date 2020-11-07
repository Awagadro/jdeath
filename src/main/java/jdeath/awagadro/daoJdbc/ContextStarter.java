package jdeath.awagadro.daoJdbc;

import java.util.ArrayList;
import java.util.List;

import jdeath.awagadro.daoJdbc.dao.UserDao;
import jdeath.awagadro.daoJdbc.entity.User;

public class ContextStarter {

	public static void main(String[] args) {
		UserDao uDao = new UserDao();

//		List<User> users = new ArrayList<User>();
//		users = uDao.findAll();
//		for (User user : users) {
//			System.out.println(user.toString());
//		}

//		User usr = uDao.findUserBySUrName("Прекрасная");
//		System.out.println(usr.toString());

//		boolean flag = uDao.delete(11);
//		System.out.println(flag);

//		boolean flag = uDao.delete(usr);
//		System.out.println(flag);

		User usr = uDao.create(new User(0, "Майкл", "Джексон"));
		System.out.println(usr.toString());

		List<User> users = new ArrayList<User>();
		users = uDao.findAll();
		for (User user : users) {
			System.out.println(user.toString());
		}

	}

}
