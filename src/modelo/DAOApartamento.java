package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOApartamento {
	
	private IDBAdapter dbAdapter;

	public DAOApartamento() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}
	

	public void RegistrarApartamento(Apartamento casa)throws SQLException{
		
		Connection connection = dbAdapter.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO vivienda(vnombre,vrol,vpiso,vbloque)"+"VALUES(?,?,?,?)");
			statement.setString(1, casa.getIdvivienda());
			statement.setString(2, "apartamento");
			statement.setInt(3, casa.getPiso());
			statement.setString(4, casa.getBloque());
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
