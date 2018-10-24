package modelo;

import modelo.DAO.DAOApartamento;
import modelo.DAO.DAOCasa;
import modelo.DAO.DAORegistrarCuota;

public class Administrador {
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

	public Administrador() {

	}

	public void DAOResidente() {
		
		

	}

	public void DAOPropietario() {

	}

	public void DAOVijilancia() {

	}

	public void DAOASEO() {

	}

	public void DAOMantenimiento() {

	}

	public void DAOVisitante() {

	}

	public void DAOParqueadero() {

	}

	public DAORegistrarCuota registrarCuotaAdministracion() {
			DAORegistrarCuota dcuota=new DAORegistrarCuota();
			return dcuota;
	}

	public DAOApartamento DaoApartamento() {
		modelo.DAO.DAOApartamento dvv=new modelo.DAO.DAOApartamento();
		return dvv;
	}
	public DAOCasa DAORegistrarCasa() {
		DAOCasa casa=new DAOCasa();
		return casa;
		
	}

}
