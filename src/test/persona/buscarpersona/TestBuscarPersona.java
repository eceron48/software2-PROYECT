package test.persona.buscarpersona;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Persona;
import modelo.DAO.DAOPersona;

public class TestBuscarPersona {


	private String nombre ;
	private String  cedula;
	private String telefono; 
	private String rol;
	

Persona persona;
Persona prueba;
DAOPersona dao;
Persona pruebados;
Persona pruebatres;
		
		
		@Before
		public void  datosIniciales() {
			
		
			this.persona=new Persona();
			this.prueba=new Persona();
			this.pruebados= new Persona();
			this.pruebatres=new Persona();
			
			
			this.dao=new DAOPersona();
			prueba.setCedula("1023972869");
			prueba.setNombre("elina");
			prueba.setTelefono("2796507");
			prueba.setRol("residente");
			
		}
		
		@Test
		public void testBuscarExitoso() throws SQLException {
			
			persona=dao.buscarPersona("1023972869");
			
		assertEquals(persona.getCedula(), prueba.getCedula());
			
		}
		@Test
		
		public void testBuscarFallido () throws SQLException {
		pruebados=dao.buscarPersona("4454");// No existe
		pruebatres=null;
			
		assertEquals(pruebados, pruebatres);
		
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
