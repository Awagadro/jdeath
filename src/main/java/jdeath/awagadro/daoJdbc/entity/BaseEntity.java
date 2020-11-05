package jdeath.awagadro.daoJdbc.entity;

import jdeath.awagadro.daoJdbc.entity.api.IBaseEntity;

public abstract class BaseEntity implements IBaseEntity {
	private Integer id;

	public BaseEntity() {
	}

	public BaseEntity(final Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
