package jdeath.awagadro.daoJdbc.entity;

public class Account extends BaseEntity {
	private int accountId;
	private User user;
	private int acoount;

	public Account() {
	}

	public Account(int id, User user, int acoount) {
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
		return "Account [accountId=" + accountId + ", user=" + user + ", acoount=" + acoount + "]";
	}

}
