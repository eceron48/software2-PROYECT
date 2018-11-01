package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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

	
	
	
	public void modificarZona (String nombre,String direccion) throws SQLException  {
		
		Connection connection = dbAdapter.getConnection();
		String actualizar = "UPDATE zonaresidencial set nombre='" +nombre + "', direccion='" +direccion+"'";
try {
	PreparedStatement statement = connection.prepareStatement(actualizar);
	statement.executeUpdate();
	JOptionPane.showMessageDialog(null, "Registro modificado");
} catch (SQLException e) {
}
		
	}
	

	public  void mostrarZona() throws SQLException {
		
		 ZonaResidencialSingleton c= ZonaResidencialSingleton.getInstance();
		 
		Connection connection = dbAdapter.getConnection();
		PreparedStatement statement = connection.prepareStatement("select * from zonaresidencial WHERE idzonaresidencial='"+1+"'");
		
		ResultSet results = statement.executeQuery();
		while (results.next()) {	
			c.setId(results.getInt(1));
			c.setDireccion(results.getString(2));
			c.setNombre(results.getString(3));
		}		
		
			
	}	
}
