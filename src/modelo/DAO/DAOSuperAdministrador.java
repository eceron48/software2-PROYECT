package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Persona;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOSuperAdministrador {
	private IDBAdapter dbAdapter;

	public DAOSuperAdministrador() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public Administrador mostrarAdministrador() throws SQLException {

		Administrador p = new Administrador();

		Connection con = dbAdapter.getConnection();

		try {

			PreparedStatement bus = con.prepareStatement("select * from administrador where rol='" + "sadmin" + "'");

			ResultSet results = bus.executeQuery();
			while (results.next()) {

				p.setId(results.getInt(1));
				p.setUsuario(results.getString(2));
				p.setPass(results.getString(3));
				p.setNombre(results.getString(4));
				p.setCedula(results.getString(5));
				p.setTelefono(results.getString(6));

			}

			return p;

		} catch (Exception e) {

			return null;
		} finally {

			try {
				con.close();

			} catch (Exception e) {
			}
		}

	}

	public void modificarSAdministrador(Administrador ad) {

		String ACTUALIZAR = "UPDATE administrador set usuario='" + ad.getUsuario() + "',pass='" + ad.getPass()
				+ "',anombre='" + ad.getNombre() + "',cedula='" + ad.getCedula() + "',telefono='" + ad.getTelefono()
				+ "' where rol='" + "sadmin" + "'";

		Connection connection;
		try {
			connection = dbAdapter.getConnection();
			PreparedStatement statement = connection.prepareStatement(ACTUALIZAR);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro modificado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "", null, 0);
			e.printStackTrace();
		}

	}
}