package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOCasa {

	private IDBAdapter dbAdapter;

	public DAOCasa() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	

	public void RegistrarCasa(Casa casa)throws SQLException{
		
		Connection connection = dbAdapter.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO vivienda(vnombre,vrol)"+"VALUES(?,?)");
			statement.setString(1, casa.getIdvivienda());
			statement.setString(2, "casa");
			statement.executeUpdate();
			JOptionPane.showMessageDialog(null, "ingresado con exito", null, 1);
		} catch (Exception e) {
			
		}
		 finally {
				try {

					connection.close();
				} catch (Exception e) {
				}

			}
		
		
	}
	
}
