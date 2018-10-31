package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Persona;
import modelo.ZonaResidencialSingleton;
import modelo.factorymethod.IDBAdapter;
import vista.VistaResidentes;
import vista.VistaZonaR;

public class DAOZonaResidencial {

	
	private IDBAdapter dbAdapter;	
	public void modificarZona () throws SQLException  {
		
		Connection connection = dbAdapter.getConnection();
		
	}
	
	
	
	
	public  ArrayList<String>  mostrarZona() throws SQLException {
		ArrayList<String> listaZona = new ArrayList <> ();

		Connection connection = dbAdapter.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from zonaresidencial WHERE idzonaresidencial='"+1+"'");
		
		ResultSet results = statement.executeQuery();
		while (results.next()) {
			
			DAOZonaResidencial zona = new DAOZonaResidencial();
			
					
			listaZona.add(new String(results.getString(1)));
			listaZona.add(new String(results.getString(2)));
			
			System.out.print("registro 1 direccion"+ results.getString(1));
			System.out.print("registro 2 nombre"+ results.getString(2));
			

		}		
		
		return listaZona;	
	
			
	}	

	

}
