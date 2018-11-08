package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Casa;
import modelo.CuotaAdministracion;
import modelo.Persona;
import modelo.Residente;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOPagos {

	private IDBAdapter dbAdapter;
	public DAOPagos() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	
	
	public ArrayList<Residente> buscarPersona(String cedula) throws SQLException {
		Connection connection = dbAdapter.getConnection();
		ArrayList<Residente> lista = new ArrayList<Residente> ();
		
		try {			
			
			PreparedStatement statement = connection.prepareStatement("select * from persona,cuota where persona.pcedula='"+cedula+"' and persona.idpersona=cuota.persona_idpersona");
			ResultSet results = statement.executeQuery();
			while (results.next()) {				
				Residente p=new Residente();
				CuotaAdministracion  cuota=new CuotaAdministracion() ;
				p.setId(results.getInt(1));
				p.setNombre(results.getString(2));
				p.setCedula(results.getString(3));
				p.setTelefono(results.getString(4));
				
				cuota.setCuota(results.getDouble(8));
				cuota.setPorcentaje(results.getDouble(7));
				cuota.setUltimoPago(results.getString(10));
				cuota.setObservacion(results.getString(11));
				cuota.setTotal(cuota.calcularCuota(cuota.getCuota(), cuota.getPorcentaje()));
				p.setCuota(cuota);
		
				lista.add(p);
			}

			return lista;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "el documento ingresado no fue encontrado intente de nuevo ",null, 3);
			return null;
		} finally {

			try {
				connection.close();

			} catch (Exception e) {
			}
		}

	

}

	public ArrayList<Residente> mostrarTodos() throws SQLException {
		Connection connection = dbAdapter.getConnection();
		ArrayList<Residente> lista = new ArrayList<Residente> ();
		
		
		
		try {			
			
			PreparedStatement statement = connection.prepareStatement("select * from persona,cuota where  persona.idpersona=cuota.persona_idpersona");
			ResultSet results = statement.executeQuery();
			while (results.next()) {				
				Residente p=new Residente();
				CuotaAdministracion  cuota=new CuotaAdministracion() ;
				
				p.setId(results.getInt(1));
				p.setNombre(results.getString(2));
				p.setCedula(results.getString(3));
		
				
				cuota.setCuota(results.getDouble(8));
				cuota.setPorcentaje(results.getDouble(7));
				cuota.setIdcuota(results.getInt(6));
				cuota.setUltimoPago(results.getString(10));
				cuota.setObservacion(results.getString(11));
				cuota.setTotal(cuota.calcularCuota(cuota.getCuota(), cuota.getPorcentaje()));
				p.setCuota(cuota);
				lista.add(p);

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
	
	public void registrarPagoEfectivo(Residente r) {

		String actualizar = "UPDATE cuota,persona set cuota.observacion='"+r.getCuota().getObservacion()
				+ "' where cuota.persona_idpersona='" + r.getId()+"'and persona.pcedula='"+r.getCedula()
				+ "'";
		try {
			Connection connection = dbAdapter.getConnection();
			PreparedStatement statement = connection.prepareStatement(actualizar);
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "registrado");
		     
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(null, "error", actualizar, 2);
		}

	}

	
	
	
}
