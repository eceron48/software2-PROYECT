package test.administrador.crearadministrador;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.exceptions.ExceptionFactory;

import modelo.Administrador;
import modelo.DAO.DAOAdministrador;

public class TestAdministradorCreacion {
Administrador admin;	
DAOAdministrador dao;
Administrador adminprueba;

@Before
public void inicializar () {
	this.dao=new DAOAdministrador();	
	this.adminprueba=new Administrador();
	this.admin=new Administrador();
	admin.setCedula("1083892648");
	admin.setNombre("andrea ");
	admin.setPass("11");
	admin.setTelefono("6699");
	admin.setUsuario("11");
	admin.setRol("administrador");

	
}


@Test
public void pruebaInsercion() throws SQLException {
dao.insertarAdministrador(admin);//se agrega normalmente un administrador nuevo 
adminprueba=dao.buscarAdminPorCedula(admin.getCedula());
assertEquals(adminprueba.getCedula(), admin.getCedula()); // se comprueba si el nuevo administrador fue agragado a la base
}
@Test(expected = SQLException.class)//se ingresara una cedula ya existente debe fallar
public void errorDeInsersion() throws SQLException {
	dao.insertarAdministrador(admin);
	
}


@After
public void finalizar() {
	
}
}
