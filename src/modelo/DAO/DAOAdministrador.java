package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Administrador;
import modelo.Persona;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOAdministrador {
	private IDBAdapter dbAdapter;

	public DAOAdministrador() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public Administrador buscarAdminPorCedula(String cedula) throws SQLException {

		Connection connection = dbAdapter.getConnection();
		Administrador p = new Administrador();

		try {

			PreparedStatement statement = connection.prepareStatement(
					"select * from administrador WHERE cedula='" + cedula + "'and rol='" + "administrador" + "'");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				results.beforeFirst();
				while (results.next()) {

					p.setId(results.getInt(1));
					p.setNombre(results.getString(4));
					p.setCedula(results.getString(5));
					p.setTelefono(results.getString(6));
					p.setUsuario(results.getNString(2));
					p.setPass(results.getString(3));
 
				}
			} else {

				return null;
			}

			return p;

		} catch (Exception e) {

			return null;
		} finally {

			try {
				connection.close();

			} catch (Exception e) {
			}
		}

	}

	public void insertarAdministrador(Administrador administrador) throws SQLException {

		Connection connection = dbAdapter.getConnection();

		try {
			PreparedStatement statement = connection.

					prepareStatement("INSERT INTO administrador(usuario,pass, anombre,cedula,telefono,rol)"
							+ "VALUES (?,?,?,?,?,?)");

			statement.setString(1, administrador.getUsuario());
			statement.setString(2, administrador.getPass());
			statement.setString(3, administrador.getNombre());
			statement.setString(4, administrador.getCedula());
			statement.setString(5, administrador.getTelefono());
			statement.setString(6, administrador.getRol());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "ingresado con exito", null, 1);

		} catch (AssertionError e) {

			e.printStackTrace();

		} finally {
			try {

				connection.close();
			} catch (Exception e) {
			}

		}

	}

	public Administrador buscarAdminPorNombre(String nombre) throws SQLException {

		Connection connection = dbAdapter.getConnection();
		Administrador p = new Administrador();

		try {

			PreparedStatement statement = connection.prepareStatement(
					"select * from administrador WHERE anombre='" + nombre + "'and rol='" + "administrador" + "'");
			ResultSet results = statement.executeQuery();
			if (results.next()) {
				results.beforeFirst();
				while (results.next()) {

					p.setId(results.getInt(1));
					p.setNombre(results.getString(4));
					p.setCedula(results.getString(5));
					p.setTelefono(results.getString(6));
					p.setUsuario(results.getNString(2));
					p.setPass(results.getString(3));

				}
			} else {

				return null;
			}

			return p;

		} catch (Exception e) {

			return null;
		} finally {

			try {
				connection.close();

			} catch (Exception e) {
			}
		}

	}

	public List<Administrador> mostrarTodos() throws SQLException {

		Connection connection = dbAdapter.getConnection();
		List<Administrador> listaadmin = new ArrayList<>();

		try {

			PreparedStatement statement = connection
					.prepareStatement("select * from administrador where rol='" + "administrador" + "'");

			ResultSet results = statement.executeQuery();
			while (results.next()) {

				Administrador admin = new Administrador();

				admin.setId(results.getInt(1));
				admin.setUsuario(results.getString(2));
				admin.setPass(results.getString(3));
				admin.setNombre(results.getString(4));
				admin.setCedula(results.getString(5));
				admin.setTelefono(results.getString(6));
				listaadmin.add(admin);

			}

			return listaadmin;

		} catch (NullPointerException e) {

			return null;
		} finally {

			try {
				connection.close();

			} catch (Exception e) {
			}
		}
	}

	public void modificarAdministrador(Administrador administrador1) {

		String actualizar = "UPDATE administrador set usuario='" + administrador1.getUsuario() + "',pass='"
				+ administrador1.getPass() + "',anombre='" + administrador1.getNombre() + "',cedula='"
				+ administrador1.getCedula() + "',telefono='" + administrador1.getTelefono()
				+ "'where idadministrador='" + administrador1.getId() + "'";
		try {
			Connection connection = dbAdapter.getConnection();
			PreparedStatement statement = connection.prepareStatement(actualizar);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro modificado");

		} catch (SQLException e) {
			e.getMessage();
			JOptionPane.showMessageDialog(null, "error al guaradar", null, 0);
		}

	}

	public void eliminarAdministrador(int id) {

		// delete from administrador where idadministrador=5

		String delete = "DELETE FROM administrador WHERE idadministrador='" + id + "'";

		try {
			Connection connection = dbAdapter.getConnection();
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.executeUpdate();

			JOptionPane.showMessageDialog(null, "Registro eliminado");
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showInputDialog(null, 3, "Error: Metodo Eliminar", 0, null, null, e);

		}

	}

}