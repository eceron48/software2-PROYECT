package modelo;

import modelo.DAO.DAOAdministrador;

public class SAdministrador extends Persona {

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
	public DAOAdministrador gestionarAdministrador() {
		DAOAdministrador dao = new DAOAdministrador();
		return dao;
	}
}