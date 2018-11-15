package modelo.residente.implementar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Apartamento;
import modelo.CuotaAdministracion;
import modelo.Parqueadero;
import modelo.Persona;
import modelo.Residente;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class AsignarViviendaResidente {
	private IDBAdapter dbAdapter;
	public AsignarViviendaResidente() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public List<Persona> mostrarTodoPersonas() throws SQLException {
		Connection connection = dbAdapter.getConnection();
		List<Persona> listaresidente = new ArrayList<>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from persona where prol='"+"residente"+"'and pestado='"+"libre"+"'");

			ResultSet results = statement.executeQuery();
			while (results.next()) {

				Persona p = new Persona();

				p.setId(results.getInt(1));
				p.setNombre(results.getString(2));
				p.setCedula(results.getString(3));
				p.setTelefono(results.getString(4));
				listaresidente.add(p);

			}

			return listaresidente;

		} catch (Exception e) {

			return null;
		} finally {

			try {
				connection.close();

			} catch (Exception e) {
			}
		}

	}

	

	public List<Apartamento> mostrarTodoViviendas() throws SQLException {
		Connection connection = dbAdapter.getConnection();
		List<Apartamento> listaVivienda = new ArrayList<>();

		try {

			PreparedStatement statement = connection.prepareStatement("select * from vivienda where vivienda.persona_idpersona is null");

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

	
	public ArrayList<Parqueadero> mostrarParqueaderos() throws SQLException {
		ArrayList<Parqueadero> lista = new ArrayList<Parqueadero>();
		Connection connection;
		connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("select * from parqueadero where parestado='"+"libre"+"'");

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

	
public void agregarCuotaResidencial(Residente residente) throws SQLException {
	
	Connection connection = dbAdapter.getConnection();
	
	try {
		PreparedStatement statement = connection.prepareStatement("INSERT INTO cuota(porcentaje,precio,persona_idpersona)"+"VALUES(?,?,?)");
		statement.setDouble(1, residente.getCuota().getPorcentaje());
		statement.setDouble(2, residente.getCuota().getCuota());
		statement.setInt(3, residente.getId());
		statement.executeUpdate();
	} catch (Exception e) {
		
	}
	 finally {
			try {

				connection.close();
			} catch (Exception e) {
			}

		}
	

	
	
} 
	

public void asignarVivienda(Residente apto) throws SQLException {
	Connection connection = dbAdapter.getConnection();
	String UPDATE = "update vivienda set vivienda.persona_idpersona='"+apto.getId()+"',vivienda.parqueadero_idparqueadero='"+apto.getVivienda().getParqueadero().getId()+
	"'where vivienda.idvivienda='"+apto.getVivienda().getId() + "'";

	PreparedStatement statement = connection.prepareStatement(UPDATE);
	statement.executeUpdate();

}

	

public void cambiarEstadoDeResidente(int id) throws SQLException {
	Connection connection = dbAdapter.getConnection();
	String UPDATE = "update persona set persona.pestado='"+"ocupado"+
	"'where persona.idpersona='"+id+ "'";

	PreparedStatement statement = connection.prepareStatement(UPDATE);
	statement.executeUpdate();

}	

public void cambiarEstadoParqueadero(int id) throws SQLException {
	Connection connection = dbAdapter.getConnection();
	String UPDATE = "update parqueadero set parqueadero.parestado='"+"ocupado"+
	"'where idparqueadero='"+id+ "'";

	PreparedStatement statement = connection.prepareStatement(UPDATE);
	statement.executeUpdate();
	JOptionPane.showMessageDialog(null, "asignado correctamente", null, 1);
}	
	
}
