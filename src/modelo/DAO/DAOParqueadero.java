package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

import modelo.Parqueadero;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOParqueadero {
	private IDBAdapter dbAdapter;

	public DAOParqueadero() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public void registrarParqueadero(Parqueadero parqueadero) throws SQLException {
		try {
			Connection connection = dbAdapter.getConnection();
			String INSERT = "INSERT INTO parqueadero(referencia,parestado)" + "VALUES(?,?)";

			PreparedStatement registrar = connection.prepareStatement(INSERT);
			registrar.setString(1, parqueadero.getCodigo());
			registrar.setString(2, "libre");
			registrar.executeUpdate();
			JOptionPane.showMessageDialog(null, "registro exitoso", null, 1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "error de insersion", null, 0);
		}

	}

	public ArrayList<Parqueadero> mostrarParqueaderos() throws SQLException {
		ArrayList<Parqueadero> lista = new ArrayList<Parqueadero>();
		Connection connection;
		connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from parqueadero");

			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Parqueadero park = new Parqueadero();
				park.setId(results.getInt(1));
				park.setCodigo(results.getString(2));
				lista.add(park);
			}
			return lista;
		} catch (Exception e) {

			return null;
		} finally {

			try {
				connection.close();

			} catch (Exception e) {
			}
		}
	}

	public void modificarParqueadero(Parqueadero parqueadero) throws SQLException {
		Connection connection = dbAdapter.getConnection();
		String UPDATE = "update parqueadero set referencia='" + parqueadero.getCodigo()
				+ "'where parqueadero.idparqueadero='" + parqueadero.getId() + "'";

		PreparedStatement statement = connection.prepareStatement(UPDATE);
		statement.executeUpdate();
		JOptionPane.showMessageDialog(null, "Registro modificado");

	}
}
