package test.iniciarsecion;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Administrador;
import modelo.SAdministrador;
import vista.VistaIniciarSesion;

public class TestIniciarSceion {
;
	List<Administrador>admin;
	VistaIniciarSesion vlogin;
	Administrador ad;
	SAdministrador sdmin = new SAdministrador();
	
	
	@Before
	public void inicializar() {
		this.admin=new ArrayList<Administrador>();
		this.vlogin=new VistaIniciarSesion();
		this.ad=new Administrador();
	
	}
	@Test// se ingresa un usuario y contraseña correctos esto se valida con un false como respuesta de exito 
	public void loguinCorrecto() throws SQLException {
			vlogin.txtPassword.setText("admin");
			vlogin.txtUsuario.setText("admin");
			ad.setPass("admin");
			ad.setUsuario("admin");
			admin.add(ad);
			assertEquals(false, ad.ValidarAdministrador(admin, vlogin)); 
		
	}
	
	
	@Test // se ingresa un usuario y contraseña incorrectos esto se valida con un true como respuesta de fallo
	public void loguinInCorrecto() throws SQLException {
			vlogin.txtPassword.setText("contraseña");
			vlogin.txtUsuario.setText("administrador");
			ad.setPass("admin");
			ad.setUsuario("admin");
			admin.add(ad);
			assertEquals(true, ad.ValidarAdministrador(admin, vlogin)); 
		
	}
	
	
	@After
	public void Finalizar() {
		admin=null;
		ad=null;
		vlogin=null;
		sdmin=null;
	}

}
