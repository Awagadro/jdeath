package jdeath.awagadro.daoJdbc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConnectorDB {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		ResourceBundle resource = ResourceBundle.getBundle("database");
		// get vallues from property-file
		String url = resource.getString("db.url");
		String user = resource.getString("db.user");
		String pass = resource.getString("db.password");
		String enc = resource.getString("db.encoding");
		String tz = resource.getString("db.timeZone");
		String driver = resource.getString("db.driver");

		// insert into property-class
		Properties prop = new Properties();
		prop.put("user", user);
		prop.put("password", pass);
		prop.put("serverTimezone", tz);
		prop.put("characterEncoding", enc);
		prop.put("useUnicode", "true"); // Blinov
		prop.put("autoReconnect", "true"); // Blinov
		prop.put("zeroDateTimeBehavior", "CONVERT_TO_NULL"); // Bl

		Class.forName(driver); // driver class upload
		return DriverManager.getConnection(url, prop);
	}
}
