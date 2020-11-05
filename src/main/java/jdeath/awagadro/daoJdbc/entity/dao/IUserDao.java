package jdeath.awagadro.daoJdbc.entity.dao;

import java.util.List;

import jdeath.awagadro.daoJdbc.entity.api.IUser;
import jdeath.awagadro.daoJdbc.entity.filter.UserFilter;

public interface IUserDao extends IDao<IUser, Integer> {
	void save(IUser... entities);

	List<IUser> find(UserFilter filter);

	long getCount(UserFilter filter);

	IUser getFullInfo(Integer id);
}
