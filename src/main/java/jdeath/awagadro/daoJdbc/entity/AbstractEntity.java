package jdeath.awagadro.daoJdbc.entity;

public abstract class AbstractEntity {
	private Integer id;

	public AbstractEntity() {
	}

	public AbstractEntity(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
