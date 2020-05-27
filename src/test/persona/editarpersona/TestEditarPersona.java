package test.persona.editarpersona;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import modelo.Persona;
import modelo.DAO.DAOPersona;

public class TestEditarPersona {
	
	Persona persona;
	Persona personaedit;
	Persona prueba;
	DAOPersona dao;
	Persona personatres;
		
			
	@Before
	public void inicializar()
	
	{

		this.persona=new Persona();
		this.prueba=new Persona();
		this.personatres= new Persona();
		
		this.dao=new DAOPersona();
		prueba.setCedula("1023972869");
		prueba.setNombre("elina");
		prueba.setTelefono("2796507");
		prueba.setRol("residente");
		
		
		
	
		persona.setCedula("4545655");
		persona.setNombre("eliana");
		persona.setTelefono("2796508");
		persona.setRol("residente");

		
		
		
		

		
	}
	
	@Test
	public void modificacionExitosa() throws Exception {
		
		
		personatres=dao.buscarPersona("1023972869");
		persona.setId(personatres.getId());
		dao.modificarPersona(persona);
		
		assertNotEquals(persona.getNombre(),personatres.getNombre());
		assertNotEquals(persona.getCedula(),personatres.getCedula());
		assertNotEquals(persona.getTelefono(),personatres.getTelefono());
		
		
	}
	
	
	@Test(expected=Exception.class)
   public void modificacionFallida() throws Exception {
	   
	   personaedit=dao.buscarPersona("1234");
	   persona.setId(personaedit.getId());
	   dao.modificarPersona(persona);
	  
	   
	  
	   
   }
	
	@ After
	public void finalizar() {
		
		
		
		
		
	}
	
	
}
