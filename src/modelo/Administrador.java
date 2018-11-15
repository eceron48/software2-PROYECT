package modelo;

import modelo.DAO.DAOApartamento;
import modelo.DAO.DAOCasa;
import modelo.DAO.DAOPagos;
import modelo.DAO.DAOParqueadero;
import modelo.DAO.DAOPersona;
import modelo.DAO.DAORegistrarCuota;
import modelo.DAO.DAOVivienda;
import modelo.residente.implementar.AsignarViviendaResidente;

public class Administrador extends Persona {
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

	public DAOPersona gestionarPersona() {
		DAOPersona dao = new DAOPersona();
		return dao;
	}

	public void DAOASEO() {

	}

	public void DAOMantenimiento() {

	}

	public void DAOVisitante() {

	}

	public DAOParqueadero DAOGestionarParqueadero() {
		DAOParqueadero parqueadero = new DAOParqueadero();
		return parqueadero;
	}

	public DAOPagos registrarPagos() {
		DAOPagos pago = new DAOPagos();
		return pago;
	}

	public DAORegistrarCuota registrarCuotaAdministracion() {
		DAORegistrarCuota dcuota = new DAORegistrarCuota();
		return dcuota;
	}


	public DAOCasa DAORegistrarCasa() {
		DAOCasa casa = new DAOCasa();
		return casa;

	}
	
	public DAOVivienda DAOMostrarVivienda () {
		DAOVivienda vivienda = new DAOVivienda();
		return vivienda;
		
	}
	
	public  DAOApartamento registrarVivienda () {
		 DAOApartamento daoapto = new  DAOApartamento ();
		return daoapto;
	}
	
	public AsignarViviendaResidente asignarTodoAResidente() {
		AsignarViviendaResidente DAO = new AsignarViviendaResidente();
		return DAO;
	}

}
