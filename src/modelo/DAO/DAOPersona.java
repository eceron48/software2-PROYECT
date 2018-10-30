package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Parqueadero;
import modelo.Persona;
import modelo.Vivienda;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOPersona {

	private IDBAdapter dbAdapter;
	public String rol = "residente";

	public DAOPersona() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public List<Persona> mostrarTodoPersonas() throws SQLException {
		Connection connection = dbAdapter.getConnection();
		List<Persona> listaresidente = new ArrayList<>();
		
		try {
			
			PreparedStatement statement = connection.prepareStatement(
					"select * from persona");
			
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				
				Persona p = new Persona();

				
				p.setId(results.getInt(1));
				p.setNombre(results.getString(2));
				p.setCedula(results.getString(3));
				p.setTelefono(results.getString(4));
				p.setRol(results.getString(5));
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

	public boolean insertar(Persona persona) throws SQLException {
		Connection connection = dbAdapter.getConnection();
	
		try {
			PreparedStatement statement = connection.

					prepareStatement("INSERT INTO persona(pcedula,pnombre, ptelefono,prol)"
							+ "VALUES (?,?,?,?)");

			statement.setString(1, persona.getCedula());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getRol());
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "ingresado con exito", null, 1);
			
			
			
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;

		} finally {
			try {

				connection.close();
			} catch (Exception e) {
			}

		}
		
	}

//-----------------------------borrar----------------------------------------------------------//
	public void eliminarPersona (int ide) {

		String delete = "DELETE FROM persona WHERE idpersona='" + ide + "'";

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

	public void modificarPersona(Persona r) {

	
	  String actualizar="UPDATE Persona set pnombre='"+r.getNombre()
	  +"', pcedula='"+r.getCedula()+"', ptelefono='"+r.getTelefono()+"',prol='"+r.getRol()+"' where idpersona='"+r.getId()+"'";
	  try {
		  Connection connection =
		  dbAdapter.getConnection(); PreparedStatement statement =
		  connection.prepareStatement(actualizar); statement.executeUpdate();
		  JOptionPane.showMessageDialog(null,"Registro modificado"); 
		}
	  catch (SQLException e) {
	  }

	  }
	 

	public ArrayList<Casa> llenarComboCasa() {
		ArrayList<Casa> casalista = new ArrayList<>();
		String rol = "casa";

		try {
			Connection connection = dbAdapter.getConnection();
			PreparedStatement statement = connection
					.prepareStatement("select idvivienda,vnombre from vivienda where vivienda.vrol='" + rol + "'");
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				Casa c = new Casa();
				c.setIdvivienda(results.getString(2));
				casalista.add(c);
					
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return casalista;
	}

	public ArrayList<Parqueadero> llenarComboParqueadero() {

		ArrayList<Parqueadero> parqueadero = new ArrayList<>();
		String SELECT = "select * from parqueadero ";

		try {
			Connection connection = dbAdapter.getConnection();
			PreparedStatement statement = connection.prepareStatement(SELECT);
			ResultSet results = statement.executeQuery();
			while (results.next()) {
				parqueadero.add(new Parqueadero(results.getString(1)));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return parqueadero;
}
	/*
public ArrayList<Apartamento>tablaApartamento(){
	ArrayList<Apartamento> aparatamento = new ArrayList<>();
	Apartamento ap=new Apartamento(); 
	String rol = "apartamento";
	String SELECT="select idvivienda,vnombre,vpiso,vbloque from vivienda where vivienda.vrol='" + rol + "'order by vnombre";
	
	try {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement statement = connection.prepareStatement(SELECT);
		ResultSet results = statement.executeQuery();
		while (results.next()) {
			ap.setId(results.getInt(1));
			ap.setIdvivienda(results.getString(2));
			ap.setPiso(results.getInt(3));
			ap.setBloque(results.getString(4));
			System.out.println("id "+ap.getId());
			System.out.println("viviendanumero "+ap.getIdvivienda());
			System.out.println("piso "+ap.getPiso());
			aparatamento.add(ap);
					
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return aparatamento ;
}
	*/
	
}	
	