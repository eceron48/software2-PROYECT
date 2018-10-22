package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAOResidente {

	private IDBAdapter dbAdapter;
	public	String rol="residente";
	public DAOResidente() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public List<Residente> mostrarTodoResidente() throws SQLException {
		Connection connection = dbAdapter.getConnection();
		List<Residente> listaresidente = new ArrayList<>();

		try {
			PreparedStatement statement = connection.
					prepareStatement("select idpersona,pnombre,pcedula,ptelefono,vrol,vnombre,referencia from (persona inner join vivienda) inner join parqueadero where (persona.idpersona=vivienda.persona_idpersona)and(vivienda.parqueadero_idparqueadero=parqueadero.idparqueadero)and persona.prol='"+rol+"'");
			//select pnombre,pcedula,ptelefono,referencia,vnombre from 
			//(persona inner join vivienda) inner join parqueadero
		//	where
		//	(persona.idpersona=vivienda.persona_idpersona)and(vivienda.parqueadero_idparqueadero=parqueadero.idparqueadero)and (persona.prol="residente");//
			ResultSet results = statement.executeQuery();
			while (results.next()) {
			
				Residente p=new Residente();
				Vivienda vivienda=new Vivienda();
				Parqueadero pq=new Parqueadero();
				p.setId(results.getInt(1));
				p.setNombre(results.getString(2));
				p.setCedula(results.getString(3));
				p.setTelefono(results.getString(4));
				vivienda.setVrol(results.getString(5));
				vivienda.setIdvivienda(results.getString(6));
				pq.setCodigo(results.getString(7));
				p.setVivienda(vivienda);
				vivienda.setParqueadero(pq);
						
				listaresidente.add(p);

			}
			return listaresidente;

		} catch (Exception e) {
			JOptionPane.showMessageDialog( null, "sin datos que mostrar", rol, 1);

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

					prepareStatement("INSERT INTO persona(idcedula,pnombre, ptelefono,prol,cuota_idcuota)"
							+ "VALUES (?,?,?,?,?)");

			statement.setString(1, persona.getCedula());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, "residente");
			statement.setInt(5, 1);
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
	public void delete(String ide) {
		
		
		String delete= "DELETE FROM persona WHERE idcedula='"+rol+"'" ;
		
		
try {	Connection connection = dbAdapter.getConnection();
	PreparedStatement statement = connection.prepareStatement(delete);
	statement.executeUpdate();
    
                
                JOptionPane.showMessageDialog(null,"Registro eliminado");
} catch (SQLException e) {
	e.printStackTrace();
	JOptionPane.showInputDialog(null, 3,"Error: Metodo Eliminar",0, null, null, e);
               
}		


}

	

	//public boolean modificarResidente(Residente r) {
		
	//	boolean eliminar=false;
      /* 
String actualizar=
"UPDATE Persona SET  pnombre='"+r.getNombre()+"', ptelefono='"+r.getTelefono()+"',precioVenta='"+producto.getPrecioventa()+"',precioCompra='"+producto.getPreciocompra()+"',existencia='"+producto.getExistencia()+"' "+" WHERE persona.idcedula="+producto.getId();
try {
		Connection connection = dbAdapter.getConnection();
		PreparedStatement statement = connection.prepareStatement(actualizar);
		statement.executeUpdate();
	eliminar=true;
                JOptionPane.showMessageDialog(null,"Registro modificado");
} catch (SQLException e) {
	JOptionPane.showMessageDialog(null,"Error: Metodo Modificar");
                e.addSuppressed(e);
}		
return eliminar;
}
*/
	
	
	
	
	
public ArrayList<Casa> llenarComboCasa() {
	ArrayList<Casa>casalista=new ArrayList<>();
	String rol="casa";
	String SELECT="select idvivienda,vnombre from vivienda where vivienda.vrol="+rol+"";
	
	
	try {
		Connection  connection = dbAdapter.getConnection();
		PreparedStatement statement = connection.
		prepareStatement("select idvivienda,vnombre from vivienda where vivienda.vrol="+rol+"");
		ResultSet results = statement.executeQuery();
		while(results.next()) {
			Casa c=new Casa();
			c.setId(results.getInt(1));
			c.setIdvivienda(results.getString(2));
			casalista.add(c);
		
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return casalista;	
}

	
	
}	
	