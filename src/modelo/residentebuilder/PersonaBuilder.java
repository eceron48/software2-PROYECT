package modelo.residentebuilder;

import modelo.Persona;
import modelo.Residente;

public abstract class PersonaBuilder {
	
protected Residente persona;
	 
	public Residente obtenerPersona() {
		return persona;
	}
	 
		
	public abstract void construirPersona();
	public abstract void construirCuota();
	public abstract void construirVivienda();
	public abstract void construirParqueadero();
	
		
}
