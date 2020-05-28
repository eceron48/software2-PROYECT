package test.persona.insertar;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Persona;
import modelo.DAO.DAOPersona;

public class TestInsertarPersonaEntradas {

	private String nombre ;
	private String  cedula;
	private String telefono; 
	private String rol;
	


Persona persona;
Persona prueba;
DAOPersona dao;
	@Before
	public void  datosIniciales() {
		this.nombre="elina";
		
		this.cedula="1023972869";
		
		this.telefono="2796507";

		this.rol ="residente";
	
		this.persona=new Persona();
		this.prueba=new Persona();
		
		this.dao=new DAOPersona();
		
	}
	// se verifica los datos de ingreso deben ser aprobados con un true // este test  se puede ejecutar una sola vez luego fallara 
@Test
public void VerificarDatos() throws SQLException {
	persona.setNombre(nombre);
	persona.setCedula(cedula);
	persona.setTelefono(telefono);
	persona.setRol(rol);
	
	
	assertSame(true, dao.insertar(persona));
	
}

// Los datos deben fallar porque no se agregara una cedula , se evidencia con un false  Estas pruebeas solo se pueden ejecutar una vez 
@Test 
public void datosFallidos() throws SQLException{
	
	persona.setNombre(nombre);
	persona.setTelefono(telefono);
	persona.setRol(rol);
	

	
	
	assertSame(false, dao.insertar(persona));
	
	
	
}
@Test public void repeticiondeDatos() throws SQLException {
	
	
	persona.setNombre(nombre);
	persona.setTelefono(telefono);
	persona.setRol(rol);
	
	assertSame(false, dao.insertar(persona));
}
	
	@After
	public void limpiar() {
		
		persona= null;
		prueba=null;
		dao=null;
		nombre=null;
		cedula=null;
		telefono = null;
		
	}
	
	
	

}
