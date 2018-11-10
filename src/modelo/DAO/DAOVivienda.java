package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Persona;
import modelo.Vivienda;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOVivienda {

	private IDBAdapter dbAdapter;

	public DAOVivienda() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public List<Apartamento> mostrarTodoViviendas() throws SQLException {
		Connection connection = dbAdapter.getConnection();
		List<Apartamento> listaVivienda = new ArrayList<>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from vivienda");

			ResultSet results = statement.executeQuery();
			while (results.next()) {

				Apartamento apto = new Apartamento();

				apto.setId(results.getInt(1));
				apto.setVrol(results.getString(2));
				apto.setIdApartamento(results.getString(3));
				apto.setPiso(results.getInt(4));
				apto.setBloque(results.getString(5));
				listaVivienda.add(apto);

			}

			return listaVivienda;

		} catch (Exception e) {

			return null;
		} finally {

			try {
				connection.close();

			} catch (Exception e) {
			}
		}

	}

	public void modificarVivienda(Apartamento apto) throws SQLException {
		Connection connection = dbAdapter.getConnection();
		String UPDATE = "update vivienda set vrol='"+apto.getVrol()+"',vnombre='"+apto.getIdvivienda()+"',vpiso='" + apto.getPiso() + "',vbloque='" 
		+ apto.getBloque() + "'where vivienda.idvivienda='"+ apto.getId() + "'";

		PreparedStatement statement = connection.prepareStatement(UPDATE);
		statement.executeUpdate();
		JOptionPane.showMessageDialog(null, "Registro modificado");

	}

}
