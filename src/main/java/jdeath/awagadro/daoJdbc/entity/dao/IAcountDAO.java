package jdeath.awagadro.daoJdbc.entity.dao;

import java.util.List;

import jdeath.awagadro.daoJdbc.entity.api.IAccount;
import jdeath.awagadro.daoJdbc.entity.filter.AccountFilter;

public interface IAcountDAO extends IDao<IAccount, Integer> {
	void save(IAccount... entities);

	List<IAccount> find(AccountFilter filter);

	long getCount(AccountFilter filter);

	IAccount getFullInfo(Integer id);
}
