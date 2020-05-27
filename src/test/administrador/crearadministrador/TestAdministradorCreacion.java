package test.administrador.crearadministrador;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Administrador;

public class TestAdministradorCreacion {
Administrador admin;	
	
	

@Before
public void inicializar () {
	this.admin=new Administrador();
	admin.setCedula("1083892648");
	admin.setId(1);
	admin.setNombre("andrea ");
	admin.setPass("11");
	admin.setTelefono("6699");
	admin.setUsuario("11");
	admin.setRol("admin");
	
}


@Test ()
public void pruebaInsercion() {

}


@After
public void finalizar() {
	
}
}
