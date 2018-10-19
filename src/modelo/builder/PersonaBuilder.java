package modelo.builder;

import modelo.Persona;

public abstract class PersonaBuilder {
	
protected Persona persona;
	 
	public Persona obtenerPersona() {
		return persona;
	}
	public abstract void construirNombre();
	public abstract void construirDireccion();
	public abstract void construirTelefono();
	public abstract void construirCedula();
	public abstract void construirFechaEntrada();
	public abstract void construirFechaSalida();
	public abstract void construirapartamento();
	public abstract void construirparqueadero();
	

}
