package jdeath.awagadro;

import jdeath.awagadro.daoJdbc.entity.dao.IDao;

public abstract class AbstractDaoImpl<ENTITY, ID> implements IDao<ENTITY, ID> {

//	@Override
	public ENTITY get(final ID id) {
		return null;
	}
}
