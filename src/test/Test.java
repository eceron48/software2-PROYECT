package test;

import java.sql.SQLException;

import modelo.Persona;
import modelo.ZonaResidencialSingleton;
import modelo.builder.FabricaBuilder;
import modelo.builder.PersonaBuilder;
import modelo.builder.ResidenteBuilder;
import modelo.factorymethod.MYSQLDBAdapter;

public class Test {

	public static void main(String[] args) throws SQLException {
		//todo funcional //
		
		
		ZonaResidencialSingleton c=ZonaResidencialSingleton.getInstance();
		System.out.println(c.getDireccion());
		System.out.println(c.getNombre());
	}
		
	

} 
