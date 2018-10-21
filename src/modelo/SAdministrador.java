package modelo;

public class SAdministrador extends Persona{
	public SAdministrador(String nombre, String cedula, int telefono) {
		super(nombre, cedula, telefono);
		// TODO Auto-generated constructor stub
	}


	private String usuario;
	private String pass;
	
	
public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}



//------------------gestiona administradores -----//
public void DAOAdministrador() {
	
}

}
