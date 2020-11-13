package jdeath.awagadro.daoJdbc.entity;

public class UserAccount extends AbstractEntity {
	private int account;
	private Integer userId;

	public UserAccount() {
	}

	public UserAccount(Integer id, int account, Integer userId) {
		super(id);
		this.account = account;
		this.userId = userId;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserAccount [account=" + account + ", userId=" + userId + "]";
	}

}
