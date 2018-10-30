package modelo.builder;

import modelo.Persona;
import modelo.Residente;

public abstract class PersonaBuilder {
	
protected Persona persona;
	 
	public Persona obtenerPersona() {
		return persona;
	}
	 
		
	public abstract void construirNombre();
	public abstract void construirTelefono();
	public abstract void construirCedula();
	public abstract void construirFechaEntrada();
	public abstract void construirFechaSalida();
	
	public abstract void construirRol();
		
	


	
	

}
