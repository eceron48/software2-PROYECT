package modelo;

import modelo.DAO.DAOApartamento;
import modelo.DAO.DAOCasa;
import modelo.DAO.DAOPagos;
import modelo.DAO.DAOPersona;
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

	public void DAOVigilancia() {

	}
	public DAOPersona gestionarPersona () {
		 DAOPersona dao =  new DAOPersona ();
		 return dao;
	}

	public void DAOASEO() {

	}

	public void DAOMantenimiento() {

	}

	public void DAOVisitante() {

	}

	public void DAOParqueadero() {

	}
	
	
	public DAOPagos registrarPagos() {
		DAOPagos pago=new DAOPagos();
		return pago;
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
