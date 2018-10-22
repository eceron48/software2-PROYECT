package modelo.residente.builder;

import modelo.Persona;
import modelo.Residente;

public abstract class PersonaBuilder {
	
protected Residente persona;
	 
	public Residente obtenerPersona() {
		return persona;
	}
	 
		
	public abstract void construirNombre();
	public abstract void construirTelefono();
	public abstract void construirCedula();
	public abstract void construirapartamento();
	public abstract void construirparqueadero();

	
	

}
