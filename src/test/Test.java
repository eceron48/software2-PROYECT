package test;

import java.sql.SQLException;

import modelo.DAOResidente;
import modelo.Persona;
import modelo.builder.FabricaBuilder;
import modelo.builder.PersonaBuilder;
import modelo.builder.ResidenteBuilder;
import modelo.factorymethod.MYSQLDBAdapter;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		DAOResidente dao=new DAOResidente();
		
		dao.mostrarTodoResidente();
		FabricaBuilder fabricabuilder=new FabricaBuilder();
		PersonaBuilder residentebuilder = new ResidenteBuilder();
		fabricabuilder.setpersonabuilder(residentebuilder);
		fabricabuilder.construirPersona();
    
		Persona persona=fabricabuilder.getpersona();
		
		System.out.println(persona);
	}

}
