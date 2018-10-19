package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;


public class DAOResidente {
	
	private IDBAdapter dbAdapter;

	 public DAOResidente(){
	 dbAdapter = DBFactory.getDefaultDBAdapter();
	 }
	
public List<Persona> mostrarTodoResidente() throws SQLException{
	 Connection connection = dbAdapter.getConnection();
	 List<Persona> listaresidente = new ArrayList<>();

	try {  PreparedStatement statement = connection.
	
	prepareStatement("SELECT idcedula,pnombre,ptelefono" 
	+ " FROM persona");

	ResultSet results = statement.executeQuery();  while(results.next()){
	
	listaresidente.add(new Persona(results.getString(1),results.getString(2) , results.getInt(3)));

	}  return listaresidente;
	
	} catch (Exception e) {e.printStackTrace();

	return null;  }finally{
	
	try { connection.close();
	
	} catch (Exception e) {}  }

	} 
	 


	public boolean insertar(Persona persona) throws SQLException{  
		Connection connection = dbAdapter.getConnection();

	try {  PreparedStatement statement = connection.

			prepareStatement("INSERT INTO persona(idcedula,pnombre, ptelefono,prol,cuota_idcuota)" + "VALUES (?,?,?,?,?)");
	
	statement.setString(1, persona.getCedula());
	statement.setString(2, persona.getNombre());
	statement.setInt(3, persona.getTelefono());
	statement.setString(4,"residente");
	statement.setInt(5,1);
	statement.executeUpdate();
	JOptionPane.showMessageDialog(null, "ingresado con exito", null, 1);
	return true; } catch (Exception e) {
	
	e.printStackTrace();  return false;
	
	}finally{ try {

	connection.close();  } catch (Exception e) {}
	
	}  }

}
