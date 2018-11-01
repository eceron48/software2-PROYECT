package test;

import java.sql.SQLException;

import modelo.Persona;
import modelo.ZonaResidencialSingleton;
import modelo.DAO.DAOZonaResidencial;
import modelo.builder.FabricaBuilder;
import modelo.builder.PersonaBuilder;
import modelo.builder.ResidenteBuilder;
import modelo.factorymethod.MYSQLDBAdapter;

public class Test {

	public static void main(String[] args) throws SQLException {
		//todo funcional //
			
		ZonaResidencialSingleton z=ZonaResidencialSingleton.getInstance();
		ZonaResidencialSingleton H=ZonaResidencialSingleton.getInstance();
		DAOZonaResidencial c=new DAOZonaResidencial();
		DAOZonaResidencial B=new DAOZonaResidencial();
//c.mostrarZona();
//Z.setDireccion(c.mostrarZona().getDireccion());
//Z.setNombre(c.mostrarZona().getNombre());


//System.out.println("RESIDENCIA "+Z.getDireccion());
//System.out.println("NOMBRE "+Z.getNombre());


System.out.println("RESIDENCIA "+H.getDireccion());
System.out.println("NOMBRE "+H.getNombre());




	}
		
	

} 
