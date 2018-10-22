package modelo.factorymethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

public class PostgresDBAdapter implements IDBAdapter {

	private static final String DB_PROPERTIES = "BD_INF/DBPosgres.properties";

	private static final String DB_NAME_PROP = "dbname";
	private static final String DB_HOST_PROP = "host";
	private static final String DB_PASSWORD_PROP = "password";
	private static final String DB_PORT_PROP = "port";
	private static final String DB_USER_PROP = "user";

	static {

		try {
			Class.forName("org.postgresql.Driver").newInstance();

			JOptionPane.showMessageDialog(null, "exito en la conexion ");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);

		}
	}

	public Connection getConnection() throws SQLException {
		try {
			String connectionString = createConnectionString();
			Connection connection = DriverManager.getConnection(connectionString);
			System.out.println("Connection class ==> " + connection.getClass().getName());
			return connection;
		} catch (SQLDataException e) {
			JOptionPane.showMessageDialog(null, e);
			return null;

		}

	}

	private String createConnectionString() {

		Properties prop = PropertiesUtil.loadProperty(DB_PROPERTIES);
		String host = prop.getProperty(DB_HOST_PROP);
		System.out.println("host" + host);
		String port = prop.getProperty(DB_PORT_PROP);
		System.out.println("port" + port);
		String db = prop.getProperty(DB_NAME_PROP);
		System.out.println(db);
		String user = prop.getProperty(DB_USER_PROP);
		System.out.println(user);
		String password = prop.getProperty(DB_PASSWORD_PROP);
		System.out.println(password);
		
		String connectionString = "jdbc:postgresql://" + host + ":" + port + "/" + db + "?user=" + user + "&password="
				+ password;

		System.out.println("ConnectionString ==> " + connectionString);
		return connectionString;
	}

}
