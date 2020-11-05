package jdeath.awagadro.daoJdbc.entity;

public class User extends BaseEntity {
	private int userId;
	private String name;
	private String surName;

	public User() {
	}

	public User(int id, String name, String surName) {
		super(id);
		this.name = name;
		this.surName = surName;
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
