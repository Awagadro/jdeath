package jdeath.awagadro;

public class User {
	private int userId;
	private String name;
	private String surName;

	public User() {
	}

	public User(int userId, String name, String surName) {
		this.userId = userId;
		this.name = name;
		this.surName = surName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", surName=" + surName + "]";
	};

}
