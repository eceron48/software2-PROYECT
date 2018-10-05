package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	prepareStatement("SELECT idcedula,pnombre,pdireccion,ptelefono" 
	+ " FROM productos");

	ResultSet results = statement.executeQuery();  while(results.next()){
	
	listaresidente.add(new Persona(results.getString(1),results.getString(2) , results.getString(3), results.getInt(4)));

	}  return listaresidente;
	
	} catch (Exception e) {e.printStackTrace();

	return null;  }finally{
	
	try { connection.close();
	
	} catch (Exception e) {}  }

	} 
	


	public boolean saveProduct(Product product) throws SQLException{  
		Connection connection = dbAdapter.getConnection();

	try {  PreparedStatement statement = connection.

			prepareStatement("INSERT INTO productos(idproductos,"  + "nombreproducto, precioproducto) VALUES (?,?,?)");
	
	statement.setLong(1, product.getIdproduct()); statement.setString(2, product.getProductName());
	
	statement.setDouble(3, product.getPrice());  statement.executeUpdate();
	
	return true; } catch (Exception e) {
	
	e.printStackTrace();  return false;
	
	}finally{ try {

	connection.close();  } catch (Exception e) {}
	
	}  }


}
