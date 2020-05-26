package modelo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.CuotaAdministracion;
import modelo.factorymethod.DBFactory;
import modelo.factorymethod.IDBAdapter;

public class DAORegistrarCuota {

	private IDBAdapter dbAdapter;

	public DAORegistrarCuota() {
		dbAdapter = DBFactory.getDefaultDBAdapter();
	}

	public void RegistrarCuota(CuotaAdministracion cuota)throws SQLException{
		
		Connection connection = dbAdapter.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement("INSERT INTO cuota(idcuota,porcentage,precio)"+"VALUES(?,?,?)");
			statement.setInt(1, 1);
			statement.setDouble(2, cuota.getPorcentaje());
			statement.setDouble(3, cuota.getCuota());
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

	public CuotaAdministracion mostrarCuota() throws SQLException{
		
		Connection connection = dbAdapter.getConnection();
		CuotaAdministracion c=new CuotaAdministracion();
		try {
			PreparedStatement statement = connection.
			prepareStatement("select *  from cuota where idcuota='"+1+"'");
			ResultSet results = statement.executeQuery();  while(results.next()){
			c.setIdcuota(results.getInt(1));
			c.setPorcentaje(results.getDouble(2));
			c.setCuota(results.getDouble(3));
			

				}  return c;
				
				} catch (Exception e) {e.printStackTrace();

				return null;  }finally{
				
				try { connection.close();
				
				} catch (Exception e) {}  }

			
			
		}

	public void modificarCuota(CuotaAdministracion modificar)throws SQLException {
		Connection connection = dbAdapter.getConnection(); 
		Statement stm;
		
		
String sql="UPDATE cuota SET porcentage='"+modificar.getPorcentaje()+"', precio='"+modificar.getCuota()+"'"+" WHERE idcuota="+modificar.getIdcuota();
try {
	
                
                stm=connection.createStatement();
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Registro modificado");
} catch (SQLException e) {
	JOptionPane.showMessageDialog(null,"Error: Metodo Modificar");
                e.addSuppressed(e);
}		

		
		
	} 
		
	
	

	
	
	
}
