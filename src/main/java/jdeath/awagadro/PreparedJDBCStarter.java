package jdeath.awagadro;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			helper = new DataBaseHelper();
			ps = helper.getPreparedStatement();
			for (User u : list) {
				helper.insertUser(ps, u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.equals(ps);
		}

	}

}
