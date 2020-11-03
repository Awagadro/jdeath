package jdeath.awagadro;

public class Account {
	private int accountId;
	private User user;
	private int acoount;

	public Account() {
	}

	public Account(int accountId, User user, int acoount) {
		this.accountId = accountId;
		this.user = user;
		this.acoount = acoount;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
