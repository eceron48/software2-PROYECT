package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Persona;
import modelo.ZonaResidencialSingleton;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;
import vista.VistaResidentes;
import vista.VistaZonaR;

public class DAOZonaResidencial {

	
	
	private IDBAdapter dbAdapter;
	public DAOZonaResidencial() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	
	
	
	public void modificarZona () throws SQLException  {
		
		Connection connection = dbAdapter.getConnection();
		
	}
	
	
	
	
	public  ZonaResidencialSingleton mostrarZona() throws SQLException {
		
		 ZonaResidencialSingleton c= ZonaResidencialSingleton.getInstance();
		 
		Connection connection = dbAdapter.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from zonaresidencial WHERE idzonaresidencial='"+1+"'");
		
		ResultSet results = statement.executeQuery();
		while (results.next()) {
			
			
			
					
			c.setDireccion(results.getString(2));
			c.setNombre(results.getString(3));
			
		

		}		
		
		return c;	
	
			
	}	

	

}
