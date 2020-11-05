package jdeath.awagadro.daoJdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdeath.awagadro.daoJdbc.entity.User;
import jdeath.awagadro.daoJdbc.utils.DataBaseHelper;

public class PreparedJDBCStarter {

	public static void main(String[] args) {
		List<User> list = new ArrayList<User>() {
			{
				add(new User(1, "Петр", "Первый"));
				add(new User(2, "Екатерина", "Вторая"));
			}
		};
		DataBaseHelper helper = null;
		PreparedStatement ps = null;
		try {
			try {
				helper = new DataBaseHelper();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			ps = helper.getPreparedStatement();
			for (User u : list) {
				helper.insertUser(ps, u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closeStatement(ps);
		}

	}

}
