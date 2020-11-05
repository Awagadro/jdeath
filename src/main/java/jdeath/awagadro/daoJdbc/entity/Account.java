package jdeath.awagadro.daoJdbc.entity;

import jdeath.awagadro.daoJdbc.entity.api.IAccount;

public class Account extends BaseEntity implements IAccount {
	private User user;
	private int acoount;

	public Account() {
	}

	public Account(Integer id, User user, int acoount) {
		super(id);
		this.user = user;
		this.acoount = acoount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAcoount() {
		return acoount;
	}

	public void setAcoount(int acoount) {
		this.acoount = acoount;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + super.getId() + ", user=" + user + ", acoount=" + acoount + "]";
	}

}
